package com.team1.mohaji.service.main.imple;



import com.team1.mohaji.dto.RegCourseDto;
import com.team1.mohaji.mapper.main.RegCourseMapper;
import com.team1.mohaji.service.main.RegCourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegCourseServiceImple implements RegCourseService {

    @Autowired
    private RegCourseMapper regCourseMapper;

    @Override
    public List<RegCourseDto> selectAllRegCourse() {
        regCourseMapper.selectAllRegCourse();
        return regCourseMapper.selectAllRegCourse();
    }
}
