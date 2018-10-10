use `202`;

create table modules (
mod_ID int not null,
mod_title varchar (30) not null,
mod_description varchar (300),
constraint modules_pk primary key (mod_ID));

alter table modules,
alter column mod_ID int not null;

insert into modules (mod_ID,mod_title,mod_description) values (1, "Basic Java", "What is Java");

select * from modules where mod_ID = 1;
update modules set mod_ID = 1, mod_title = "Introduction to Java", mod_description = "BlueJ" where mod_ID = 1;

create table deliverables (
del_ID int not null,
del_title varchar (30) not null,
del_description varchar (300),
del_deadline date,
mod_ID integer not null,
constraint deliverables_pk primary key (del_ID),
constraint deliverables_fk foreign key (mod_ID) references modules (mod_ID));



ALTER TABLE modules ADD mod_req varchar (100);
ALTER TABLE modules ADD mod_point varchar (100);
ALTER TABLE modules ADD mod_deadline date;
AlTER TABLE modules modify column mod_point int;
ALTER TABLE modules ADD mod_result int;
alter table modules drop column mod_result;



update modules set mod_ID =10,mod_title="Hello", mod_description="hello", mod_req="hello", mod_point=10 where mod_ID = 2;

drop table deliverables;

create table deliverables(
del_ID int not null,
del_description varchar (300),
del_feedback varchar (300),
del_points int,
del_status varchar (10) not null,
mod_ID int not null,
constraint deliverables_pk primary key (del_ID),
constraint deliverables_fk foreign key (mod_ID) references modules (mod_ID));


select * from deliverables;

select * from modules;

