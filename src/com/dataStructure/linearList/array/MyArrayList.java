package com.dataStructure.linearList.array;

public class MyArrayList<T> {

	public static void main(String[] args) {

	}
	
	Object[] object;
	private static final int size=10;
	
	public MyArrayList (){
		object=new Object[size];
	}
	
	public MyArrayList (int cap){
		if(cap>0){
			object=new Object[cap];
		}else if(cap==0){
			object=new Object[size];
		}else{
			throw new IllegalArgumentException("Illegal cap: "+cap);
		}		
	}
	
	public T get(){
		
		return (T) new Object();
	}
	
}
