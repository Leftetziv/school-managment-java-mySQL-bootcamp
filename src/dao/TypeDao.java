/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.lookup_tables.Stream;
import model.lookup_tables.Type;

/**
 *
 * @author Leyteris
 */
public interface TypeDao {

    List<Type> getAll();
    
    Type get(Long id);

}
