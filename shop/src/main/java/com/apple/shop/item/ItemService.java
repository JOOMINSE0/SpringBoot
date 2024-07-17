package com.apple.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price){
        Item item  =  new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
        // DB입출력 3step
        // 1. repository interface 만들고
        // 2. 등록하고
        // 3. 사용
    }

}
