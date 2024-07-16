package com.apple.shop; //현재 파일의 경로

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<String> detail(@PathVariable Long  id, Model model) {

        try{
         throw new Exception();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("에러");
            //유저 잘못 400
            //서버 잘못 500
            //정상 작동 200
        }
    }
}
