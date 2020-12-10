/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.AssignmentBriefing;
import model.AssignmentSubmission;

/**
 *
 * @author Leyteris
 */
public interface AssignmentSubmissionDao extends Dao<AssignmentSubmission> {

    List<AssignmentSubmission> getAssignmentSubmissionPerCourse(long id);

    List<AssignmentSubmission> getAssignmentSubmissionPerCoursePerStudent(long cid, long sid);

}
