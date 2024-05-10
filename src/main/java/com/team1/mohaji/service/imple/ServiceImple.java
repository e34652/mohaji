<<<<<<<< HEAD:src/main/java/com/team1/mohaji/service/imple/Service.java
//package com.team1.mohaji.service.imple;
//
//import com.team1.mohaji.dto.MemberDto;
//import com.team1.mohaji.mapper.MemberMapper;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.lang.reflect.Member;
//@org.springframework.stereotype.Service
//
//    @Autowired
//MemberMapper memberMapper;
//
//    @Override
//    public MemberDto findMemberByNum(long num) {
//
//        return memberDto;
//
//    }
//}
========
package com.team1.mohaji.service.imple;

import com.team1.mohaji.dto.MemberDto;
import com.team1.mohaji.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceImple implements com.team1.mohaji.service.Service {
    @Autowired
MemberMapper memberMapper;

    @Override
    public MemberDto findMemberByNum(long num) {
        MemberDto memberDto = memberMapper.selectMemberByNum(num);
        return memberDto;

    }
}
>>>>>>>> main:src/main/java/com/team1/mohaji/service/imple/ServiceImple.java
