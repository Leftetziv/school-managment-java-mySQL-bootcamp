/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.AssignmentBriefingDao;
import dao.AssignmentSubmissionDao;
import dao.CourseDao;
import dao.DaoFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.AssignmentBriefing;
import model.AssignmentSubmission;
import repository.DBConnection;

/**
 *
 * @author Leyteris
 */
public class AssignmentSubmissionDaoImpl implements AssignmentSubmissionDao {

    private Connection con = null;

    @Override
    public List<AssignmentSubmission> getAll() {
        String sql = "SELECT * FROM assignment_submissions;";

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<AssignmentSubmission> submissions = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                AssignmentSubmission submission = new AssignmentSubmission();

                submission.setAssignmentSubmissionId(rs.getInt("assignment_submission_id"));
                submission.setOralMark(rs.getInt("oral_mark"));
                submission.setTotalMark(rs.getInt("total_mark"));
                submission.setSubmissionDate(rs.getTimestamp("submission_date").toLocalDateTime());
                submission.setSubmissionBriefingId(rs.getInt("assignment_brief_id"));

                submissions.add(submission);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return submissions;
    }

    @Override
    public boolean save(AssignmentSubmission submission) {
        String sql = "INSERT INTO assignment_submissions (`oral_mark`, `total_mark`, `submission_date`, `assignment_brief_id`) VALUES (?, ?, ?, ?);";

        PreparedStatement ps = null;
        int updateSuccess = 0;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, submission.getOralMark());
            ps.setInt(2, submission.getTotalMark());
            ps.setTimestamp(3, Timestamp.valueOf(submission.getSubmissionDate()));
            ps.setLong(4, submission.getSubmissionBriefingId());

            updateSuccess = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(ps, con);
        }

        return updateSuccess == 1;
    }

    @Override
    public AssignmentSubmission get(long id) {
        String sql = "SELECT * FROM assignment_submissions WHERE assignment_submission_id=?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        AssignmentSubmission submission = new AssignmentSubmission();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                submission.setAssignmentSubmissionId(rs.getInt("assignment_submission_id"));
                submission.setOralMark(rs.getInt("oral_mark"));
                submission.setTotalMark(rs.getInt("total_mark"));
                submission.setSubmissionDate(rs.getTimestamp("submission_date").toLocalDateTime());
                submission.setSubmissionBriefingId(rs.getInt("assignment_brief_id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return submission;
    }

    @Override
    public List<AssignmentSubmission> getAssignmentSubmissionPerCourse(long id) {
        String sql = "SELECT 	assignment_submissions.*\n"
                + "FROM     	assignment_submissions,\n"
                + "		assignment_briefings,\n"
                + "             courses        \n"
                + "WHERE	assignment_submissions.assignment_brief_id = assignment_briefings.assignment_brief_id\n"
                + "		and assignment_briefings.course_id = courses.course_id\n"
                + "             and courses.course_id = ?;";

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<AssignmentSubmission> submissions = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                AssignmentSubmission submission = new AssignmentSubmission();

                submission.setAssignmentSubmissionId(rs.getInt("assignment_submission_id"));
                submission.setOralMark(rs.getInt("oral_mark"));
                submission.setTotalMark(rs.getInt("total_mark"));
                submission.setSubmissionDate(rs.getTimestamp("submission_date").toLocalDateTime());
                submission.setSubmissionBriefingId(rs.getInt("assignment_brief_id"));

                submissions.add(submission);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return submissions;
    }

    @Override
    public List<AssignmentSubmission> getAssignmentSubmissionPerCoursePerStudent(long cid, long sid) {
        String sql = "SELECT 	assignment_submissions.*\n"
                + "FROM	assignment_submissions,\n"
                + "		assignment_briefings,\n"
                + "        courses,\n"
                + "        students_assignment_submissions\n"
                + "WHERE	assignment_submissions.assignment_brief_id = assignment_briefings.assignment_brief_id\n"
                + "		and assignment_briefings.course_id = courses.course_id\n"
                + "        and assignment_submissions.assignment_submission_id = students_assignment_submissions.assignment_submission_id\n"
                + "        and students_assignment_submissions.student_id = ?\n"
                + "        and courses.course_id = ?;";

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<AssignmentSubmission> submissions = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, sid);
            ps.setLong(2, cid);
            rs = ps.executeQuery();

            while (rs.next()) {
                AssignmentSubmission submission = new AssignmentSubmission();

                submission.setAssignmentSubmissionId(rs.getInt("assignment_submission_id"));
                submission.setOralMark(rs.getInt("oral_mark"));
                submission.setTotalMark(rs.getInt("total_mark"));
                submission.setSubmissionDate(rs.getTimestamp("submission_date").toLocalDateTime());
                submission.setSubmissionBriefingId(rs.getInt("assignment_brief_id"));

                submissions.add(submission);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return submissions;
    }

}
