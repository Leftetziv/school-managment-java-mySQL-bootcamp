/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.StudentDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import model.Student;
import repository.DBConnection;

/**
 *
 * @author Leyteris
 */
public class StudentDaoImpl implements StudentDao {

    private Connection con = null;

    @Override
    public List<Student> getAll() {
        String sql = "SELECT * FROM students";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();

                s.setStudentId(rs.getInt("student_id"));
                s.setFirstName(rs.getString("first_name"));
                s.setLastName(rs.getString("last_name"));
                s.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
                s.setTuitionFees(rs.getDouble("tuition_fees"));

                students.add(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return students;
    }

    @Override
    public boolean save(Student s) {
        String sql = "INSERT INTO students (`first_name`, `last_name`, `date_of_birth`, `tuition_fees`) VALUES (?, ?, ?, ?);";

        PreparedStatement ps = null;
        int updateSuccess = 0;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, s.getFirstName());
            ps.setString(2, s.getLastName());
            ps.setDate(3, Date.valueOf(s.getDateOfBirth()));
            ps.setDouble(4, s.getTuitionFees());
            
            updateSuccess = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(ps, con);
        }

        return updateSuccess == 1;
    }

    @Override
    public List<Student> getStudentsPerCourse(long id) {
        String sql = "SELECT 	students.*\n"
                + "FROM     	students, \n"
                + "		courses, \n"
                + "             students_courses\n"
                + "WHERE 	students.student_id = students_courses.student_id\n"
                + "		and courses.course_id = students_courses.course_id\n"
                + "             and courses.course_id = ?;";

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();

                s.setStudentId(rs.getInt("student_id"));
                s.setFirstName(rs.getString("first_name"));
                s.setLastName(rs.getString("last_name"));
                s.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
                s.setTuitionFees(rs.getDouble("tuition_fees"));

                students.add(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return students;
    }

    @Override
    public Student get(long id) {
        String sql = "SELECT * FROM students WHERE course_id = ?;";

        PreparedStatement ps = null;
        ResultSet rs = null;
        Student student = new Student();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                student.setStudentId(rs.getInt("student_id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
                student.setTuitionFees(rs.getDouble("tuition_fees"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return student;
    }

}
