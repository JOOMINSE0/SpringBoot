package com.apple.shop; //현재 파일의 경로

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller //api만들 수 있음
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository; //DB입출력함수 들어있음

    @GetMapping("/list")
    String list(Model model){
        List<Item> result = itemRepository.findAll(); //List자료형으로 가져옴
        model.addAttribute("items", result);
//        var a = new Item();
//        System.out.println(a.toString()); //object 한눈에 보고싶으면 .toStrind()만들어서 쓰기
        return "list.html";
    }

    @GetMapping("/write")
    String write(){
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(String title, Integer price) {
    Item item  =  new Item();
    item.setTitle(title);
    item.setPrice(price);
    itemRepository.save(item);

        return "redirect:/list";

    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long  id, Model model) {
        System.out.println(id);
        Optional<Item> result = itemRepository.findById(id); // Optional은 null일 수도 있고 아닐 수도 있다는 타입
        if ( result.isPresent() ){ //Optional 타입은 출력하기 전에 값이 존재하는지 체크해야 함
            model.addAttribute("data", result.get());
            return "detail.html";
        } else{
            return "redirect:/list";
        }

    }




}
