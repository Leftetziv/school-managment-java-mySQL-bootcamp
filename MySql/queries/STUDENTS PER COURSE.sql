-- showing students enrolled in course with PK = 2;
-- change row 16 to show another course  
SELECT 	students.*,
		courses.title,
        streams.stream,
        types.type
FROM 	students, 
		courses, 
        students_courses,
        types,
        streams
WHERE 	students.student_id = students_courses.student_id
		and courses.course_id = students_courses.course_id
        and	courses.type_id = types.type_id
        and courses.stream_id = streams.stream_id
        and courses.course_id = 2;