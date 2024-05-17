package com.team1.mohaji.service.Classroom.imple;


import com.team1.mohaji.dto.Classroom.ClassroomHomeDto;
import com.team1.mohaji.mapper.Classroom.ClassroomHomeMapper;
import com.team1.mohaji.service.Classroom.ClassroomHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomHomeHomeServiceImple implements ClassroomHomeService {
    @Autowired
    ClassroomHomeMapper classroomHomeMapper;


    @Override
    public List<ClassroomHomeDto> sessionListInProgress(int subId, int memberId) {
        List<ClassroomHomeDto> rsList = classroomHomeMapper.selectRegSessionList(subId, memberId);
        return rsList;
    }
}



