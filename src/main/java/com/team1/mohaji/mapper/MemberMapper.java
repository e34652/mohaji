package com.team1.mohaji.mapper;

import com.team1.mohaji.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
    @Mapper
    public interface MemberMapper {
        public MemberDto selectMemberByNum(long num);
}
