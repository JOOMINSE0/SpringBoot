package com.apple.shop.member;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
