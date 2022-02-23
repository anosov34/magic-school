select * from student;

select * from student where age > 20 and age <30;

select name from student;

select * from student WHERE name like '%O%';

select *
from student
where age < id;

select *
from student
order by age;

select *
from student,
     faculty
where faculty.id = student.faculty_id
  and faculty.id = 1;