CREATE DATABASE  IF NOT EXISTS bank1;
USE bank1;

create table if not exists bank_clients (
    cl_id int not null,
    cl_first_name varchar(255),
    cl_last_name varchar(255),
    cl_date_of_birth varchar(255),
    cl_acc_number varchar(255),
    cl_email varchar(255),
    cl_phone_number varchar(255),
    cl_address varchar(255),
    PRIMARY KEY (cl_id)
);


INSERT INTO bank_clients (cl_id, cl_first_name, cl_last_name, cl_date_of_birth, cl_acc_number, cl_email, cl_phone_number, cl_address)
VALUES (1, 'John', 'Smith', '1991-12-01', '10 1050 1444 9392 9239 3582 1234', 'j.smth@gmail.com', '342-234-234', 'RONDO REGANA/33, 2, 50-001');
