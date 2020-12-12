/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.impl.*;

/**
 *
 * @author Leyteris
 */
public class DaoFactory {

    public static StudentDao getStudentDao() {
        return new StudentDaoImpl();
    }

    public static CourseDao getCourseDao() {
        return new CourseDaoImpl();
    }
    
    public static TrainerDao getTrainerDao() {
        return new TrainerDaoImpl();
    }
    
    public static AssignmentBriefingDao getAssignmentBriefingDao() {
        return new AssignmentBriefingDaoImpl();
    }
    
    public static AssignmentSubmissionDao getAssignmentSubmissionDao() {
        return new AssignmentSubmissionDaoImpl();
    }
    
    public static StudentsCoursesDao getStudentsCoursesDao() {
        return new StudentCoursesDaoImpl();
    }
    
    public static TrainersCoursesDao getStudentCoursesDao() {
        return new TrainersCoursesDaoImpl();
    }
    
    public static StreamDao getStreamDao() {
        return new StreamDaoImpl();
    }
    public static TypeDao getTypeDao() {
        return new TypeDaoImpl();
    }
    public static SubjectDao getSubjectDao() {
        return new SubjectDaoImpl();
    }
    
    
}
