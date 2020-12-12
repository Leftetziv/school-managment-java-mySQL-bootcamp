/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.util.List;
import model.Student;
import dao.StudentsCoursesDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import repository.DBConnection;

/**
 *
 * @author Leyteris
 */
public class StudentCoursesDaoImpl implements StudentsCoursesDao {

    private Connection con = null;

    
    
    @Override
    public List<Student> getStudentsInMultipleCourses() {
        String sql = "select	students.*\n"
                + "from 	students_courses,\n"
                + "		students\n"
                + "where 	students.student_id = students_courses.student_id\n"
                + "group by     students_courses.student_id\n"
                + "having 	count(students_courses.student_id)>1;";
        
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
    public boolean save(long sid, long cid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
