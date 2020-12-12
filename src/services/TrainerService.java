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
import static services.StudentService.columnPrint;
import static services.StudentService.print;
import utilities.ReadFromUserUtilities;

/**
 *
 * @author Leyteris
 */
public class TrainerService {

    public static void printAllTrainers() {
        TrainerDao dao = DaoFactory.getTrainerDao();

        columnPrint();
        dao.getAll().stream().forEach(i -> print(i));
    }

    public static void printTrainersPerCourse() {
        TrainerDao dao = DaoFactory.getTrainerDao();
        CourseDao cdao = DaoFactory.getCourseDao();
        List<Long> selections = new ArrayList<>();

        System.out.println("Enter the course ID to view its trainers:");
        List<Course> courses = cdao.getAll();
        CourseService.columnPrint();
        courses.stream().forEach(i -> CourseService.print(i));

        courses.stream().forEach(i -> selections.add(i.getCourseId()));
        long courseId = ReadFromUserUtilities.readNumberOrQuit(selections);

        columnPrint();
        dao.getTrainersPerCourse(courseId).stream().forEach(i -> print(i));
    }

    public static void print(Trainer t) {
        SubjectDao sdao = DaoFactory.getSubjectDao();
        String format = "%-5s%-23s%-23s%-15s%n";
        System.out.printf(format, t.getTrainerId(), t.getFirstName(), t.getLastName(), sdao.get(t.getSubjectId()).getSubject());
    }

    public static void columnPrint() {
        String formatColumn = "%-5s%-23s%-23s%-15s%n";
        System.out.printf(formatColumn, "ID", "First Name", "Last Name", "Subject");
    }

    public static void addTrainer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
