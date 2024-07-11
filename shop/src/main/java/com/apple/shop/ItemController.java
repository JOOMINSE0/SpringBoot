package com.apple.shop; //현재 파일의 경로

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    String addPost(@RequestParam Map formData) {
        //Map자료형(여러 데이터 한 변수에 넣고 싶을 때)
        var test = new HashMap<>();
        test.put("name", "ju");
        test.put("age", "22");
        System.out.println(test.get("name")); //Map에서 자료 하나만 뽑으려면
        itemRepository.save();
        return "redirect:/list";

    }




}
