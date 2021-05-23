package com.huawei.create;
/**
 * 类似工厂
 * @author zhangxinxing
 * 下面可以有多个不同的套餐实现类
 */
public interface Builder {

	void buildApple(int price);
	void buildBanana(int price);
	void buildOrange(int price);
	
	FruitMeal getFruitMeal();//返回创建套餐
}
