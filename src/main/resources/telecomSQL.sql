CREATE TABLE USER (
  customer_id INT NOT NULL auto_increment primary key,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  estimated_price INT NULL,
  total_plans INT NULL
);

CREATE TABLE PLAN (
  plan_id INT primary key NOT NULL AUTO_INCREMENT,
  plan_type VARCHAR(50) NULL DEFAULT NULL,
  price INT NULL DEFAULT NULL
);

CREATE TABLE USER_PLAN (
  up_id INT primary key NOT NULL,
  estimated_price INT NULL,
  plan_amount INT NULL,
  customer_id INT NULL,
  CONSTRAINT fk_customer foreign key (customer_id) references user (customer_id),
  plan_id INT NULL,
  CONSTRAINT fk_plann foreign key (plan_id) references plan (plan_id)
  );
  
  CREATE TABLE DEVICE (
  phone_number VARCHAR(50) primary key unique,
  model VARCHAR(50) NULL DEFAULT NULL,
  plan_id INT,
  foreign key (plan_id) references plan (plan_id),
  customer_id INT,
  foreign key (customer_id) references user (customer_id)
);