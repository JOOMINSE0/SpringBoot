package com.apple.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		var test = new Friend("lee");
		System.out.println(test.name);

	}
}
class Friend{
	String name = "ju";
	int age = 22;
	Friend(String 작명){ //constructor / new Friend 할 때 자동 실행됨
		this.name = 작명; //this는 새로 생성될 object
	}
}

