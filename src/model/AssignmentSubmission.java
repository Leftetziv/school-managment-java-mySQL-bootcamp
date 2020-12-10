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
public class AssignmentSubmission {

    private long assignmentSubmissionId;
    private int oralMark;
    private int TotalMark;
    private LocalDateTime submissionDate;
    private AssignmentBriefing submissionBriefing;

    public AssignmentSubmission() {
    }

    public AssignmentSubmission(long assignmentSubmissionId, int oralMark, int TotalMark, LocalDateTime submissionDate, AssignmentBriefing submissionBriefing) {
        this.assignmentSubmissionId = assignmentSubmissionId;
        this.oralMark = oralMark;
        this.TotalMark = TotalMark;
        this.submissionDate = submissionDate;
        this.submissionBriefing = submissionBriefing;
    }

    public long getAssignmentSubmissionId() {
        return assignmentSubmissionId;
    }

    public void setAssignmentSubmissionId(long assignmentSubmissionId) {
        this.assignmentSubmissionId = assignmentSubmissionId;
    }

    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public int getTotalMark() {
        return TotalMark;
    }

    public void setTotalMark(int TotalMark) {
        this.TotalMark = TotalMark;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public AssignmentBriefing getSubmissionBriefing() {
        return submissionBriefing;
    }

    public void setSubmissionBriefing(AssignmentBriefing submissionBriefing) {
        this.submissionBriefing = submissionBriefing;
    }

    public void print() {
        String format = "%-5s%-5s%-5s%-20s%-32s%n";
        System.out.printf(format,
                assignmentSubmissionId,
                oralMark,
                TotalMark,
                submissionDate,
                submissionBriefing.getTitle());
    }

}