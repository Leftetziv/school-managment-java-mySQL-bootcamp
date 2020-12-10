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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        CourseDao cdao = DaoFactory.getCourseDao();

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
                br.setBelongingCourse(cdao.get(rs.getInt("course_id")));
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
    public boolean save(AssignmentBriefing t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AssignmentBriefing get(long id) {
        String sql = "SELECT * FROM assignment_briefings WHERE assignment_brief_id=?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        AssignmentBriefing briefing = new AssignmentBriefing();
        CourseDao cdao = DaoFactory.getCourseDao();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                briefing.setAssignmentBriefId(rs.getInt("assignment_brief_id"));
                briefing.setTitle(rs.getString("title"));
                briefing.setDescription(rs.getString("description"));
                briefing.setMaxOralMark(rs.getInt("max_oral_mark"));
                briefing.setMaxTotalMark(rs.getInt("max_total_mark"));
                briefing.setDueDate(rs.getTimestamp("due_date").toLocalDateTime());
                briefing.setBelongingCourse(cdao.get(rs.getInt("course_id")));
                briefing.setIsGroupProject(rs.getBoolean("is_group_project"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return briefing;
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
        CourseDao cdao = DaoFactory.getCourseDao();
            
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
                br.setDueDate(rs.getTimestamp("due_date").toLocalDateTime());
                br.setBelongingCourse(cdao.get(rs.getInt("course_id")));
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
