package com.huawei.create;

public class Banana implements Fruit {

private int price =110;
    
	public Banana() {
		super();
	}

	public Banana(int price) {
		super();
		this.price = price;
	}

	@Override
	public int price() {
		return price;
	}

	@Override
	public void draw() {
		System.out.println("我是黄香蕉");
	}

	@Override
	public void setPrice(int price) {
		this.price=price;
	}

}
