

CREATE TABLE `department` (
                              `dept_id`	int	NOT NULL	COMMENT 'PK/auto',
                              `dept_name`	varchar(60)	NOT NULL,
                              `dept_desc`	varchar(30)	NULL,
                              `dept_credit`	int	NOT NULL
);

CREATE TABLE `subject` (
                           `sub_id`	int	NOT NULL	COMMENT 'PK/auto',
                           `dept_id`	int	NOT NULL	COMMENT 'FK',
                           `pro_id`	int	NOT NULL	COMMENT 'FK',
                           `sub_name`	varchar(90)	NOT NULL,
                           `sub_type`	varchar(15)	NOT NULL,
                           `sub_desc`	varchar(300)	NULL,
                           `sub_scount`	int	NOT NULL	COMMENT '진도율에쓰임',
                           `sub_credit`	int	NOT NULL	COMMENT '2or3'
);

CREATE TABLE `reg_course` (
                              `stu_id`	int	NOT NULL	COMMENT 'PK',
                              `sub_id`	int	NOT NULL	COMMENT 'PK/auto',
                              `rc_stat`	varchar	NULL	COMMENT '수강중/이수/수강취소',
                              `rc_progress`	decimal(4,1)	NOT NULL	DEFAULT 0
);

CREATE TABLE `reg_detail` (
                              `stu_id2`	int	NOT NULL	COMMENT 'PK',
                              `sub_id`	int	NOT NULL	COMMENT 'PK/auto',
                              `rd_adate`	timestamp	NOT NULL,
                              `rd_cdate`	timestamp	NULL,
                              `rd_creason`	varchar(100)	NULL	COMMENT 'in('휴학','과목변경', '기타개인사유')'
);

CREATE TABLE `reg_session` (
                               `stu_id`	int	NOT NULL	COMMENT 'PK',
                               `sub_id`	int	NOT NULL	COMMENT 'PK/auto',
                               `session_ID`	int	NOT NULL	COMMENT 'PK/auto',
                               `rs_progress`	decimal(4,1)	NOT NULL	DEFAULT 0,
                               `rs_max`	int	NOT NULL	DEFAULT 0,
                               `rs_current`	int	NOT NULL	DEFAULT 0,
                               `rs_end`	int	NOT NULL	DEFAULT 0
);

CREATE TABLE `session` (
                           `session_ID`	int	NOT NULL	COMMENT 'PK/auto',
                           `sub_id`	int	NOT NULL	COMMENT 'PK/auto',
                           `video_id`	int	NOT NULL	COMMENT 'FK',
                           `session_title`	varchar	NOT NULL,
                           `session_snum`	int	NOT NULL	COMMENT '정렬용'
);

CREATE TABLE `criteria_common` (
                                   `ct_id`	varchar(30)	NOT NULL	COMMENT 'PK/a1,a2,b1처럼 코드로 구분',
                                   `ct_title`	varchar(30)	NOT NULL	COMMENT 'ex) 학점성적기준'
);

CREATE TABLE `criteria_detail` (
                                   `cv_id`	varchar(30)	NOT NULL	COMMENT '순서확인',
                                   `ct_id`	varchar(30)	NOT NULL	COMMENT '구분코드',
                                   `cv_title`	varchar(60)	NOT NULL,
                                   `cv_value1`	int	NULL	COMMENT 'db에서 연산시 int',
                                   `cv_value2`	int	NULL	COMMENT 'java에서 연산시 varchar',
                                   `cv_value3`	int	NULL,
                                   `cv_value4`	int	NULL,
                                   `cv_value5`	int	NULL,
                                   `cv_desc`	varchar(300)	NULL
);

CREATE TABLE `asgn` (
                        `asgn_id`	int	NOT NULL	COMMENT 'PK/auto',
                        `sub_id`	int	NOT NULL,
                        `att_id`	int	NOT NULL	COMMENT 'FK',
                        `asgn_desc`	int	NULL,
                        `asgn_rdate`	datetime	NOT NULL,
                        `asgn_ddate`	datetime	NOT NULL
);

