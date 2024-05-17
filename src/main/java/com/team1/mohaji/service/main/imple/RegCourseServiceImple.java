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
    public List<SubjectDto> selectAllSubject(String memberId) {
        return regCourseMapper.selectAllSubject(memberId);
    }

    @Override
    public List<SubjectDto> selectCategory(String category, String memberId) {
        return regCourseMapper.selectCategory(category,memberId);
    }

    @Override
    public List<SubjectDto> selectAllSearch(String category, String keyword, String memberId) {
        return regCourseMapper.selectAllSearch(category,keyword,memberId);
    }

    @Override
    public List<SubjectDto> selectKeyword(String keyword, String memberId) {
        return regCourseMapper.selectKeyword(keyword,memberId);
    }


    @Override
    public List<SubjectDto> selectSubjectByRegStat(int memberId) {
       return regCourseMapper.selectSubjectByRegStat(memberId);
    }

    @Override
    public String selectRegCourseByRegStat(int memberId, int subId) {
        return regCourseMapper.selectRegCourseByRegStat(memberId, subId);
    }

    @Override
    public void insertReg(int memberId, int subId, String rcStat) {
       regCourseMapper.insertReg(memberId,subId,rcStat);
    }

    @Override
    public void updateRegCourse(int memberId, int subId) {
        regCourseMapper.updateRegCourse(memberId, subId);
    }


    @Override
    public int selectCount() {
        return regCourseMapper.selectCountSubject();
    }
}
