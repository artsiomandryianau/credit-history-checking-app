CREATE DATABASE  IF NOT EXISTS bank1;
USE bank1;


drop table if exists bank_clients;
create table if not exists bank_clients (
    cl_id int not null auto_increment,
    cl_first_name varchar(255),
    cl_last_name varchar(255),
    cl_date_of_birth varchar(255),
    cl_acc_number` varchar(255),
    cl_email varchar(255),
    cl_phone_number varchar(255),
    cl_address varchar(255),
    PRIMARY KEY (cl_id)
);



