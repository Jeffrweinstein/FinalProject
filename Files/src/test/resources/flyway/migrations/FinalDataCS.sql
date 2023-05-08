-- CUSTOMERS

INSERT INTO customer (customer_id, customer_name, customer_address, customer_phone_number) VALUES ('241732', 'Las_Vegas_Paving', '4420_S_Decatur_Blvd__Las_Vegas_NV_89103', '7022515800');
INSERT INTO customer (customer_id, customer_name, customer_address, customer_phone_number) VALUES ('277432', 'Kiewit_Construction', '1184_Western_Ave__Las_Vegas_NV_89102', '7029645602');
INSERT INTO customer (customer_id, customer_name, customer_address, customer_phone_number) VALUES ('211342', 'Southwest_Gas', '8360_S_Durango_Drive__Las_Vegas_NV_89113', '7023652043');
INSERT INTO customer (customer_id, customer_name, customer_address, customer_phone_number) VALUES ('147213', 'Whiting_Turner', '6730_Via_Austi_Parkway__Las_Vegas_NV_89119', '7026500700');
INSERT INTO customer (customer_id, customer_name, customer_address, customer_phone_number) VALUES ('341130', 'Helix_Electric', '3308_E_Sunset_Rd__Las_Vegas_NV_89120', '7026978112');
INSERT INTO customer (customer_id, customer_name, customer_address, customer_phone_number) VALUES ('437675', 'Bravo_Underground', '1183_Center_Point_Drive__Henderson_NV_89074', '7023144292');
INSERT INTO customer (customer_id, customer_name, customer_address, customer_phone_number) VALUES ('112342', 'NewCom_Inc', '6600_Amelia_Earhardt_Court__Las Vegas_NV_89119', '7023144292');
INSERT INTO customer (customer_id, customer_name, customer_address, customer_phone_number) VALUES ('098938', 'Contri_Construction', '2650_E_Lamont Street__Las_Vegas_NV_89115', '7024687392');

-- VENDORS


INSERT INTO vendor (vendor_id, vendor_name, vendor_address, vendor_phone_number) VALUES ('8253039', 'Mine_Safety_Appliances', '6565_Penn_Avenue__Pittsburgh_PA_15206', '8006722222');
INSERT INTO vendor (vendor_id, vendor_name, vendor_address, vendor_phone_number) VALUES ('9834545', 'Vanderlans_&_Sons', '1320_S_Sacramento_Street__St_Lodi_CA_95240', '2093342434');
INSERT INTO vendor (vendor_id, vendor_name, vendor_address, vendor_phone_number) VALUES ('7133434', 'Plug_Technologies', '11099_Lamont_Avenue_NE__Hanover_MN_55341', '7635151400');
INSERT INTO vendor (vendor_id, vendor_name, vendor_address, vendor_phone_number) VALUES ('1239092', 'Oatey_Supply Chain Services', '5245_N_Sloan_Lane__Las_Vegas_NV_89115', '7028435552');

-- SALES PERSON

INSERT INTO sales_person (sales_person_id, first_name, last_name) VALUES ('112908', 'Julie', 'Hill');
INSERT INTO sales_person (sales_person_id, first_name, last_name) VALUES ('045342', 'Tommy', 'Gray');
INSERT INTO sales_person (sales_person_id, first_name, last_name) VALUES ('023983', 'Joel', 'Murphy');
INSERT INTO sales_person (sales_person_id, first_name, last_name) VALUES ('138762', 'Aaron', 'Farley');

-- EQUIPMENT 

INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006000', 'Plug', 'Four_Eight', 'Block', '9834545', '225.05');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006001', 'Plug', 'Four_Eight', 'Block', '7133434', '230.45');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006002', 'Plug', 'Four_Eight', 'Block', '1239092', '237.65');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006010', 'Plug', 'Four_Eight', 'Test', '9834545', '240.25');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006011', 'Plug', 'Four_Eight', 'Test', '7133434', '262.45');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006012', 'Plug', 'Four_Eight', 'Test', '1239092', '257.65');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006020', 'Plug', 'Four_Eight', 'Flow_Thru', '9834545', '265.05');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006021', 'Plug', 'Four_Eight', 'Flow_Thru', '7133434', '279.45');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006022', 'Plug', 'Four_Eight', 'Flow_Thru', '1239092', '297.65');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006100', 'Plug', 'Six_Ten', 'Block', '9834545', '264.05');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006101', 'Plug', 'Six_Ten', 'Block', '7133434', '270.45');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006102', 'Plug', 'Six_Ten', 'Block', '1239092', '267.65');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006110', 'Plug', 'Six_Ten','Test', '9834545', '310.25');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006111', 'Plug', 'Six_Ten','Test', '7133434', '303.45');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006112', 'Plug', 'Six_Ten', 'Test', '1239092', '317.65');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006120', 'Plug', 'Six_Ten', 'Flow_Thru', '9834545', '335.05');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006121', 'Plug', 'Six_Ten', 'Flow_Thru', '7133434', '336.45');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006122', 'Plug', 'Six_Ten', 'Flow_Thru', '1239092', '346.65');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006200', 'Plug', 'Eight_Twelve', 'Block', '9834545', '314.05');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006201', 'Plug', 'Eight_Twelve', 'Block', '7133434', '320.45');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006202', 'Plug', 'Eight_Twelve', 'Block', '1239092', '337.65');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006210', 'Plug', 'Eight_Twelve', 'Test', '9834545', '345.25');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006211', 'Plug', 'Eight_Twelve', 'Test', '7133434', '349.45');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006212', 'Plug', 'Eight_Twelve', 'Test', '1239092', '360.65');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006220', 'Plug', 'Eight_Twelve', 'Flow_Thru', '9834545', '387.05');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006221', 'Plug', 'Eight_Twelve',  'Flow_Thru', '7133434', '396.45');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('5006222', 'Plug', 'Eight_Twelve',  'Flow_Thru', '1239092', '406.65');
INSERT INTO equipment (equipment_id, equipment_group, equipment_size, equipment_type, vendor_id, price) VALUES ('6000000', 'Gas', 'Four', 'Gas Detector', '825309', '901.65’);



-- ORDERS


INSERT INTO orders (order_id, customer_id, sales_person_id, order_date, order_person, job_id, po_number) VALUES ("202134", "341130", "138762", "2023-03-30", "Randy_Jackson", "26754", "234");
INSERT INTO orders (order_id, customer_id, sales_person_id, order_date, order_person, job_id, po_number) VALUES ("202127", "098938", "045342", "2023-03-30", "Al_Dominguez", "98723", "98723");
INSERT INTO orders (order_id, customer_id, sales_person_id, order_date, order_person, job_id, po_number) VALUES ("199893", "437675", "023983", "2023-03-25", "Juan_Padilla", "98983", "145");


-- EQUIPMENT ORDERS

INSERT INTO equipment_orders(order_id, equipment_id, quantity) VALUES ("202100", "5006212", 3);
INSERT INTO equipment_orders(order_id, equipment_id, quantity) VALUES ("202100", "5006222", 3);
INSERT INTO equipment_orders(order_id, equipment_id, quantity) VALUES ("202100", "5006100", 2);
INSERT INTO equipment_orders(order_id, equipment_id, quantity) VALUES ("200100", "6000000", 2);
INSERT INTO equipment_orders(order_id, equipment_id, quantity) VALUES ("202134", "5006022", 1);
INSERT INTO equipment_orders(order_id, equipment_id, quantity) VALUES ("202127", "5006111", 10);
INSERT INTO equipment_orders(order_id, equipment_id, quantity) VALUES ("202127", "5006121", 5);
INSERT INTO equipment_orders(order_id, equipment_id, quantity) VALUES ("199893", "5006110", 4);
