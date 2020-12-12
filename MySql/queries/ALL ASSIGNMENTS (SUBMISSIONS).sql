SELECT 	assignment_submissions.assignment_submission_id,
		assignment_submissions.oral_mark,
        assignment_submissions.total_mark,
        assignment_submissions.submission_date,
        assignment_briefings.is_group_project,
        assignment_briefings.title, 
        assignment_briefings.description,
        courses.title,
        streams.stream,
        types.type
FROM	assignment_submissions,
		assignment_briefings,
        courses,
        types,
        streams
WHERE	assignment_submissions.assignment_brief_id = assignment_briefings.assignment_brief_id
		and assignment_briefings.course_id = courses.course_id
        and	courses.type_id = types.type_id
        and courses.stream_id = streams.stream_id;
		