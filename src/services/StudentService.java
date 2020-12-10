/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.CourseDao;
import dao.DaoFactory;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import java.util.ArrayList;
import java.util.List;
import model.Course;
import model.Student;
import utilities.ReadFromUserUtilities;

/**
 *
 * @author Leyteris
 */
public class StudentService {

    public static void printAllStudents() {
        StudentDao dao = DaoFactory.getStudentDao();

        columnPrint();
        dao.getAll().stream().forEach(i -> print(i));
    }

    public static void printStudentsPerCourse() {
        StudentDao dao = DaoFactory.getStudentDao();
        CourseDao cdao = DaoFactory.getCourseDao();
        List<Long> selections = new ArrayList<>();
        
        System.out.println("Enter the course ID to view its students:");
        List<Course> courses = cdao.getAll();
        CourseService.columnPrint();
        courses.stream().forEach(i -> CourseService.print(i));

        courses.stream().forEach(i -> selections.add(i.getCourseId()));
        long courseId = ReadFromUserUtilities.readNumberOrQuit(selections);
        
        columnPrint();
        dao.getStudentsPerCourse(courseId).stream().forEach(i -> print(i));
    }

    public static void print(Student s) {
        String format = "%-5s%-23s%-23s%-15s%-7.2f%n";
        System.out.printf(format, s.getStudentId(), s.getFirstName(), s.getLastName(), s.getDateOfBirth(), s.getTuitionFees());
    }

    public static void columnPrint() {
        String formatColumn = "%-5s%-23s%-23s%-15s%-10s%n";
        System.out.printf(formatColumn, "ID", "First Name", "First Name", "Date Of Birth", "Tuition Fees");
    }

}
