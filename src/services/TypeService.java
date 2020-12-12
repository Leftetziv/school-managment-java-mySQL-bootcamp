/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import model.lookup_tables.Type;

/**
 *
 * @author Leyteris
 */
public class TypeService {
    public static void print(Type t) {
        String format = "%-5s%-23s%n";
        System.out.printf(format, t.getTypeId(), t.getType());
    }

    public static void columnPrint() {
        String formatColumn = "%-5s%-23s%n";
        System.out.printf(formatColumn, "ID", "Type");
    }
}