CREATE TABLE `reg_result` (
                              `stu_id2`	int	NOT NULL	COMMENT 'PK',
                              `sub_id`	int	NOT NULL	COMMENT 'PK/auto',
                              `cc_id`	varchar(30(	NOT NULL,
                              `rr_asgn_score`	int	NULL,
                              `rr_att_score`	int	NULL,
                              `rr_grade`	varchar(6)	NULL
);

CREATE TABLE `reg_asgn` (
                            `ra_id`	int	NOT NULL	COMMENT 'PK/auto',
                            `sub_id`	int	NOT NULL	COMMENT 'FK',
                            `stu_id`	int	NOT NULL	COMMENT 'FK/검색용',
                            `att_id`	int	NULL	COMMENT 'FK',
                            `ra_content`	varchar	NULL,
                            `ra_sdate`	ime	NOT NULL,
                            `ra_score`	int	NULL
);

CREATE TABLE `video` (
                         `video_id`	int	NOT NULL	COMMENT 'PK/auto',
                         `video_ycode`	varchar(150)	NOT NULL	COMMENT 'youtube 비디오 url  식별코드',
                         `video_title`	varchar(90)	NOT NULL,
                         `video_content`	varchar(300)	NULL,
                         `video_length`	int	NOT NULL
);


ALTER TABLE `department` ADD CONSTRAINT `PK_DEPARTMENT` PRIMARY KEY (
                                                                     `dept_id`
    );

ALTER TABLE `subject` ADD CONSTRAINT `PK_SUBJECT` PRIMARY KEY (
                                                               `sub_id`
    );

ALTER TABLE `reg_course` ADD CONSTRAINT `PK_REG_COURSE` PRIMARY KEY (
                                                                     `stu_id`,
                                                                     `sub_id`
    );

ALTER TABLE `reg_detail` ADD CONSTRAINT `PK_REG_DETAIL` PRIMARY KEY (
                                                                     `stu_id2`,
                                                                     `sub_id`
    );

ALTER TABLE `reg_session` ADD CONSTRAINT `PK_REG_SESSION` PRIMARY KEY (
                                                                       `stu_id`,
                                                                       `sub_id`,
                                                                       `session_ID`
    );

ALTER TABLE `session` ADD CONSTRAINT `PK_SESSION` PRIMARY KEY (
                                                               `session_ID`,
                                                               `sub_id`
    );

ALTER TABLE `criteria_common` ADD CONSTRAINT `PK_CRITERIA_COMMON` PRIMARY KEY (
                                                                               `ct_id`
    );

ALTER TABLE `criteria_detail` ADD CONSTRAINT `PK_CRITERIA_DETAIL` PRIMARY KEY (
                                                                               `cv_id`,
                                                                               `ct_id`
    );


ALTER TABLE `asgn` ADD CONSTRAINT `PK_ASGN` PRIMARY KEY (
                                                         `asgn_id`
    );

ALTER TABLE `reg_result` ADD CONSTRAINT `PK_REG_RESULT` PRIMARY KEY (
                                                                     `stu_id2`,
                                                                     `sub_id`
    );

ALTER TABLE `reg_asgn` ADD CONSTRAINT `PK_REG_ASGN` PRIMARY KEY (
                                                                 `ra_id`
    );

ALTER TABLE `video` ADD CONSTRAINT `PK_VIDEO` PRIMARY KEY (
                                                           `video_id`
    );

REFERENCES `department` (
	`dept_id`
);

ALTER TABLE `subject` ADD CONSTRAINT `FK_department_TO_subject_1` FOREIGN KEY (
                                                                               `dept_id`
    )
    REFERENCES `department` (
                             `dept_id`
        );

ALTER TABLE `reg_course` ADD CONSTRAINT `FK_student_TO_reg_course_1` FOREIGN KEY (
                                                                                  `stu_id`
    )

ALTER TABLE `reg_course` ADD CONSTRAINT `FK_subject_TO_reg_course_1` FOREIGN KEY (
                                                                                  `sub_id`
    )
    REFERENCES `subject` (
                          `sub_id`
        );

REFERENCES `department` (
	`dept_id`
);

ALTER TABLE `reg_detail` ADD CONSTRAINT `FK_reg_course_TO_reg_detail_1` FOREIGN KEY (
                                                                                     `stu_id2`
    )
    REFERENCES `reg_course` (
                             `stu_id`
        );

ALTER TABLE `reg_detail` ADD CONSTRAINT `FK_reg_course_TO_reg_detail_2` FOREIGN KEY (
                                                                                     `sub_id`
    )
    REFERENCES `reg_course` (
                             `sub_id`
        );

ALTER TABLE `reg_session` ADD CONSTRAINT `FK_reg_course_TO_reg_session_1` FOREIGN KEY (
                                                                                       `stu_id`
    )
    REFERENCES `reg_course` (
                             `stu_id`
        );

ALTER TABLE `reg_session` ADD CONSTRAINT `FK_reg_course_TO_reg_session_2` FOREIGN KEY (
                                                                                       `sub_id`
    )
    REFERENCES `reg_course` (
                             `sub_id`
        );

ALTER TABLE `reg_session` ADD CONSTRAINT `FK_session_TO_reg_session_1` FOREIGN KEY (
                                                                                    `session_ID`
    )
    REFERENCES `session` (
                          `session_ID`
        );

ALTER TABLE `session` ADD CONSTRAINT `FK_subject_TO_session_1` FOREIGN KEY (
                                                                            `sub_id`
    )
    REFERENCES `subject` (
                          `sub_id`
        );

ALTER TABLE `session` ADD CONSTRAINT `FK_video_TO_session_1` FOREIGN KEY (
                                                                          `video_id`
    )
    REFERENCES `video` (
                        `video_id`
        );

ALTER TABLE `criteria_detail` ADD CONSTRAINT `FK_criteria_common_TO_criteria_detail_1` FOREIGN KEY (
                                                                                                    `ct_id`
    )
    REFERENCES `criteria_common` (
                                  `ct_id`
        );

ALTER TABLE `asgn` ADD CONSTRAINT `FK_subject_TO_asgn_1` FOREIGN KEY (
                                                                      `sub_id`
    )
    REFERENCES `subject` (
                          `sub_id`
        );

ALTER TABLE `reg_result` ADD CONSTRAINT `FK_reg_course_TO_reg_result_1` FOREIGN KEY (
                                                                                     `stu_id2`
    )
    REFERENCES `reg_course` (
                             `stu_id`
        );

ALTER TABLE `reg_result` ADD CONSTRAINT `FK_reg_course_TO_reg_result_2` FOREIGN KEY (
                                                                                     `sub_id`
    )
    REFERENCES `reg_course` (
                             `sub_id`
        );

ALTER TABLE `reg_asgn` ADD CONSTRAINT `FK_asgn_TO_reg_asgn_1` FOREIGN KEY (
                                                                           `sub_id`
    )
    REFERENCES `asgn` (
                       `asgn_id`
        );

ALTER TABLE `reg_asgn` ADD CONSTRAINT `FK_student_TO_reg_asgn_1` FOREIGN KEY (
                                                                              `stu_id`
    )
