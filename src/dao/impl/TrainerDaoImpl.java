/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.TrainerDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import model.Trainer;
import repository.DBConnection;

/**
 *
 * @author Leyteris
 */
public class TrainerDaoImpl implements TrainerDao {

    private Connection con = null;

    @Override
    public List<Trainer> getTrainersPerCourse(long id) {
        String sql = "SELECT 	* \n" 
                + "FROM 	trainers, \n"
                + "             trainers_courses,\n"
                + "		courses\n"
                + "WHERE 	trainers.trainer_id = trainers_courses.trainer_id\n"
                + "		and courses.course_id = trainers_courses.course_id\n"
                + "             and courses.course_id = ?";
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Trainer> trainers = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Trainer t = new Trainer();

                t.setTrainerId(rs.getInt("trainer_id"));
                t.setFirstName(rs.getString("first_name"));
                t.setLastName(rs.getString("last_name"));
                t.setSubject(rs.getLong("subject_id"));

                trainers.add(t);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return trainers;
    }

    @Override
    public List<Trainer> getAll() {
        String sql = "SELECT * FROM trainers;";   
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Trainer> trainers = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Trainer t = new Trainer();

                t.setTrainerId(rs.getInt("trainer_id"));
                t.setFirstName(rs.getString("first_name"));
                t.setLastName(rs.getString("last_name"));
                t.setSubject(rs.getLong("subject_id"));

                trainers.add(t);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return trainers;
    }

    @Override
    public boolean save(Trainer t) {
        String sql = "INSERT INTO trainers (`first_name`, `last_name`, `subject_id`) VALUES (?, ?, ?);";

        PreparedStatement ps = null;
        int updateSuccess = 0;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getFirstName());
            ps.setString(2, t.getLastName());
            ps.setLong(3, t.getSubject());
            
            updateSuccess = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(ps, con);
        }

        return updateSuccess == 1;
    }

    @Override
    public Trainer get(long id) {
        String sql = "SELECT  * FROM trainers WHERE trainer_id = ?;";              

        PreparedStatement ps = null;
        ResultSet rs = null;
        Trainer t = new Trainer();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                t.setTrainerId(rs.getInt("trainer_id"));
                t.setFirstName(rs.getString("first_name"));
                t.setLastName(rs.getString("last_name"));
                t.setSubject(rs.getLong("subject"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return t;
    }

}
