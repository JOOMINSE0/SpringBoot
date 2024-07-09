package com.apple.shop; //현재 파일의 경로

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller //api만들 수 있음
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository; //DB입출력함수 들어있음

    @GetMapping("/list")
    String list(Model model){
        List<Item> result = itemRepository.findAll(); //List자료형으로 가져옴
        model.addAttribute("items", result);
        var a = new Item();
        System.out.println(a.toString()); //object 한눈에 보고싶으면 .toStrind()만들어서 쓰기
        return "list.html";
    }

}
