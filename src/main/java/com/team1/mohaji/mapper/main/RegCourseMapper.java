package com.team1.mohaji.mapper.main;

import com.team1.mohaji.dto.RegCourseDto;
import com.team1.mohaji.dto.SubjectDto;
import com.team1.mohaji.entity.RegCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegCourseMapper {
    List<SubjectDto> selectAllSubject(String memberId);
    List<SubjectDto> selectCategory(String category, String memberId);
    List<SubjectDto> selectAllSearch(String category, String keyword, String memberId);
    List<SubjectDto> selectKeyword(String keyword, String memberId);
    List<SubjectDto> selectSubjectByRegStat(int memberId);
    void insertReg(int memberId, int subId, String rcStat);
    void updateRegCourse(int memberId, int subId);

    String selectRegCourseByRegStat(int memberId, int subId);

    int selectCountSubject();

}
