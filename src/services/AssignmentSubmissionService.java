/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.AssignmentBriefingDao;
import dao.AssignmentSubmissionDao;
import dao.CourseDao;
import dao.DaoFactory;
import dao.StudentDao;
import dao.StudentsSubmissionsDao;
import java.util.ArrayList;
import java.util.List;
import model.AssignmentBriefing;
import model.AssignmentSubmission;
import model.Course;
import model.Student;
import static services.AssignmentBriefingService.columnPrint;
import static services.AssignmentBriefingService.print;
import utilities.ReadFromUserUtilities;

/**
 *
 * @author Leyteris
 */
public class AssignmentSubmissionService {

    public static void printAllAssignmentsSubmissions() {
        AssignmentSubmissionDao dao = DaoFactory.getAssignmentSubmissionDao();

        columnPrint();
        dao.getAll().stream().forEach(i -> print(i));
    }

    public static void printAssignmentSubmissionsPerCourse() {
        AssignmentSubmissionDao dao = DaoFactory.getAssignmentSubmissionDao();
        CourseDao cdao = DaoFactory.getCourseDao();
        List<Long> selections = new ArrayList<>();

        System.out.println("Enter the course ID to view its assignments Submissions:");
        List<Course> courses = cdao.getAll();
        CourseService.columnPrint();
        courses.stream().forEach(i -> CourseService.print(i));

        courses.stream().forEach(i -> selections.add(i.getCourseId()));
        long courseId = ReadFromUserUtilities.readLong(selections);

        columnPrint();
        dao.getAssignmentSubmissionPerCourse(courseId).stream().forEach(i -> print(i));
    }

    public static void printAssignmentSubmissionsPerCoursePerStudent() {
        AssignmentSubmissionDao dao = DaoFactory.getAssignmentSubmissionDao();
        CourseDao cdao = DaoFactory.getCourseDao();
        StudentDao sdao = DaoFactory.getStudentDao();
        List<Long> selections = new ArrayList<>();

        System.out.println("Enter the course ID:");
        List<Course> courses = cdao.getAll();
        CourseService.columnPrint();
        courses.stream().forEach(i -> CourseService.print(i));

        courses.stream().forEach(i -> selections.add(i.getCourseId()));
        long courseId = ReadFromUserUtilities.readLong(selections);

        System.out.println("Enter the student ID:");
        List<Student> students = sdao.getStudentsPerCourse(courseId);
        StudentService.columnPrint();
        students.stream().forEach(i -> StudentService.print(i));

        students.stream().forEach(i -> selections.add(i.getStudentId()));
        long studentId = ReadFromUserUtilities.readNumberOrQuit(selections);

        columnPrint();
        dao.getAssignmentSubmissionPerCoursePerStudent(courseId, studentId).stream().forEach(i -> print(i));
    }

    public static void print(AssignmentSubmission ass) {
        AssignmentBriefingDao brdao = DaoFactory.getAssignmentBriefingDao();

        String format = "%-5s%-12s%-12s%-20s%-32s%n";
        System.out.printf(format,
                ass.getAssignmentSubmissionId(),
                ass.getOralMark(),
                ass.getTotalMark(),
                ass.getSubmissionDate(),
                brdao.get(ass.getSubmissionBriefingId()).getTitle()
        );
    }

    public static void columnPrint() {
        String formatColumn = "%-5s%-12s%-12s%-20s%-32s%n";
        System.out.printf(formatColumn,
                "ID",
                "Oral Mark",
                "total Mark",
                "Submission Date",
                "Briefing"
        );
    }

    public static void addAssignmentSubmission() {
        AssignmentSubmissionDao dao = DaoFactory.getAssignmentSubmissionDao();
        AssignmentBriefingDao brdao = DaoFactory.getAssignmentBriefingDao();
        CourseDao cdao = DaoFactory.getCourseDao();
        StudentDao sdao = DaoFactory.getStudentDao();
        StudentsSubmissionsDao studSubmDao = DaoFactory.getStudentsSubmissionsDao();
        
        List<Long> selections = new ArrayList<>();

        AssignmentSubmission assignment = new AssignmentSubmission();

        System.out.println("Creating student submission:");
        System.out.println("Select the course ID that the assignment belongs");

        List<Course> courses = cdao.getAll();
        CourseService.columnPrint();
        courses.stream().forEach(i -> CourseService.print(i));
        courses.stream().forEach(i -> selections.add(i.getCourseId()));
        long courseId = ReadFromUserUtilities.readLong(selections);     //course
        selections.clear();

        System.out.println("Select the briefing ID that the assignment belongs");
        List<AssignmentBriefing> briefings = brdao.getAssignmentBriefingPerCourse(courseId);
        AssignmentBriefingService.columnPrint();
        briefings.stream().forEach(i -> AssignmentBriefingService.print(i));

        briefings.stream().forEach(i -> selections.add(i.getAssignmentBriefId()));
        long briefingId = ReadFromUserUtilities.readLong(selections);   //briefing
        assignment.setSubmissionBriefingId(briefingId);
        selections.clear();

        System.out.println("Enter the assignment oral mark:");
        assignment.setOralMark(ReadFromUserUtilities.readInt());
        System.out.println("Enter the assignment total mark:");     //TODO total have to be greater than oral
        assignment.setTotalMark(ReadFromUserUtilities.readInt());
        System.out.println("Enter the submission date and time:");
        assignment.setSubmissionDate(ReadFromUserUtilities.readDateTime());

        boolean success = dao.save(assignment);
        
        long submissionCreated = dao.getAll().stream().max((i, j) -> i.compareTo(j)).get().getAssignmentSubmissionId();
       
        boolean isGroupAssignment = briefings.stream().filter(i -> i.getAssignmentBriefId() == briefingId).findFirst().get().isIsGroupProject();

        List<Long> studentsId =  new ArrayList<>();
        if (!isGroupAssignment) {
            System.out.println("Select the student ID that submited this assignment");
            List<Student> students = sdao.getStudentsPerCourse(courseId);
            StudentService.columnPrint();
            students.stream().forEach(i -> StudentService.print(i));
            students.stream().forEach(i -> selections.add(i.getStudentId()));
            studentsId.add(ReadFromUserUtilities.readLong(selections));  //one student           
        } else {
            System.out.println("Select the students ID's that submitted this assignment. Seperate their ID with commas (,)");
            List<Student> students = sdao.getStudentsPerCourse(courseId);
            StudentService.columnPrint();
            students.stream().forEach(i -> StudentService.print(i));
            students.stream().forEach(i -> selections.add(i.getStudentId()));
            studentsId.addAll(ReadFromUserUtilities.readListOfLong(selections));  //one or more students
        }

        studSubmDao.save(studentsId, submissionCreated);
        
        if (success) {
            System.out.println("Insertion successful");
        } else {
            System.out.println("Insertion failed");
        }
    }
}