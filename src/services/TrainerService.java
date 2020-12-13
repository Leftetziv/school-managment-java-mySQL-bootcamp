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
import model.lookup_tables.Subject;
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
        long courseId = ReadFromUserUtilities.readLong(selections);

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
        TrainerDao dao = DaoFactory.getTrainerDao();
        SubjectDao sdao = DaoFactory.getSubjectDao();
        List<Long> selections = new ArrayList<>();

        Trainer trainer = new Trainer();
        System.out.println("\nCreating trainer for the course:");
        System.out.println("Enter the trainer first name:");
        trainer.setFirstName(ReadFromUserUtilities.readString());
        System.out.println("Enter the trainer last name:");
        trainer.setLastName(ReadFromUserUtilities.readString());
        
        System.out.println("Select the subject ID of the trainer");
        List<Subject> subjects = sdao.getAll();
        SubjectService.columnPrint();
        subjects.stream().forEach(i -> SubjectService.print(i));
        subjects.stream().forEach(i -> selections.add(i.getSubjectId()));
        long subjectId = ReadFromUserUtilities.readLong(selections);
        trainer.setSubjectId(subjectId);

        boolean success = dao.save(trainer);

        if (success) {
            System.out.println("Insertion successful");
        } else {
            System.out.println("Insertion failed");
        }
    }

}
