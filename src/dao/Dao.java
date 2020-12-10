/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Leyteris
 */
public interface Dao<T> {

    T get(long id);

    List<T> getAll();

    boolean save(T t);
}
