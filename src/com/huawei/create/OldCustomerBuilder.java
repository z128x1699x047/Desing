package com.huawei.create;

public class OldCustomerBuilder implements Builder {

	private FruitMeal fruitMeal = new FruitMeal();
	
	@Override
	public void buildApple(int price) {
		Apple apple = new Apple();
		apple.setPrice(price);
		fruitMeal.setApple(apple);
	}

	@Override
	public void buildBanana(int price) {
		Banana banana = new Banana();
		banana.setPrice(price);
		fruitMeal.setBanana(banana);
	}

	@Override
	public void buildOrange(int price) {
		Orange orange = new Orange();
		orange.setPrice(price);
		fruitMeal.setOrange(orange);
	}

	@Override
	public FruitMeal getFruitMeal() {
		fruitMeal.setDiscount(10);  //θΏιε
		fruitMeal.init();
		return fruitMeal;
	}

}
