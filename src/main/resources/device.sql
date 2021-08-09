create table device (
	device_id INT,
	model VARCHAR(50),
	phone_number VARCHAR(50),
    foreign key (customer_id) references customer (customer_id),
	foreign key (plan_id) references plan (plan_id)
);
insert into device (device_id, model, phone_number) values (1, 'ANDROID', '871-988-5659', 1);
insert into device (device_id, model, phone_number) values (2, 'IOS', '322-585-3935', 3);
insert into device (device_id, model, phone_number) values (3, 'IOS', '497-536-3501', 2);
insert into device (device_id, model, phone_number) values (4, 'ANDROID', '200-877-0684', 4);
insert into device (device_id, model, phone_number) values (5, 'IOS', '719-355-5256', 5);
insert into device (device_id, model, phone_number) values (6, 'ANDROID', '137-483-6121', 1);
insert into device (device_id, model, phone_number) values (7, 'IOS', '755-885-1322', 4);
insert into device (device_id, model, phone_number) values (8, 'IOS', '353-326-3948', 5);
insert into device (device_id, model, phone_number) values (9, 'ANDROID', '490-914-0652', 1);