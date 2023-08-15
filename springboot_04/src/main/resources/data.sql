INSERT INTO USER_DETAILS(id, name, birth_date) VALUES(10001, 'Ethan', current_date());
INSERT INTO USER_DETAILS(id, name, birth_date) VALUES(10002, 'Charlie', current_date());
INSERT INTO USER_DETAILS(id, name, birth_date) VALUES(10003, 'William', current_date());

INSERt INTO POST(id, description, user_id) VALUES(20001, 'I want to learn AWS', 10001);
INSERt INTO POST(id, description, user_id) VALUES(20002, 'I want to learn DevOps', 10001);
INSERt INTO POST(id, description, user_id) VALUES(20003, 'I want to Get AWS Certified', 10002);
INSERt INTO POST(id, description, user_id) VALUES(20004, 'I want to learn Multi Cloud', 10002);