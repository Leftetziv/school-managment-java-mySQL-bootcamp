/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.CourseDao;
import java.sql.Connection;
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
        String sql = "SELECT	courses.course_id, \n"
                + "		courses.title,\n"
                + "             streams.stream,\n"
                + "             types.type, \n"
                + "             courses.start_date, \n"
                + "             courses.end_date \n"
                + "FROM 	courses, \n"
                + "		streams,\n"
                + "             types\n"
                + "where 	courses.type_id = types.type_id\n"
                + "		and courses.stream_id = streams.stream_id;";

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
                c.setStream(rs.getString("stream"));
                c.setType(rs.getString("type"));
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
    public boolean save(Course t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Course get(long id) {
        String sql = "SELECT	courses.course_id, \n"
                + "		courses.title,\n"
                + "             streams.stream,\n"
                + "             types.type, \n"
                + "             courses.start_date, \n"
                + "             courses.end_date \n"
                + "FROM 	courses, \n"
                + "		streams,\n"
                + "             types\n"
                + "where 	courses.type_id = types.type_id\n"
                + "		and courses.stream_id = streams.stream_id\n"
                + "             and course_id = ?;";

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
                course.setStream(rs.getString("stream"));
                course.setType(rs.getString("type"));
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
