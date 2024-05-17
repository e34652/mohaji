package com.team1.mohaji.mapper.Classroom;

import com.team1.mohaji.dto.Classroom.ClassroomHomeDto;
import com.team1.mohaji.dto.myPage.RegListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassroomHomeMapper {
    public List<ClassroomHomeDto> selectRegSessionList(@Param("subId")int subId , @Param("memberId")int memberId);
}

