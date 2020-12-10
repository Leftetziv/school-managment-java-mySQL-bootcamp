/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DaoFactory;
import dao.*;
import model.Course;
import model.Student;

/**
 *
 * @author Leyteris
 */
public class CourseService {

    public static void printAllCourses() {
        CourseDao dao = DaoFactory.getCourseDao();
        
        columnPrint();
        dao.getAll().stream().forEach(i -> print(i));
    }

    public static void print(Course c) {
        String format = "%-5s%-23s%-23s%-23s%-15s%-15s%n";
        System.out.printf(format, c.getCourseId(), c.getTitle(), c.getStream(), c.getType(), c.getStartDate(), c.getEndDate());
    }

    public static void columnPrint() {
        String formatColumn = "%-5s%-23s%-23s%-23s%-15s%-15s%n";
        System.out.printf(formatColumn, "ID", "Title", "Stream", "Type", "Start Date", "End Date");
    }

}
