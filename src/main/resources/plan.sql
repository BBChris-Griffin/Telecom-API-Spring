create table plan (
	plan_id INT primary key auto_increment not null,
	plan_type VARCHAR(50) not null,
	price VARCHAR(50) not null,
    foreign key (customer_id) references customer (customer_id),
	foreign key (device_id) references device (device_id)
);
insert into plan (plan_id, plan_type, price) values (1, 'STARTER', '$35.00', 1, 9);
insert into plan (plan_id, plan_type, price) values (2, 'EXTRA', '$40.00', 1, 1);
insert into plan (plan_id, plan_type, price) values (3, 'ELITE', '$50.00', 3, 2);
insert into plan (plan_id, plan_type, price) values (4, 'EXTRA', '$40.00', 2, 3);
insert into plan (plan_id, plan_type, price) values (5, 'ELITE', '$50.00', 4, 4);