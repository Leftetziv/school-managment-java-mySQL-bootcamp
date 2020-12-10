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
    private Course belongingCourse;
    private boolean isGroupProject;

    public AssignmentBriefing() {
    }

    public AssignmentBriefing(long assignmentBriefId, String title, String description, int maxOralMark, int maxTotalMark, LocalDateTime dueDate, Course belongingCourse, boolean isGroupProject) {
        this.assignmentBriefId = assignmentBriefId;
        this.title = title;
        this.description = description;
        this.maxOralMark = maxOralMark;
        this.maxTotalMark = maxTotalMark;
        this.dueDate = dueDate;
        this.belongingCourse = belongingCourse;
        this.isGroupProject = isGroupProject;
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

    public Course getBelongingCourse() {
        return belongingCourse;
    }

    public void setBelongingCourse(Course belongingCourse) {
        this.belongingCourse = belongingCourse;
    }

    public boolean isIsGroupProject() {
        return isGroupProject;
    }

    public void setIsGroupProject(boolean isGroupProject) {
        this.isGroupProject = isGroupProject;
    }

    public void print() {
        String format = "%-5s%-32s%-5s%-5s%-20s%-15s%-15s%-15s%-15s%n%s%n%n";
        System.out.printf(format,
                assignmentBriefId,
                title,
                maxOralMark,
                maxTotalMark,
                dueDate,
                isGroupProject ? "Group" : "Individual",
                belongingCourse.getTitle(),
                belongingCourse.getStream(),
                belongingCourse.getType(),
                description);
    }

}
