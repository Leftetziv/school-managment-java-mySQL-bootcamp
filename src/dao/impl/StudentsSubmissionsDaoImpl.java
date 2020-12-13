/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.StudentsSubmissionsDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import repository.DBConnection;

/**
 *
 * @author Leyteris
 */
public class StudentsSubmissionsDaoImpl implements StudentsSubmissionsDao {

    private Connection con = null;

    @Override
    public void save(List<Long> studentsId, long submId) {
        String sql = "INSERT INTO students_assignment_submissions (`student_id`, `assignment_submission_id`) VALUES (?, ?);";

        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);

            for (long studentId : studentsId) {
                ps.setLong(1, studentId);
                ps.setLong(2, submId);

                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(ps, con);
        }
    }

}
