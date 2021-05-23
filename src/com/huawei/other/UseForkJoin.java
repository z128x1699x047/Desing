package com.huawei.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 用集合替代sql，map作为sql的条件(放了批量的工号)
 * @author zhangxinxing
 *
 */
public class UseForkJoin {

	
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		List<Integer> list = caculate();
		Map map = new HashMap();
		map.put("gx", "sqlWhere");
		MyTask task = new MyTask(list,map);
		pool.submit(task);
		Integer result = task.join();
		System.out.println(result);
//		int count = 0;
//		for(int i=1;i<=1000;i++){
//			count+=i;
//		}
//		System.out.println(count);//500500
	}
	
	static class MyTask extends RecursiveTask<Integer> {//把list中的值刷到map中即可
		private List<Integer> list;//所有的工号
		private Map map;//分成批量的工号		
		public MyTask(List<Integer> list, Map map) {
			this.list = list;
			this.map = map;
		}
		@Override
		protected Integer compute() {
			int count = 0;
			if(list.size()>=300){//集合最大容量300,继续分解
				int middle = list.size()/2;
				Map hasLeft = new HashMap();
				hasLeft.put("key", list.subList(0, middle));
				MyTask left = new MyTask(list.subList(0, middle),hasLeft);
				Map hasRight = new HashMap();
				hasRight.put("key", list.subList(middle, list.size()));
				MyTask right = new MyTask(list.subList(middle, list.size()),hasRight);
				invokeAll(left,right);
				return left.join()+right.join();
			}else{//小于300，统计
				List<Integer> list = (List<Integer>)map.get("key");	
				for(Integer in:list){
					count += in;
				}
				System.out.println(list);
			}
			return count;
		}	
	}
	ConcurrentHashMap map = new ConcurrentHashMap();
	//生产批量的工号
	static private List<Integer> caculate(){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=1000;i++){
			list.add(i);
		}
		return list;
	}

}
