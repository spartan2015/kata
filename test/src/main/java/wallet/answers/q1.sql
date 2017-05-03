select a.*,@rank := @rank + 1 AS rank from
(SELECT name, votes FROM votes order by votes desc) a,
(SELECT @rank := 0) b