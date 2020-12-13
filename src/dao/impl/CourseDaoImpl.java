/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CourseDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.AssignmentSubmission;
import model.Course;
import model.Trainer;
import repository.DBConnection;

/**
 *
 * @author Leyteris
 */
public class CourseDaoImpl implements CourseDao {

    private Connection con = null;

    @Override
    public List<Course> getAll() {
        String sql = "SELECT * FROM courses;";

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Course> courses = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Course c = new Course();

                c.setCourseId(rs.getInt("course_id"));
                c.setTitle(rs.getString("title"));
                c.setStreamId(rs.getLong("stream_id"));
                c.setTypeId(rs.getLong("type_id"));
                c.setStartDate(rs.getDate("start_date").toLocalDate());
                c.setEndDate(rs.getDate("end_date").toLocalDate());

                courses.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return courses;
    }

    @Override
    public boolean save(Course c) {
        String sql = "INSERT INTO courses (`title`, `stream_id`, `type_id`, `start_date`, `end_date`) VALUES (?, ?, ?, ?, ?);";

        PreparedStatement ps = null;
        int updateSuccess = 0;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getTitle());
            ps.setLong(2, c.getStreamId());
            ps.setLong(3, c.getTypeId());
            ps.setDate(4, Date.valueOf(c.getStartDate()));
            ps.setDate(5, Date.valueOf(c.getEndDate()));

            updateSuccess = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(ps, con);
        }

        return updateSuccess == 1;
    }

    @Override
    public Course get(long id) {
        String sql = "SELECT * FROM courses where course_id = ?;";

        PreparedStatement ps = null;
        ResultSet rs = null;
        Course course = new Course();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                course.setCourseId(rs.getInt("course_id"));
                course.setTitle(rs.getString("title"));
                course.setStreamId(rs.getLong("stream_id"));
                course.setTypeId(rs.getLong("type_id"));
                course.setStartDate(rs.getDate("start_date").toLocalDate());
                course.setEndDate(rs.getDate("end_date").toLocalDate());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return course;
    }

}
