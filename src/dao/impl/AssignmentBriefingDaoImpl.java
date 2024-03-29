/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.AssignmentBriefingDao;
import dao.CourseDao;
import dao.DaoFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import model.AssignmentBriefing;
import model.Course;
import repository.DBConnection;

/**
 *
 * @author Leyteris
 */
public class AssignmentBriefingDaoImpl implements AssignmentBriefingDao {

    private Connection con = null;

    @Override
    public List<AssignmentBriefing> getAll() {
        String sql = "SELECT * FROM assignment_briefings;";

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<AssignmentBriefing> briefings = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                AssignmentBriefing br = new AssignmentBriefing();

                br.setAssignmentBriefId(rs.getInt("assignment_brief_id"));
                br.setTitle(rs.getString("title"));
                br.setDescription(rs.getString("description"));
                br.setMaxOralMark(rs.getInt("max_oral_mark"));
                br.setMaxTotalMark(rs.getInt("max_total_mark"));
                br.setDueDate(rs.getTimestamp("due_date").toLocalDateTime());
//                br.setDueDate(rs.getTimestamp("due_date").toInstant().atZone(ZoneOffset.UTC).toLocalDateTime());
                br.setBelongingCourseId(rs.getInt("course_id"));
                br.setIsGroupProject(rs.getBoolean("is_group_project"));

                briefings.add(br);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return briefings;
    }

    @Override
    public boolean save(AssignmentBriefing br) {
        String sql = "INSERT INTO assignment_briefings (`title`, `description`, `max_oral_mark`, `max_total_mark`, `due_date`, `course_id`, `is_group_project`) \n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement ps = null;
        int updateSuccess = 0;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, br.getTitle());
            ps.setString(2, br.getDescription());
            ps.setInt(3, br.getMaxOralMark());
            ps.setInt(4, br.getMaxTotalMark());
            ps.setTimestamp(5, Timestamp.valueOf(br.getDueDate()));
//            ps.setTimestamp(5,   Timestamp.valueOf(br.getDueDate().atZone(ZoneId.systemDefault()).toOffsetDateTime().toLocalDateTime())         );
            ps.setLong(6, br.getBelongingCourseId());
            ps.setBoolean(7, br.isIsGroupProject());

            updateSuccess = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(ps, con);
        }

        return updateSuccess == 1;
    }

    @Override
    public AssignmentBriefing get(long id) {
        String sql = "SELECT * FROM assignment_briefings WHERE assignment_brief_id=?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        AssignmentBriefing br = new AssignmentBriefing();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                br.setAssignmentBriefId(rs.getInt("assignment_brief_id"));
                br.setTitle(rs.getString("title"));
                br.setDescription(rs.getString("description"));
                br.setMaxOralMark(rs.getInt("max_oral_mark"));
                br.setMaxTotalMark(rs.getInt("max_total_mark"));
                br.setDueDate(rs.getTimestamp("due_date").toLocalDateTime());
                br.setBelongingCourseId(rs.getInt("course_id"));
                br.setIsGroupProject(rs.getBoolean("is_group_project"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return br;
    }

    @Override
    public List<AssignmentBriefing> getAssignmentBriefingPerCourse(long id) {
        String sql = "SELECT 	assignment_briefings.*\n"
                + "FROM 	assignment_briefings,\n"
                + "             courses\n"
                + "where 	assignment_briefings.course_id = courses.course_id\n"
                + "             and courses.course_id = ?;";

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<AssignmentBriefing> briefings = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                AssignmentBriefing br = new AssignmentBriefing();

                br.setAssignmentBriefId(rs.getInt("assignment_brief_id"));
                br.setTitle(rs.getString("title"));
                br.setDescription(rs.getString("description"));
                br.setMaxOralMark(rs.getInt("max_oral_mark"));
                br.setMaxTotalMark(rs.getInt("max_total_mark"));
//                br.setDueDate(rs.getTimestamp("due_date").toInstant().atZone(ZoneOffset.UTC).toLocalDateTime());
                br.setDueDate(rs.getTimestamp("due_date").toLocalDateTime());
                br.setBelongingCourseId(rs.getInt("course_id"));
                br.setIsGroupProject(rs.getBoolean("is_group_project"));

                briefings.add(br);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return briefings;
    }

}
