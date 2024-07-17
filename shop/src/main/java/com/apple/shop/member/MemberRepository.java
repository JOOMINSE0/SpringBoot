package com.apple.shop.member;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    //Derived query mrthods
    Optional<Member> findByUsername(String username);
}
