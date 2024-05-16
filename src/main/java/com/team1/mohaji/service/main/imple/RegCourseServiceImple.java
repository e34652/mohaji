package com.team1.mohaji.service.main.imple;



import com.team1.mohaji.dto.SubjectDto;
import com.team1.mohaji.mapper.main.RegCourseMapper;
import com.team1.mohaji.service.main.RegCourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Slf4j
@Service
public class RegCourseServiceImple implements RegCourseService {

    @Autowired
    private RegCourseMapper regCourseMapper;

    @Override
    public List<SubjectDto> selectAllSubject() {
//        log.info("imple 도착");
        return regCourseMapper.selectAllSubject();
    }

    @Override
    public List<SubjectDto> selectCategory(String category) {
        return regCourseMapper.selectCategory(category);
    }

    @Override
    public List<SubjectDto> selectAllSearch(String category, String keyword) {
        System.out.println("서비스로 왔다"+category+keyword);
        return regCourseMapper.selectAllSearch(category,keyword);

    }

    @Override
    public List<SubjectDto> selectKeyword(String keyword) {
        return regCourseMapper.selectKeyword(keyword);
    }

    @Override
    public int selectCount() {
        return regCourseMapper.selectCountSubject();
    }
}
