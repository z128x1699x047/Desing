package com.huawei.create;

public class Orange implements Fruit {

private int price =120;
    
	public Orange() {
		super();
	}

	public Orange(int price) {
		super();
		this.price = price;
	}

	@Override
	public int price() {
		return price;
	}

	@Override
	public void draw() {
		System.out.println("我是金橘子");
	}

	@Override
	public void setPrice(int price) {
		this.price=price;
	}
	
}
