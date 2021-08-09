create table customer (
	customer_id INT NOT NULL auto_increment primary key,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	foreign key (plan_id) references plan (plan_id),
    foreign key (device_id) references device (device_id)
);
insert into customer (customer_id, name, email, password) values (1, 'Bria Hillock', 'bhillock0@51.la', 'rGFtlTEpOnu', 1, 1);
insert into customer (customer_id, name, email, password) values (2, 'Ced Delouch', 'cdelouch1@dion.ne.jp', '52YVbYVl', 2, 2);
insert into customer (customer_id, name, email, password) values (3, 'Morna Summerrell', 'msummerrell2@washington.edu', 'zaWnsjk', 3, 3);
insert into customer (customer_id, name, email, password) values (4, 'Jone Lammas', 'jlammas3@cbsnews.com', 'PEjXES6', 3, 4);
insert into customer (customer_id, name, email, password) values (5, 'Georgie Hartil', 'ghartil4@slideshare.net', 'q6eGFatjq', 1, 5);