/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.StreamDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import model.lookup_tables.Stream;
import repository.DBConnection;

/**
 *
 * @author Leyteris
 */
public class StreamDaoImpl implements StreamDao {

    private Connection con = null;

    @Override
    public List<Stream> getAll() {
        String sql = "SELECT * FROM streams";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Stream> streams = new ArrayList<>();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Stream s = new Stream();

                s.setStreamId(rs.getLong("stream_id"));
                s.setStream(rs.getString("stream"));

                streams.add(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return streams;
    }

    @Override
    public Stream get(Long id) {
        String sql = "SELECT * FROM streams where stream_id=?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Stream s = new Stream();

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                s.setStreamId(rs.getLong("stream_id"));
                s.setStream(rs.getString("stream"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBConnection.closeConnection(rs, ps, con);
        }

        return s;
    }

}
