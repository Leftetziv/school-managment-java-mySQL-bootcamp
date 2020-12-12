SELECT 	assignment_briefings.assignment_brief_id,
		assignment_briefings.title, assignment_briefings.description, 
		assignment_briefings.max_oral_mark,
		assignment_briefings.max_total_mark,
        assignment_briefings.due_date,
        assignment_briefings.is_group_project,
        courses.title,
		streams.stream,
		types.type
FROM 	assignment_briefings,
		streams,
        courses,
        types
where 	assignment_briefings.course_id = courses.course_id
		and courses.stream_id = streams.stream_id
		and courses.type_id = types.type_id;