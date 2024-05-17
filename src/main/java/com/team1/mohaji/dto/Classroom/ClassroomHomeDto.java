package com.team1.mohaji.dto.Classroom;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClassroomHomeDto {
        private int memberId;
        private String sessionSnum;
        private String sessionTitle;
        private LocalDateTime sessionSdate;
        private LocalDateTime sessionEdate;
        private String rsProgress;
        private String subId;
        private String videoYcode;

}
