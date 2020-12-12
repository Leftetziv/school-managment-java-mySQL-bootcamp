SELECT	courses.course_id, 
		courses.title,
        streams.stream,
        types.type, 
        courses.start_date, 
        courses.end_date 
FROM 	courses, 
		streams,
        types
where 	courses.type_id = types.type_id
		and courses.stream_id = streams.stream_id;