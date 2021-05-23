package com.huawei.action.strategy;

public class DiscountSencond implements Discount {

	@Override
	public int calculate(int money) {
		System.out.println("DiscountSencond:优惠减免0.1折");
		Double balance = money * 0.9;
		return balance.intValue();
	}

}
