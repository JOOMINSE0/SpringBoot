package com.apple.shop;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//테이블 생성
@Entity
@ToString
@Setter
@Getter
public class Item {
    //테이블에 어떤 컬럼이 들어갈지도 먼저 정해야 함
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    //@Column()으로 컬럼에 제약설정 가능
    private String title; //변수에 public을 붙이면 다른 모든 클래스에서 문제없이 사용 가능
    private Integer price; //20억까지 저장 가능


}

