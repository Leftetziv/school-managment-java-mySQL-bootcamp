/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.lookup_tables.Stream;

/**
 *
 * @author Leyteris
 */
public interface StreamDao {

    List<Stream> getAll();

    Stream get(Long id);
}
