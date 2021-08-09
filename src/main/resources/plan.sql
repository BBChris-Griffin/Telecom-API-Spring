create table plan (
	plan_id INT primary key auto_increment not null,
	plan_type VARCHAR(50) not null,
	price VARCHAR(50) not null
);
insert into plan (plan_id, plan_type, price) values (1, 'STARTER', '$35.00');
insert into plan (plan_id, plan_type, price) values (2, 'EXTRA', '$40.00');
insert into plan (plan_id, plan_type, price) values (3, 'ELITE', '$50.00');