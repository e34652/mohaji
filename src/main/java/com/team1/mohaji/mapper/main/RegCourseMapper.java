package com.team1.mohaji.mapper.main;

import com.team1.mohaji.dto.RegCourseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RegCourseMapper {

    @Select("select * from reg_course")
    List<RegCourseDto> selectAllRegCourse();

}
