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
        long courseId = ReadFromUserUtilities.readNumberOrQuit(selections);

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
        long courseId = ReadFromUserUtilities.readNumberOrQuit(selections);

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
        String format = "%-5s%-12s%-12s%-20s%-32s%n";
        System.out.printf(format,
                ass.getAssignmentSubmissionId(),
                ass.getOralMark(),
                ass.getTotalMark(),
                ass.getSubmissionDate(),
                ass.getSubmissionBriefing().getTitle()
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
}
