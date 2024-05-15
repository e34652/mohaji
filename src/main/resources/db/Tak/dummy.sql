더미코드


insert into criteria_common values("dc01","학과공통기준");
insert into criteria_common values("dc02","과목성적기준");

insert into criteria_detail values("dc0101","모든 학과 공통","졸업요구학점", 130, null, null, null, null, "dc01");

insert into criteria_detail values("rc0101","95초과 100이하 / GPA 4.3 / 수료가능","A", 95, 100, 4.3, "Y", null, "rc01");
insert into criteria_detail values("rc0102","92초과 95이하 / GPA 4.0 / 수료가능","A0", 92, 95, 4.0, "Y", null, "rc01");
insert into criteria_detail values("rc0103","89초과 92이하 / GPA 3.7 / 수료가능","A-", 89, 92, 3.7, "Y", null, "rc01");
insert into criteria_detail values("rc0104","85초과 89이하 / GPA 3.3 / 수료가능","B+", 85, 89, 3.3, "Y", null, "rc01");
insert into criteria_detail values("rc0105","82초과 85이하 / GPA 3.0 / 수료가능","B0", 82, 85, 3.0, "Y", null, "rc01");
insert into criteria_detail values("rc0106","79초과 82이하 / GPA 2.7 / 수료가능","B-", 79, 82, 2.7, "Y", null, "rc01");
insert into criteria_detail values("rc0107","75초과 79이하 / GPA 2.3 / 수료불가","C+", 75, 79, 2.3, "N", null, "rc01");
insert into criteria_detail values("rc0108","72초과 75이하 / GPA 2.0 / 수료불가","C0", 72, 75, 2.0, "N", null, "rc01");
insert into criteria_detail values("rc0109","70초과 72이하 / GPA 1.7 / 수료불가","C-", 70, 72, 1.7, "N", null, "rc01");
insert into criteria_detail values("rc01010","0이상 70미만 / GPA 0 / 수료불가","F", 0, 70, 0, "N", null, "rc01");
insert into criteria_detail values("rc0111","패스","Satisfied", null, null, null, null, null, "rc01");
insert into criteria_detail values("rc0112","논패스","Unsatisfied", null, null, null, null, null, "rc01");


insert into department values(0,"여기는 컴공과","컴퓨터공학과","dc0101");


insert into subject values(0,"THREE", "파이썬을 공부해보자","파이썬 기초", 30, 1, 1,"전공선택","2024-04-12 00:00:00","2024-05-12 23:59:59","2024-05-13 00:00:00","2024-06-05 23:59:59");


insert into video values(0,"파이썬 기초 강의", 540,"파이썬 기초 강의 [1강.파이썬 시작하기]", "UMfCZMuZoRk");


insert into session values(0,1, "파이썬 시작하기",2, 1);


insert into asgn values(0,240605, "Hello Python 출력하기",240412, 2);


insert into reg_asgn values(0,null,"def greet(): print(\"Hello, Python!\") greet()", "훌륭합니다",10, DATE_FORMAT(NOW(), '%y-%m-%d'),1,1);







