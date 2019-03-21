insert into taTeam.Category(id, name_e)  values (1,'IT');
insert into taTeam.Category(id, name_e)  values (2,'Technology');

insert into taTeam.SubCategory(id, name_e, id_category) VALUES (1,'Web Programming',1);
insert into taTeam.SubCategory(id, name_e, id_category) VALUES (2,'Spring',1);
insert into taTeam.SubCategory(id, name_e, id_category) VALUES (3,'Network',2);
insert into taTeam.SubCategory(id, name_e, id_category) VALUES (4,'Security',2);

insert into taTeam.MemberType(id, type) VALUES (1,'teacher');
insert into taTeam.MemberType(id, type) VALUES (2,'student');

insert into taTeam.Roles(id, name_e) VALUES (1,'ROLE_ADD_COURSE');
insert into taTeam.Roles(id, name_e) VALUES (2,'ROLE_ADD_MATERIAL');
insert into taTeam.Roles(id, name_e) VALUES (3,'ROLE_ADD_LESSON');
insert into taTeam.Roles(id, name_e) VALUES (4,'ROLE_STANDARD');

insert into taTeam.Member(id,firstname, lastname, mail, password_d, username, id_member_type) VALUES (1,'umur','inan','umurinan@gmail.com','12345','umurinan',1);
insert into taTeam.Member(id,firstname, lastname, mail, password_d, username, id_member_type) VALUES (2,'teacher','teacher','a','teacher','teacher',1);
insert into taTeam.Member(id,firstname, lastname, mail, password_d, username, id_member_type) VALUES (3,'student','student','b','student','student',2);

insert into taTeam.member_role_rel(Member_id, roleList_id) VALUES (1,1);
insert into taTeam.member_role_rel(Member_id, roleList_id) VALUES (1,2);
insert into taTeam.member_role_rel(Member_id, roleList_id) VALUES (1,3);
insert into taTeam.member_role_rel(Member_id, roleList_id) VALUES (1,4);

insert into taTeam.member_role_rel(Member_id, roleList_id) VALUES (2,1);
insert into taTeam.member_role_rel(Member_id, roleList_id) VALUES (2,2);
insert into taTeam.member_role_rel(Member_id, roleList_id) VALUES (2,3);
insert into taTeam.member_role_rel(Member_id, roleList_id) VALUES (2,4);

insert into taTeam.member_role_rel(Member_id, roleList_id) VALUES (3,4);

insert into taTeam.Course(id, name_e, instuctor_id, id_sub_category) values (1,'Enterprise Architecture',1,2);
insert into taTeam.Course(id, name_e, instuctor_id, id_sub_category) values (2,'Web Programming',2,1);


insert into taTeam.Lesson(id, name_e, id_course) values (1,'ORM',1);
insert into taTeam.Lesson(id, name_e, id_course) values (2,'BATCH',1);

insert into taTeam.Lesson(id, name_e, id_course) values (3,'CSS',2);
insert into taTeam.Lesson(id, name_e, id_course) values (4,'HTML',2);

insert into taTeam.Material(id, name_e, id_lesson) VALUES (1,'Demo ORM 1',1);
insert into taTeam.Material(id, name_e, id_lesson) VALUES (2,'Demo ORM 2',1);

insert into taTeam.Material(id, name_e, id_lesson) VALUES (3,'Demo BATCH 1',2);
insert into taTeam.Material(id, name_e, id_lesson) VALUES (4,'Demo BATCH 2',2);

insert into taTeam.Material(id, name_e, id_lesson) VALUES (5,'Demo CSS 1',3);
insert into taTeam.Material(id, name_e, id_lesson) VALUES (6,'Demo CSS 2',3);

insert into taTeam.Material(id, name_e, id_lesson) VALUES (7,'Demo HTML 1',4);
insert into taTeam.Material(id, name_e, id_lesson) VALUES (8,'Demo HTML 2',4);

insert into taTeam.Enrollment(id_course, id_member) VALUES (1,3);
insert into taTeam.Enrollment(id_course, id_member) VALUES (2,3);
