package com.apple.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
	Test test = new Test(); //class 복사본은 object라고 부름, 클래스도 일종의 자료형 역할 가능
	System.out.println(test.name);
	}
}

class Test{
	//class 안의 변수는 field / attribute
	//class 안의 함수는 method
	String name = "ju";
	void hello(){
		System.out.println("안녕");
	}
}