/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.TrainerDao;
import java.sql.Connection;
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
        String sql = "SELECT 	trainers.trainer_id,	\n"
                + "		trainers.first_name,\n"
                + "		trainers.last_name,\n"
                + "             subjects.subject\n"
                + "FROM 	trainers, \n"
                + "		subjects,\n"
                + "             trainers_courses,\n"
                + "		courses\n"
                + "WHERE 	trainers.trainer_id = trainers_courses.trainer_id\n"
                + "		and courses.course_id = trainers_courses.course_id\n"
                + "             and trainers.subject_id = subjects.subject_id\n"
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
                t.setSubject(rs.getString("subject"));

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
        String sql = "SELECT  trainers.trainer_id, trainers.first_name, trainers.last_name, subjects.subject "
                + "FROM trainers, subjects "
                + "WHERE trainers.subject_id = subjects.subject_id;";
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
                t.setSubject(rs.getString("subject"));

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Trainer get(long id) {
        String sql = "SELECT  trainers.trainer_id, trainers.first_name, trainers.last_name, subjects.subject "
                + "FROM trainers, subjects "
                + "WHERE trainers.subject_id = subjects.subject_id"
                + "and trainer_id = ?;";

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
                t.setSubject(rs.getString("subject"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return t;
    }

}
