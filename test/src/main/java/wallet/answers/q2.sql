CREATE FUNCTION beautyString (inputString VARCHAR(255)) RETURNS VARCHAR(255) DETERMINISTIC
BEGIN
	declare len, i int default 0;
    SET len = CHAR_LENGTH(inputString);
	SET inputString = LOWER(inputString);

	WHILE (i < len) DO
		IF (MID(inputString,i,1) = ' ' OR i = 0) THEN			
            IF (i < len) THEN				
                SET inputString = CONCAT(LEFT(inputString,i),UPPER(MID(inputString,i + 1,1)),RIGHT(inputString,len - i - 1));
			END IF;
		END IF;
		SET i = i + 1;
	END WHILE;
	RETURN inputString;
END;