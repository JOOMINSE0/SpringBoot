package com.apple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller //스프링프레임워크가 메인함수로 아래의 코드들을 넣어줌(controller의 역할)
public class BasicController {
    @GetMapping("/") //메인페이지 접속하면
//    @ResponseBody
    String hello(){
        return "index.html"; //"안녕하세요"보여줌
    }

    @GetMapping("/about") //메인페이지 접속하면
    @ResponseBody
    String about(){
        return "피싱사이트에요"; //"안녕하세요"보여줌
    }


    @GetMapping("/date") //메인페이지 접속하면
    @ResponseBody
    String date(){
        LocalDateTime now = LocalDateTime.now();
        return now.toString(); //"안녕하세요"보여줌
    }

}
