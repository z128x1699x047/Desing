package com.huawei.create;
/**
 * 水果套餐类
 */
public class FruitMeal {

	private Apple apple;
	private Banana banana;
	private Orange orange;
	
	private int discount;
	
	private int totalPrice;//套餐价格

	public void setApple(Apple apple) {
		this.apple = apple;
	}

	public void setBanana(Banana banana) {
		this.banana = banana;
	}

	public void setOrange(Orange orange) {
		this.orange = orange;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int cost() {
		return this.totalPrice;
	}
	
	public void init(){
		if(null!=apple){
			totalPrice += apple.price();
		}
		if(null!=banana){
			totalPrice += banana.price();
		}
		if(null!=orange){
			totalPrice += orange.price();
		}
		if(totalPrice>0){
			totalPrice -= discount;
		}	
	}
	
	public void showItems(){
		System.out.println("totalPrice:"+totalPrice);
	}
	
} 
