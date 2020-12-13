/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DaoFactory;
import dao.*;
import java.util.ArrayList;
import java.util.List;
import model.Course;
import model.Student;
import model.Trainer;
import model.lookup_tables.*;
import utilities.ReadFromUserUtilities;

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
        StreamDao sdao = DaoFactory.getStreamDao();
        TypeDao tdao = DaoFactory.getTypeDao();
        String format = "%-5s%-23s%-23s%-23s%-15s%-15s%n";
        System.out.printf(format, c.getCourseId(), c.getTitle(), sdao.get(c.getStreamId()).getStream(), tdao.get(c.getTypeId()).getType(), c.getStartDate(), c.getEndDate());
    }

    public static void columnPrint() {
        String formatColumn = "%-5s%-23s%-23s%-23s%-15s%-15s%n";
        System.out.printf(formatColumn, "ID", "Title", "Stream", "Type", "Start Date", "End Date");
    }

    public static void addCourse() {
        CourseDao dao = DaoFactory.getCourseDao();
        StreamDao sdao = DaoFactory.getStreamDao();
        TypeDao tdao = DaoFactory.getTypeDao();
        List<Long> selections = new ArrayList<>();

        Course course = new Course();

        System.out.println("Enter the course title:");
        course.setTitle(ReadFromUserUtilities.readString());
        
        System.out.println("Select the stream ID of the course");
        List<Stream> streams = sdao.getAll();
        StreamService.columnPrint();
        streams.stream().forEach(i -> StreamService.print(i));
        streams.stream().forEach(i -> selections.add(i.getStreamId()));
        long streamId = ReadFromUserUtilities.readLong(selections);
        course.setStreamId(streamId);
        
        System.out.println("Select the type ID of the course");
        List<Type> types = tdao.getAll();
        TypeService.columnPrint();
        types.stream().forEach(i -> TypeService.print(i));
        types.stream().forEach(i -> selections.add(i.getTypeId()));
        long typeId = ReadFromUserUtilities.readLong(selections);
        course.setTypeId(typeId);
        
        System.out.println("Enter the course start date:");
        course.setStartDate(ReadFromUserUtilities.readDate());
        System.out.println("Enter the course end date:");
        course.setEndDate(ReadFromUserUtilities.readDate());

        
        boolean success = dao.save(course);

        if (success) {
            System.out.println("Insertion successful");
        } else {
            System.out.println("Insertion failed");
        }

    }

}
