INSERT INTO app_user (id, version, created_date, last_modified_date, username)
VALUES (user_seq.nextval, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM');
