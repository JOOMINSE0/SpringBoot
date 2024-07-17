package com.apple.shop.item;

import org.springframework.data.jpa.repository.JpaRepository;

//1. Repository만들기
//2. 원하는 클래스에 repository 등록
public interface ItemRepository extends JpaRepository<Item, Long> {
}