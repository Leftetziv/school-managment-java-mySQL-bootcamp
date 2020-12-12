/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import model.Course;
import model.lookup_tables.Stream;

/**
 *
 * @author Leyteris
 */
public class StreamService {
    public static void print(Stream s) {
        String format = "%-5s%-23s%n";
        System.out.printf(format, s.getStreamId(), s.getStream());
    }

    public static void columnPrint() {
        String formatColumn = "%-5s%-23s%n";
        System.out.printf(formatColumn, "ID", "Stream");
    }
}
