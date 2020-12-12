select	students.student_id,
		students.first_name,
        students.last_name
from 	students_courses,
		students
where 	students.student_id = students_courses.student_id
group by students_courses.student_id
having 	count(students_courses.student_id)>1;