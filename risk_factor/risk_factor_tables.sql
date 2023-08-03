CREATE DATABASE risk_factor DEFAULT CHARACTER SET utf8mb4;

grant super on *.* to 'mysql.session'@localhost;

grant alter, alter routine, create, create routine, create tablespace, create temporary tables, create user, create view, delete, drop, event, execute, file, index, insert, lock tables, process, references, reload, replication client, replication slave, select, show databases, show view, shutdown, super, trigger, update, grant option on *.* to root;


create table algorithm
(
    id int auto_increment
        primary key,
    deploy_file_path varchar(2048) null,
    algorithm_description varchar(2048) null,
    task_type varchar(10) null,
    algorithm_name varchar(2048) null
);

create table data_table
(
    id int auto_increment
        primary key,
    table_desc varchar(2048) null,
    table_name varchar(2048) null,
    table_creator_id int null,
    table_create_time datetime null,
    table_type varchar(20) null,
    data_name varchar(2048) null
);

create table offline_bus
(
    id int auto_increment
        primary key,
    bus_name varchar(2048) null,
    icd_code varchar(128) null,
    algorithm_id int null,
    output_file_path varchar(2048) null,
    bus_description varchar(2048) null,
    bus_create_time datetime null,
    task_id int null
);

create table table_column
(
    id int auto_increment
        primary key,
    table_id int null,
    column_name varchar(512) null,
    column_description varchar(2048) null,
    column_type varchar(20) null
);

create table task
(
    id int auto_increment
        primary key,
    task_state varchar(20) null,
    task_start_time datetime null,
    task_finish_time datetime null,
    task_type varchar(20) null,
    extra_params varchar(2048) null
);

