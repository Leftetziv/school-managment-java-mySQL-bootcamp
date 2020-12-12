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
        long courseId = ReadFromUserUtilities.readNumberOrQuit(selections);
        
        columnPrint();
        dao.getAssignmentBriefingPerCourse(courseId).stream().forEach(i -> print(i));
    }

    public static void print(AssignmentBriefing ass) {
        StreamDao sdao = DaoFactory.getStreamDao();
        TypeDao tdao = DaoFactory.getTypeDao();
        String format = "%-5s%-32s%-15s%-15s%-20s%-15s%-15s%-15s%-15s%n%s%n%n";
        System.out.printf(format,
                ass.getAssignmentBriefId(),
                ass.getTitle(),
                ass.getMaxOralMark(),
                ass.getMaxTotalMark(),
                ass.getDueDate(),
                ass.isIsGroupProject() ? "Group" : "Individual",
                ass.getBelongingCourse().getTitle(),
                sdao.get(ass.getBelongingCourse().getStream()).getStream(),
                tdao.get(ass.getBelongingCourse().getType()).getType(),
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
