SELECT  trainers.trainer_id, trainers.first_name, trainers.last_name, subjects.subject
FROM trainers, subjects
where trainers.subject_id = subjects.subject_id;