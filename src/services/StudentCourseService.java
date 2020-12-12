/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import dao.*;

/**
 *
 * @author Leyteris
 */
public class StudentCourseService {

    public static void printMulticourseStudents() {
        StudentsCoursesDao dao = DaoFactory.getStudentsCoursesDao();

        StudentService.columnPrint();
        dao.getStudentsInMultipleCourses().stream().forEach(i -> StudentService.print(i));
    }

    public static void enrollStudent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
