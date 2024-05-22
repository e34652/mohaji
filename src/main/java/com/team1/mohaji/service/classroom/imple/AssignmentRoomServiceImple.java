package com.team1.mohaji.service.classroom.imple;

import com.team1.mohaji.dto.classroom.AssignmentDto;
import com.team1.mohaji.dto.classroom.RegAssignmentDto;
import com.team1.mohaji.mapper.classroom.AssignmentRoomMapper;
import com.team1.mohaji.service.classroom.AssignmentRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentRoomServiceImple implements AssignmentRoomService {

    @Autowired
    AssignmentRoomMapper assignmentRoomMapper;

    public void updateRegAsgn(RegAssignmentDto regAssignmentDto){
        assignmentRoomMapper.updateRegAsgn(regAssignmentDto);
    }
    public int countRegAsgn(int memberId,int subId , int asgnId){
        int result = assignmentRoomMapper.countRegAsgn(memberId, subId, asgnId);
        return result;
    }


    @Override
    public AssignmentDto selectAssignment(int asgnId) {
        AssignmentDto asgn = assignmentRoomMapper.selectAssignment(asgnId);
        return asgn;
    }
    @Override
    public List<AssignmentDto> selectAssignmentList(int memberId) {
        List<AssignmentDto>asgnList = assignmentRoomMapper.selectAssignmentList(memberId);
        return asgnList;
    }

    @Override
    public String selectSubName(int subId) {
        String subName = assignmentRoomMapper.selectSubName(subId);
        return subName;
    }


    @Override
    public void insertRegAsgn(RegAssignmentDto regAssignmentDto) {
        assignmentRoomMapper.insertRegAsgn(regAssignmentDto);
    }
}
