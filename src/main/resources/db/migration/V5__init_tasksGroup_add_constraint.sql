create table tasks_group(
    id int primary key auto_increment,
    title varchar(100) not null,
    completed bit
);

alter table tasks add column tasks_group_id int null;

alter table tasks add foreign key (tasks_group_id) references tasks_group(id);