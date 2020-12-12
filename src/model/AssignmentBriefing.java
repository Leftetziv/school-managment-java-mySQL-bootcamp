/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Leyteris
 */
public class AssignmentBriefing {

    private long assignmentBriefId;
    private String title;
    private String description;
    private int maxOralMark;
    private int maxTotalMark;
    private LocalDateTime dueDate;
    private long belongingCourseId;
    private boolean isGroupProject;

    public AssignmentBriefing() {
    }

    public long getAssignmentBriefId() {
        return assignmentBriefId;
    }

    public void setAssignmentBriefId(long assignmentBriefId) {
        this.assignmentBriefId = assignmentBriefId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxOralMark() {
        return maxOralMark;
    }

    public void setMaxOralMark(int maxOralMark) {
        this.maxOralMark = maxOralMark;
    }

    public int getMaxTotalMark() {
        return maxTotalMark;
    }

    public void setMaxTotalMark(int maxTotalMark) {
        this.maxTotalMark = maxTotalMark;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public long getBelongingCourseId() {
        return belongingCourseId;
    }

    public void setBelongingCourseId(long belongingCourseId) {
        this.belongingCourseId = belongingCourseId;
    }

    

    public boolean isIsGroupProject() {
        return isGroupProject;
    }

    public void setIsGroupProject(boolean isGroupProject) {
        this.isGroupProject = isGroupProject;
    }

}
