Write a procedure in MySQL to split a column into rows using a delimiter.
CREATE TABLE sometbl ( ID INT, NAME VARCHAR(50) );
INSERT INTO sometbl VALUES (1, 'Smith'), (2, 'Julio|Jones|Falcons'), (3, 'White|Snow'), (4, 'Paint|It|Red'), (5, 'Green|Lantern'), (6, 'Brown|bag');
For (2), example rows would look like >> “3, white”, “3, Snow” …

DELIMITER $$
drop procedure if exists printTable$$

CREATE PROCEDURE `printTable`()
BEGIN
		declare id, start, end int;
        declare name varchar(50);
        declare name_part varchar(50);
        DECLARE rowNo int(10);
        DECLARE sometbl_cursor CURSOR FOR select * from sometbl;
        create table temporaryTable(id int,name varchar(50));
        
        open sometbl_cursor;
			select FOUND_ROWS() into rowNo ;
            read_loop: LOOP
				IF rowNo = 0 THEN
                         LEAVE read_loop;
                END IF;
                
				FETCH sometbl_cursor INTO id,name;
							
				set start=1;
				set end= LOCATE("|",name,start);
				while(end!=0) do   
					  insert into temporaryTable(id,name) values( id, substring(name,start,end-start));
					  set start = end+1;
					  set end= LOCATE("|",name,start);
				end while;
				
				insert into temporaryTable values( id, substring(name,start) );
            
				set rowNo = rowNo - 1;
            END LOOP;
        close sometbl_cursor;
        
        select * from temporaryTable;
        drop table temporaryTable;
END;
