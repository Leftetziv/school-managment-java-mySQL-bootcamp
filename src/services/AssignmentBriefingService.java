/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.*;
import java.util.ArrayList;
import java.util.List;
import model.AssignmentBriefing;
import model.Course;
import static services.StudentService.columnPrint;
import static services.StudentService.print;
import utilities.ReadFromUserUtilities;

/**
 *
 * @author Leyteris
 */
public class AssignmentBriefingService {

    public static void printAllAssignmentsBriefings() {
        AssignmentBriefingDao dao = DaoFactory.getAssignmentBriefingDao();

        columnPrint();
        dao.getAll().stream().forEach(i -> print(i));
    }

    public static void printAssignmentBriefingsPerCourse() {
        AssignmentBriefingDao dao = DaoFactory.getAssignmentBriefingDao();
        CourseDao cdao = DaoFactory.getCourseDao();
        List<Long> selections = new ArrayList<>();

        System.out.println("Enter the course ID to view its assignments Briefings:");
        List<Course> courses = cdao.getAll();
        CourseService.columnPrint();
        courses.stream().forEach(i -> CourseService.print(i));

        courses.stream().forEach(i -> selections.add(i.getCourseId()));
        long courseId = ReadFromUserUtilities.readLong(selections);

        columnPrint();
        dao.getAssignmentBriefingPerCourse(courseId).stream().forEach(i -> print(i));
    }

    public static void print(AssignmentBriefing ass) {
        StreamDao sdao = DaoFactory.getStreamDao();
        TypeDao tdao = DaoFactory.getTypeDao();
        CourseDao cdao = DaoFactory.getCourseDao();

        Course BelongingCourse = cdao.get(ass.getBelongingCourseId());

        String format = "%-5s%-32s%-15s%-15s%-20s%-15s%-15s%-15s%-15s%n\t%s%n%n";
        System.out.printf(format,
                ass.getAssignmentBriefId(),
                ass.getTitle(),
                ass.getMaxOralMark(),
                ass.getMaxTotalMark(),
                ass.getDueDate(),
                ass.isIsGroupProject() ? "Group" : "Individual",
                BelongingCourse.getTitle(),
                sdao.get(BelongingCourse.getStreamId()).getStream(),
                tdao.get(BelongingCourse.getTypeId()).getType(),
                ass.getDescription()
        );
    }

    public static void columnPrint() {
        String formatColumn = "%-5s%-32s%-15s%-15s%-20s%-15s%-15s%-15s%-15s%n";
        System.out.printf(formatColumn,
                "ID",
                "Title",
                "Max Oral Mark",
                "Max total Mark",
                "Due Date",
                "Type",
                "Course Title",
                "Course Stream",
                "Course Type"
        );
    }

    public static void addAssignmentBriefing() {
        AssignmentBriefingDao dao = DaoFactory.getAssignmentBriefingDao();
        CourseDao cdao = DaoFactory.getCourseDao();
        List<Long> selections = new ArrayList<>();

        AssignmentBriefing assignment = new AssignmentBriefing();
        System.out.println("\nCreating assignment for the course:");
        System.out.println("Enter the assignment title:");
        assignment.setTitle(ReadFromUserUtilities.readString());
        System.out.println("Enter the assignment description:");
        assignment.setDescription(ReadFromUserUtilities.readString());
        System.out.println("Enter the assignment due to date:");
        assignment.setDueDate(ReadFromUserUtilities.readDateTime());
        System.out.println("Enter the assignment max oral mark:");
        assignment.setMaxOralMark(ReadFromUserUtilities.readInt());
        System.out.println("Enter the assignment max total mark:");     //TODO total have to be greater than oral
        assignment.setMaxTotalMark(ReadFromUserUtilities.readInt());
        System.out.println("Is it a group assignment?");
        assignment.setIsGroupProject(ReadFromUserUtilities.readYesOrNo());

        System.out.println("Select the course ID that the assignment belongs");
        List<Course> courses = cdao.getAll();
        CourseService.columnPrint();
        courses.stream().forEach(i -> CourseService.print(i));

        courses.stream().forEach(i -> selections.add(i.getCourseId()));
        long courseId = ReadFromUserUtilities.readLong(selections);
        assignment.setBelongingCourseId(courseId);

        boolean success = dao.save(assignment);

        if (success) {
            System.out.println("Insertion successful");
        } else {
            System.out.println("Insertion failed");
        }
    }

}
