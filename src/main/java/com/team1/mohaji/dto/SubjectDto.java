package com.team1.mohaji.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubjectDto {

        private int subId;
        private String deptName;
        private String subName;  //조인 sub
        private String name;  //조인 prof-member
        private String subType;
        private String subDesc;
        private int subScount;
        private int subCredit;
        private LocalDateTime subRsdate;
        private LocalDateTime subRedate;
        private LocalDateTime subSdate;
        private LocalDateTime subEdate;

        // Getters and setters
}
