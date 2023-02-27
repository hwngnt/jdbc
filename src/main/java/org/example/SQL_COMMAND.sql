use student;

SELECT * FROM information CROSS JOIN infor_log;

SELECT * FROM information INNER JOIN infor_log WHERE information.id = infor_log.id;

SELECT * FROM information LEFT JOIN
infor_log ON information.id = infor_log.id;

SELECT * FROM information RIGHT JOIN
infor_log ON information.id = infor_log.id;

SELECT name FROM information WHERE id = 2
UNION 
SELECT name FROM infor_log WHERE id = 1;

SELECT t1.id, t1.name, t2.id, t2.name
FROM information t1, information t2
WHERE t1.id = t2.id;