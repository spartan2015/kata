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


call printRange(CURDATE(), DATE_ADD(CURDATE(), INTERVAL 10 DAY));