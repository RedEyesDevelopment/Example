USE `springtest`;
insert into contact (FIRST_NAME, LAST_NAME, BIRTH_DATE) values ('Jacky', 'Chan', '1955-10-31'); 
insert into contact (FIRST_NAME, LAST_NAME, BIRTH_DATE) values ('Susan', 'Boyle', '1970-05-06'); 
insert into contact (FIRST_NAME, LAST_NAME, BIRTH_DATE) values ('Tinner', 'Turner', '1967-04-30'); 

insert into contact_tel_detail (CONTACT_ID, TEL_TYPE, TEL_NUMBER) values (1, 'Mobile', '1234567890');
insert into contact_tel_detail (CONTACT_ID, TEL_TYPE, TEL_NUMBER) values (1, 'Home', '5646453612');
insert into contact_tel_detail (CONTACT_ID, TEL_TYPE, TEL_NUMBER) values (2, 'Home', '7836123943');

insert into hobby (HOBBY_ID) values ('Swimming');
insert into hobby (HOBBY_ID) values ('Jogging');
insert into hobby (HOBBY_ID) values ('Programming');
insert into hobby (HOBBY_ID) values ('Movies');
insert into hobby (HOBBY_ID) values ('Reading');

insert into contact_hobby_detail(CONTACT_ID, HOBBY_ID) values (1, 'Swimming');
insert into contact_hobby_detail(CONTACT_ID, HOBBY_ID) values (1, 'Movies');
insert into contact_hobby_detail(CONTACT_ID, HOBBY_ID) values (2, 'Swimming');

