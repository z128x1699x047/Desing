package com.huawei.action.strategy;

public class DiscountFull implements Discount {

	@Override
	public int calculate(int money) {
		if(money>200){
			System.out.println("DiscountFull:δΌζ εε20");
			return money-20;
		}
		return money;
	}

}
