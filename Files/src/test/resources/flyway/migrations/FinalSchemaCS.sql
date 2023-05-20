DROP TABLE IF EXISTS equipment_orders;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS sales_person;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS equipment;
DROP TABLE IF EXISTS vendor;

CREATE TABLE vendor (
vendor_id VARCHAR(7) NOT NULL,
vendor_name VARCHAR(45) NOT NULL, 
vendor_address VARCHAR(128),
vendor_phone_number VARCHAR(20),
CONSTRAINT vendor_vendorId_PK PRIMARY KEY (vendor_id)
);

CREATE TABLE equipment (
equipment_id VARCHAR(8) NOT NULL,
vendor_id VARCHAR(7) NOT NULL,
equipment_group enum ('Plug', 'Gas Detector') NOT NULL,
equipment_size enum ('Four_Eight', 'Six_Ten', 'Eight_Twelve', 'Four') NOT NULL,
equipment_type enum ('Gas', 'Test', 'Block', 'Flow_Thru') NOT NULL,
price DECIMAL(6,2) NOT NULL,
CONSTRAINT equipment_equipmentId_PK PRIMARY KEY (equipment_id),
CONSTRAINT equipment_vendorId_FK FOREIGN KEY (vendor_id) REFERENCES vendor (vendor_id) ON DELETE CASCADE
);

CREATE TABLE customer(
customer_id VARCHAR(7) NOT NULL,
customer_name VARCHAR(45) NOT NULL,
customer_address VARCHAR (128),
customer_phone_number VARCHAR(20),
CONSTRAINT customer_customerId_PK PRIMARY KEY (customer_id)
);
CREATE TABLE sales_person (
sales_person_id VARCHAR(6) NOT NULL,
last_name VARCHAR(45),
first_name VARCHAR(45),
CONSTRAINT salesPerson_salesPersonId_PK PRIMARY KEY (sales_person_id) 
);

CREATE TABLE orders (
order_id VARCHAR(7) NOT NULL,
customer_id VARCHAR(7) NOT NULL,
sales_person_id  VARCHAR(8) NULL,
order_date VARCHAR(8) NOT NULL,
order_person VARCHAR(45) NOT NULL,
job_id VARCHAR(8),
po_number VARCHAR(10) NOT NULL,
CONSTRAINT orders_orderId_PK PRIMARY KEY (order_id),
CONSTRAINT orders_customerID_FK FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE cascade,
CONSTRAINT orders_salesPersonID_FK FOREIGN KEY (sales_person_id) REFERENCES sales_person (sales_person_id) ON DELETE CASCADE
);

CREATE TABLE equipment_orders (
equipment_id VARCHAR(8) NOT NULL,
order_id VARCHAR(7) NOT NULL,
quantity INT NOT NULL,
CONSTRAINT equipmentOrders_equipmentId_FK FOREIGN KEY (equipment_id) REFERENCES equipment (equipment_id) ON DELETE CASCADE,
CONSTRAINT equipmentOrders_orderId_FK FOREIGN KEY (order_id) REFERENCES orders (order_id) ON DELETE CASCADE,
CONSTRAINT equipmentOrders_orderId_equipmentId_UK UNIQUE KEY (order_id, equipment_id)
);
