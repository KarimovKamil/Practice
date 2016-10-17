CREATE TABLE goods(
  good_id SERIAL PRIMARY KEY,
  good_name VARCHAR(30)
);

CREATE TABLE users(
  user_id SERIAL PRIMARY KEY,
  first_name VARCHAR(20),
  last_name VARCHAR(20),
  middle_name VARCHAR(20)
);

CREATE TABLE vendors(
  vendor_id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(user_id),
  good_id INT REFERENCES goods(good_id),
  lot_size_wholesale INT, 
  price MONEY,
  conditions_sale VARCHAR(50), 
  payment_method VARCHAR(30),
  phone_number VARCHAR(10),
  note VARCHAR(50)
);

CREATE TABLE customers(
  customer_id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(user_id),
  good_id INT REFERENCES goods(good_id),
  lot_size INT, 
  price MONEY,
  payment_method VARCHAR(30),
  phone_number VARCHAR(10),
  note VARCHAR(50)
);

CREATE TABLE archive(
  vendor_id INT REFERENCES vendors(vendor_id),
  customer_id INT REFERENCES customers(customer_id),
  good_id INT REFERENCES goods(good_id),
  sell_date DATE,
  customer_comment VARCHAR(50)
);

CREATE TABLE deal(
  deal_id SERIAL PRIMARY KEY,
  vendor_id INT REFERENCES vendors(vendor_id),
  customer_id INT REFERENCES customers(customer_id),
  good_id INT REFERENCES goods(good_id), 
  price MONEY,
  sell_date DATE
);
