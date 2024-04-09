package com.apple.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
		final String lover = "주민서"; //final키워드 붙이면 변경 불가능
		final int age = 22; //type대신 var키워드 가능
		System.out.println(lover);
		System.out.println(age);



	}
}
