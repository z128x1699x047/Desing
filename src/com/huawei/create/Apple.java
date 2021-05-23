package com.huawei.create;

public class Apple implements Fruit{

	private int price =100;
    
	public Apple() {
		super();
	}

	public Apple(int price) {
		super();
		this.price = price;
	}

	@Override
	public int price() {
		return price;
	}

	@Override
	public void draw() {
		System.out.println("我是红苹果");
	}

	@Override
	public void setPrice(int price) {
		this.price=price;
	}
}
