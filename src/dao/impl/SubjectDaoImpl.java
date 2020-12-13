/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.SubjectDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.lookup_tables.Stream;
import model.lookup_tables.Subject;
import repository.DBConnection;

/**
 *
 * @author Leyteris
 */
public class SubjectDaoImpl implements SubjectDao {

    private Connection con = null;

    @Override
    public List<Subject> getAll() {
        String sql = "SELECT * FROM subjects";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Subject> subjects = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Subject s = new Subject();

                s.setSubjectId(rs.getInt("subject_id"));
                s.setSubject(rs.getString("subject"));

                subjects.add(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return subjects;
    }

    @Override
    public Subject get(Long id) {
        String sql = "SELECT * FROM subjects where subject_id=?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Subject s = new Subject();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                s.setSubjectId(rs.getInt("subject_id"));
                s.setSubject(rs.getString("subject"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return s;
    }

}
