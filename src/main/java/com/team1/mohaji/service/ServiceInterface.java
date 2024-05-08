package com.team1.mohaji.service;

import com.team1.mohaji.dto.MemberDto;
import com.team1.mohaji.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface ServiceInterface {

    public MemberDto findMemberByNum(long num);
}
