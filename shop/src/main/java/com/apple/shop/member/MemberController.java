package com.apple.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/register")
    String register(){
        return "register.html";
    }

    @PostMapping("/member")
    String addMember(
            String username,
            String password,
            String displayName
    ) {
        //유저가 보낸 아이디 비번을 DB에 저장
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(new BCryptPasswordEncoder().encode(password)); //비번 해싱하기
        member.setDisplayName(displayName);
        memberRepository.save(member);
        return "redirect:/list";
    }
}
