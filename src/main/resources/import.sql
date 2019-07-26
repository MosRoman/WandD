insert into users (id,name,password,email,telephone) values(1,'Admin', '$2a$10$y3nKDWcXPJE5pXm5xfeZP.osdkokTeh9Fkc0TKl5pAy6X0tXQmCrK','system@localhost','+38(099)1458962');
insert into users (id,name,password,email,telephone) values(2,'User', '$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K','system@localhost2','+38(099)8645738');

insert into roles (name) values ('ROLE_ADMIN');
insert into roles (name) values ('ROLE_USER');

insert into users_roles (user_id, roles_name) values (1,'ROLE_ADMIN')
insert into users_roles (user_id, roles_name) values (2,'ROLE_USER');


