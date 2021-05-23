package com.huawei.other;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadWaitNotify {

	//容器
	private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(20);
	
	private final int proNum ;
	
	private final int xiaNum ;
	//生产线程组
	private Thread[] pro;
	//消费线程组
	private Thread[] xia;
	
	public ThreadWaitNotify (int proNum,int xiaNum){
		this.proNum = proNum;
		this.xiaNum = xiaNum;
		pro = new Thread[proNum];
		xia = new Thread[xiaNum];
		for(int i=0;i<proNum;i++){
			pro[i]=new Thread();
			pro[i].start();
		}
		for(int i=0;i<xiaNum;i++){
			xia[i]=new Thread();
			xia[i].start();
		}
	}
    class ProThread extends Thread {
		@Override
		public void run() {			
			try {
				Runnable r = null;
				//r = queue.put(new Task());
				Thread.sleep(1000);
				r.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
    
    /*public void add (Runnable task){
    	synchronized (queue) {
    		queue.add(task);
		}
    }*/
    
    class XiaThread extends Thread {
		@Override
		public void run() {			
			try {
				Runnable r = null;
				r = queue.take();
				r.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
    
	//任务类
    class Task implements Runnable {
    	//private String name;
    	private Random r = new Random();
    	/*public Task(String name){
    		this.name = name;
    	}*/
		@Override
		public void run() {
			try {
				Thread.sleep(r.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    	
    }
	public static void main(String[] args) {
		
	}
}


