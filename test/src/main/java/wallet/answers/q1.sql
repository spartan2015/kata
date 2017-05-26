Write a query to rank order the following table in MySQL by votes, display the rank as one of the columns.
CREATE TABLE votes ( name CHAR(10), votes INT );
INSERT INTO votes VALUES
('Smith',10), ('Jones',15), ('White',20), ('Black',40), ('Green',50), ('Brown',20);
2)


select a.*,@rank := @rank + 1 AS rank from
(SELECT name, votes FROM votes order by votes desc) a,
(SELECT @rank := 0) b