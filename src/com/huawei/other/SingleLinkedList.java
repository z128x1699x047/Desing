package com.huawei.other;
//单链表--增删需要当前节点的前后2个节点    查询修改只需要当前的一个节点
public class SingleLinkedList<T> {
	Node list;//头节点
	int size;
	//put
	public void put(int index,T data){
		checkOutOfIndex(index);//通用的判断下表越界
		//保存要插入节点的前后两个节点
		Node cur = list;
		Node head = list;
		for(int i=0;i<=index;i++){//把头节点不断往后移
			head=cur;
			cur=cur.next;
		}
		//准备插入操作
		Node node = new Node(data,cur);
		head.next=node;
		size++;
	}	
	public void put(T data){
		//--头插法    尾插法--遍历尾部麻烦
		Node head = list;
		Node curNode = new Node(data,list);
		list = curNode;		
		size++;
	}
	//move 删头
	public T remove(){
		if(list != null){
			Node node = list;
			list = list.next;
			node.next = null;//gc 防止内存泄漏
			size--;
			return node.data;
		}
		return null;
	}
	//update
	public void set(int index,T newData){
		checkOutOfIndex(index);
		Node head=list;
		for(int i=0;i<index;i++){
			head=head.next;
		}
		head.data=newData;
	}
	//get
	public T get(int index){
		checkOutOfIndex(index);
		Node node = list;
		for(int i=0;i<=index;i++){//把头节点不断往后移
			node=node.next;
		}
		return node.data;
	}
	//单节点
	class Node {
		T data;
		Node next;
		public Node(T data,Node node){
			this.data=data;
			this.next=node;
		}
	}
	
	protected void checkOutOfIndex(int index){
		if(!(index>=0 && index<=size)){
			throw new IndexOutOfBoundsException("下标越界异常");
		}
	}
	public SingleLinkedList (){
		size = 0;
	}
}
