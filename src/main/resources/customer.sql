create table user (
	customer_id INT NOT NULL auto_increment primary key,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
    plan_id INT, 
	foreign key (plan_id) references plan (plan_id)
);
insert into user (customer_id, name, email, password, plan_id) values (1, 'Bria Hillock', 'bhillock0@51.la', 'rGFtlTEpOnu', 1);
insert into user (customer_id, name, email, password, plan_id) values (2, 'Ced Delouch', 'cdelouch1@dion.ne.jp', '52YVbYVl', 2);
insert into user (customer_id, name, email, password, plan_id) values (3, 'Morna Summerrell', 'msummerrell2@washington.edu', 'zaWnsjk', 3);
insert into user (customer_id, name, email, password, plan_id) values (4, 'Jone Lammas', 'jlammas3@cbsnews.com', 'PEjXES6', 3);
insert into user (customer_id, name, email, password, plan_id) values (5, 'Georgie Hartil', 'ghartil4@slideshare.net', 'q6eGFatjq', 1);

drop table user;

UPDATE customer set plan_id = 2 where customer_id = 1;
UPDATE customer set device_id = 2 where customer_id = 1;


select * from user;
