I have a table for bugs from a bug tracking software; let’s call the table “bugs”. The table has four columns (id, open_date, close_date, severity). On any given day a bug is open if the open_date is on or before that day and close_date is after that day. For example, a bug is open on “2012-01-01”, if it’s created on or before “2012-01-01” and closed on or after “2012-01-02”. I want an SQL to show the number of bugs open each day for a range of dates. Hint: There are bugs that were never closed.


create table bugs(
id int, 
open_date date, 
close_date date, 
severity char(1)
);

insert into bugs values(1, DATE_ADD(CURDATE(), INTERVAL 0 DAY),DATE_ADD(CURDATE(), INTERVAL 1 DAY),'L');
insert into bugs values(1, DATE_ADD(CURDATE(), INTERVAL 0 DAY),DATE_ADD(CURDATE(), INTERVAL 1 DAY),'L');

insert into bugs values(1, DATE_ADD(CURDATE(), INTERVAL 1 DAY),DATE_ADD(CURDATE(), INTERVAL 2 DAY),'L');
insert into bugs values(1, DATE_ADD(CURDATE(), INTERVAL 1 DAY),DATE_ADD(CURDATE(), INTERVAL 2 DAY),'L');
insert into bugs values(1, DATE_ADD(CURDATE(), INTERVAL 1 DAY),DATE_ADD(CURDATE(), INTERVAL 2 DAY),'L');



DELIMITER $$
drop procedure if exists printRange$$

CREATE PROCEDURE `printRange`(from_date date, to_date date)
BEGIN
	
    
	set @my_current_date = from_date;
	set to_date =  DATE_ADD(to_date , INTERVAL 1 DAY);

	create table result(`date` date, `count` int);

	SET @t1 =CONCAT("insert into result values(?, (SELECT count(*) FROM bugs where open_date<=? and (close_date > ? or close_date is null)))");

	while(@my_current_date < to_date) do
		        
        PREPARE stmt3 FROM @t1;
		EXECUTE stmt3 using @my_current_date, @my_current_date,@my_current_date;
        
		DEALLOCATE PREPARE stmt3;
        
		set @my_current_date = DATE_ADD(@my_current_date , INTERVAL 1 DAY);
    end while;
    
    select * from result;
    drop table result;
    
END;$$

DELIMITER;



call printRange(CURDATE(), DATE_ADD(CURDATE(), INTERVAL 10 DAY));