package com.team1.mohaji.service.main;

import com.team1.mohaji.dto.SubjectDto;

import java.util.List;

public interface RegCourseService {

    public List<SubjectDto> selectAllSubject();

    public List<SubjectDto> selectCategory(String category);

    public List<SubjectDto> selectAllSearch(String category, String keyword);

    public List<SubjectDto> selectKeyword(String keyword);

    public int selectCount();

}
