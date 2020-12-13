/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 *
 * @author Leyteris
 */
public class AssignmentSubmission {

    private long assignmentSubmissionId;
    private int oralMark;
    private int TotalMark;
    private LocalDateTime submissionDate;
    private long submissionBriefingId;

    public AssignmentSubmission() {
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

    public long getSubmissionBriefingId() {
        return submissionBriefingId;
    }

    public void setSubmissionBriefingId(long submissionBriefingId) {
        this.submissionBriefingId = submissionBriefingId;
    }

    public int compareTo(AssignmentSubmission j) {
        return (int) (this.assignmentSubmissionId - j.assignmentSubmissionId);
    }

    

}