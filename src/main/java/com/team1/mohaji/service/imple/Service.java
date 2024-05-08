package com.team1.mohaji.service.imple;

import com.team1.mohaji.dto.MemberDto;
import com.team1.mohaji.mapper.MemberMapper;
import com.team1.mohaji.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Member;
@org.springframework.stereotype.Service
public class Service implements ServiceInterface{
    @Autowired
MemberMapper memberMapper;

    @Override
    public MemberDto findMemberByNum(long num) {
        MemberDto memberDto = memberMapper.selectMemberByNum(num);
        return memberDto;

    }
}
