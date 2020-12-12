/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.TypeDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.lookup_tables.Subject;
import model.lookup_tables.Type;
import repository.DBConnection;

/**
 *
 * @author Leyteris
 */
public class TypeDaoImpl implements TypeDao {

    private Connection con = null;

    @Override
    public List<Type> getAll() {
        String sql = "SELECT * FROM types";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Type> types = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Type t = new Type();

                t.setTypeId(rs.getLong("type_id"));
                t.setType(rs.getString("type"));

                types.add(t);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return types;
    }

    @Override
    public Type get(Long id) {
        String sql = "SELECT * FROM types where type_id=?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Type t = new Type();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                t.setTypeId(rs.getLong("type_id"));
                t.setType(rs.getString("type"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return t;
    }

}
