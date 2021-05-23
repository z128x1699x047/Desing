package com.huawei.other;

class A {
	static {
		System.out.println("1");
	}
	public A(){
		System.out.println("2");
	}
}
class B extends A{
	static{
		System.out.println("a");
	}
	public B(){
		System.out.println("b");
	}
}
public class Hello{
	public static void main(String[] args) {
		A ab = new B();
		ab = new B();
	}
}