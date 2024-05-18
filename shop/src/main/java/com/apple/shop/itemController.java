package com.apple.shop; //현재 파일의 경로

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //api만들 수 있음
public class itemController {

    @GetMapping("/list")
    String list(Model model){
        model.addAttribute("name", "주민서");
        return "list.html";
    }

}
