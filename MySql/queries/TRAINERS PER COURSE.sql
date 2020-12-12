-- showing trainers teaching in course with PK = 2;
-- change row 21 to show for another course  
SELECT 	trainers.trainer_id,	
		trainers.first_name,
		trainers.last_name,
        subjects.subject,
		courses.title,
        streams.stream,
        types.type
FROM 	trainers, 
		subjects,
        trainers_courses,
		courses, 
        types,
        streams
WHERE 	trainers.trainer_id = trainers_courses.trainer_id
		and courses.course_id = trainers_courses.course_id
        and trainers.subject_id = subjects.subject_id
        and	courses.type_id = types.type_id
        and courses.stream_id = streams.stream_id
        and courses.course_id = 2;