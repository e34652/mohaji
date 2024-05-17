package com.team1.mohaji.service.Classroom;

import com.team1.mohaji.dto.Classroom.ClassroomHomeDto;


import java.util.List;

public interface ClassroomHomeService {

    public List<ClassroomHomeDto> sessionListInProgress(int subId, int memberId);
}
