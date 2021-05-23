package com.huawei.create;
/**
 * 导演类
 * @author zhangxinxing
 *
 */
public class FruitMealController {

	public void construct(){
		//Builder builder = new HolidayBuilder();
		Builder builder = new OldCustomerBuilder();
		
		builder.buildApple(100);
		builder.buildBanana(80);
		builder.buildOrange(50);
		
		FruitMeal fruitMeal = builder.getFruitMeal();
		int cost = fruitMeal.cost();
		System.out.println("本套餐花费："+cost);
	}
	
	public static void main(String[] args) {
		new FruitMealController().construct();
	}
}
