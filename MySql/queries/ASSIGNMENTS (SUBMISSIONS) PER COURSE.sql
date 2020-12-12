-- showing assignments SUBMISSIONS per course
-- change row 22 to show another student
SELECT 	assignment_submissions.*
FROM	assignment_submissions,
		assignment_briefings,
        courses        
WHERE	assignment_submissions.assignment_brief_id = assignment_briefings.assignment_brief_id
		and assignment_briefings.course_id = courses.course_id
        and courses.course_id = 4;
		