INSERT INTO app_user (id, version, created_date, last_modified_date, username)
VALUES ((select next_val from user_seq), 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM');

update user_seq
set next_val= 2
where next_val = 1;
