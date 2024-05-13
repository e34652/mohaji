package com.team1.mohaji.controller;

import com.team1.mohaji.entity.Member;
import com.team1.mohaji.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    private MemberRepository memberRepository;
    private PasswordEncoder passwordEncoder;

    public RegisterController(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Member user) {
        Member savedUser = null;
        ResponseEntity response = null;
        try {
            String hashPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);

            savedUser = memberRepository.save(user);
            if (savedUser.getId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("사용자 등록 성공");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Exception 발생 " + ex.getMessage());
        }
        return response;
    }

}
