package com.team1.mohaji.mapper.main;

import com.team1.mohaji.dto.SubjectDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegCourseMapper {
    List<SubjectDto> selectAllSubject();
    List<SubjectDto> selectCategory(String category);
    List<SubjectDto> selectAllSearch(String category, String keyword);
    List<SubjectDto> selectKeyword(String keyword);

    int selectCountSubject();

}
