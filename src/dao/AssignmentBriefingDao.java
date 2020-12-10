/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.AssignmentBriefing;

/**
 *
 * @author Leyteris
 */
public interface AssignmentBriefingDao extends Dao<AssignmentBriefing> {

    List<AssignmentBriefing> getAssignmentBriefingPerCourse(long id);

}
