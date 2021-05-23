package com.huawei.action.strategy;

import java.util.ArrayList;
import java.util.List;

import com.huawei.create.Fruit;

public abstract class ShoppingCart {

	private Discount discount;//策略
	private List<Fruit> products = new ArrayList<>();
	
	public ShoppingCart(List<Fruit> products){
		this.products = products;
	}
	
	public void setDiscount(Discount discount){
		this.discount = discount;
	}
	
	//主流程
	public void submitOrder(){
		int money = balance();
		System.out.println("商品总金额为："+money+"元");
		money = discount.calculate(money);
		System.out.println("优惠后价格："+money+"元");
	}
	
	private int balance(){
		int money = 0;
		for(Fruit fruit:products){
			fruit.draw();
		}
		return money;
	}
}
