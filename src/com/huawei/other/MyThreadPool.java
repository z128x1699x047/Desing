package com.huawei.other;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {

	public static void main(String[] args) {
		
	}

	//1.任务容器
	private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(20);
	//2.线程容器
	private WorkTask[] threads;
	//3.核心线程数
	private final int count;
	//默认线程数
	private static int coreThread=Runtime.getRuntime().availableProcessors();
	//初始化
	public MyThreadPool(){
		this.count=coreThread;
		for(int i=0;i<coreThread;i++){
			threads[i]=new WorkTask();
			threads[i].start();
		}
	}
	public MyThreadPool(int count){
		this.count=count;
		for(int i=0;i<count;i++){
			threads[i]=new WorkTask();
			threads[i].start();
		}
	}
	
	//任务  
	static class WorkTask extends Thread{
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
			
		}
	}
	//添加任务
	
	//执行任务
	
}
