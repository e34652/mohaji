ALTER TABLE board MODIFY COLUMN course_id INT null;

insert into board(board_name, group_id) value ('전체 공지', 01);
insert into board(board_name, course_id, group_id) value ('과목 공지', 01, 02);
insert into board(board_name, group_id) value ('질문 게시판', 03);
insert into board(board_name, group_id) value ('자유 게시판', 04);

