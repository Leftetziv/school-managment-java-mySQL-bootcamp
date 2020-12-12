/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import model.lookup_tables.Subject;

/**
 *
 * @author Leyteris
 */
public class SubjectService {
    public static void print(Subject s) {
        String format = "%-5s%-23s%n";
        System.out.printf(format, s.getSubjectId(), s.getSubject());
    }

    public static void columnPrint() {
        String formatColumn = "%-5s%-23s%n";
        System.out.printf(formatColumn, "ID", "Subject");
    }
}
