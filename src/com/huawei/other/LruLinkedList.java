package com.huawei.other;

public class LruLinkedList<T> extends SingleLinkedList<T> {
	int memory_size;//限制内存空间大小，缓存大小
	static final int DEFAULT_CAP = 5;
	public LruLinkedList(){
		this(DEFAULT_CAP);
	}
	public LruLinkedList(int memory_size){
		this.memory_size = memory_size;
	}
	//Lru访问
	public T lruGet(int index){
		checkOutOfIndex(index);
		Node node = list;//访问的节点
		Node pre = list;
		for(int i=0;i<index;i++){
			pre=node;
			node=node.next;
		}
		T result = node.data;
		//将访问的节点移到表头
		pre.next=node.next;
		Node head = list;
		list = node;
		return result;
	}
	
	//lru添加
	public void lruPut(T data){
		if(size >= memory_size){
			//removeLast();
			put(data);
		}else{
			put(data);
		}
	}
	
}
