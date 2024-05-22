package com.team1.mohaji.mapper.classroom;

import com.team1.mohaji.dto.classroom.AssignmentDto;
import com.team1.mohaji.dto.classroom.RegAssignmentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssignmentRoomMapper {

    public int countRegAsgn(int memberId, int subId, int asgnId);
    public AssignmentDto selectAssignment(int asgnId);
    public List<AssignmentDto> selectAssignmentList(int memberId);

    public String selectSubName(int subId);

    public void insertRegAsgn(RegAssignmentDto regAssignmentDto);
    public void updateRegAsgn(RegAssignmentDto regAssignmentDto);

}
