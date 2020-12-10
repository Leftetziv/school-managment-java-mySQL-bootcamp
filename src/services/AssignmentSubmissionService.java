/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.AssignmentSubmissionDao;
import dao.DaoFactory;

/**
 *
 * @author Leyteris
 */
public class AssignmentSubmissionService {

    public static void printAllAssignmentsSubmissions() {
        AssignmentSubmissionDao dao = DaoFactory.getAssignmentSubmissionDao();

        dao.getAll().stream().forEach(i -> i.print());
    }

    public static void printAssignmentSubmissionsPerCourse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void printAssignmentSubmissionsPerCoursePerStudent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
