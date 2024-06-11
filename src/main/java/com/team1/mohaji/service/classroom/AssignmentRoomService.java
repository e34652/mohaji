package com.team1.mohaji.service.Classroom;

import com.team1.mohaji.dto.classroom.AssignmentDto;
import com.team1.mohaji.dto.classroom.RegAssignmentDto;

import java.util.List;

public interface AssignmentRoomService {

    public AssignmentDto selectAssignment(int asgnId);
    public List<AssignmentDto> selectAssignmentList(int memberId);
    public String selectSubName(int subId);
    public void insertRegAsgn(RegAssignmentDto regAssignmentDto);
    public RegAssignmentDto selectRegAsgn(int memberId, int subId, int asgnId);
    public int countRegAsgn(int subId, int memberId, int asgnId);

    public void updateRegAsgn(RegAssignmentDto regAssignmentDto);
}
