package com.team1.mohaji.service.imple;

import com.team1.mohaji.dto.Dto;
import com.team1.mohaji.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceImple implements com.team1.mohaji.service.Service {
    @Autowired
    Mapper memberMapper;

    @Override
    public Dto findMemberByNum(long num) {
        Dto memberDto = memberMapper.selectMemberByNum(num);
        return memberDto;

    }
}
