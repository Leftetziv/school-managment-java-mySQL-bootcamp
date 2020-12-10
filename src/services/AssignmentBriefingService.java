/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.*;
import model.AssignmentBriefing;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void print(AssignmentBriefing ass) {
        String format = "%-5s%-32s%-15s%-15s%-20s%-15s%-15s%-15s%-15s%n%s%n%n";
        System.out.printf(format,
                ass.getAssignmentBriefId(),
                ass.getTitle(),
                ass.getMaxOralMark(),
                ass.getMaxTotalMark(),
                ass.getDueDate(),
                ass.isIsGroupProject() ? "Group" : "Individual",
                ass.getBelongingCourse().getTitle(),
                ass.getBelongingCourse().getStream(),
                ass.getBelongingCourse().getType(),
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

}
