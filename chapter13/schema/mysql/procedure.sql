delimiter;

CREATE PROCEDURE 'P_GET_TOPIC'(IN in_user_id INT,OUT out_num INT)
BEGIN
	SELECT COUNT(1) INTO out_num FROM t_topic WHERE user_id = in_user_id;
END
;
delimiter;