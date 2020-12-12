-- showing assignments SUBMISSIONS per course per student
-- change row 24 to show another student
-- change row 25 to show another course 
SELECT 	assignment_submissions.*
FROM	assignment_submissions,
		assignment_briefings,
        courses,
        students_assignment_submissions
WHERE	assignment_submissions.assignment_brief_id = assignment_briefings.assignment_brief_id
		and assignment_briefings.course_id = courses.course_id
        and assignment_submissions.assignment_submission_id = students_assignment_submissions.assignment_submission_id
        and students_assignment_submissions.student_id = 18
        and courses.course_id = 4;
		