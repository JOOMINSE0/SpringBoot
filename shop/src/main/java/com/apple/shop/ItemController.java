package com.apple.shop; //현재 파일의 경로

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller //api만들 수 있음
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository; //DB입출력함수 들어있음
    private final ItemService itemService; //사용할 곳에서 변수로 등록하기

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

        itemService.saveItem(title, price);
        return "redirect:/list";

    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long  id, Model model){

        Optional<Item> result = itemRepository.findById(id); // Optional은 null일 수도 있고 아닐 수도 있다는 타입
        if ( result.isPresent() ){ //Optional 타입은 출력하기 전에 값이 존재하는지 체크해야 함
            model.addAttribute("data", result.get());
            return "detail.html";
        } else{
            return "redirect:/list";
        }

    }

    //수정 페이지
    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable Long id){

        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("data", result.get());
            return "edit.html";
        } else{
            return "redirect:/list";
        }
    }

    @PostMapping("/edit")
    String editItem(String title,Integer price, Long id){
        Item item = new Item();
        //서버에서 모르는 정보는 유저에게 보내라고 하기 or DB조회하기
        item.setId(id);
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    return "redirect:/list";
    }

}
