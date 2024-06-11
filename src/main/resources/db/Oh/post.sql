ALTER TABLE post MODIFY COLUMN attached_id INT null;
ALTER TABLE post MODIFY COLUMN lecture_id INT null;
ALTER TABLE post MODIFY COLUMN updated_at datetime null;
ALTER TABLE post MODIFY COLUMN views INT DEFAULT 0;
ALTER TABLE post MODIFY COLUMN like_id INT DEFAULT 0;

insert into post (board_id, title, content, member_id) value (01, '학사 공지', '학사 공지 테스트', 01);
insert into post (board_id, title, content, member_id) value (02, '과목 공지', '과목 공지 테스트', 01);
insert into post (board_id, title, content, member_id) value (03, '질문 게시판', '질문 테스트', 01);
insert into post (board_id, title, content, member_id) value (04, '자유 게시판', '자유 게시판 테스트', 01);
