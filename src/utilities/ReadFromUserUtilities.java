/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Leyteris
 */
public class ReadFromUserUtilities {

    private static Scanner sc = new Scanner(System.in);

    public static long readNumberOrQuit(List<Long> numberList) {
        String answerStr;

        do {
            answerStr = sc.nextLine();

            if ("q".equalsIgnoreCase(answerStr)) {
                return -1L;
            }

            try {
                Long answerLong = Long.parseLong(answerStr);

                if (numberList.contains(answerLong)) {
                    return answerLong;
                } else {
                    System.out.println("Wrong input, input a valid number");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong input, input a valid number, or q to quit");
            }
        } while (true);
    }
    
    public static long readLong(List<Long> selectionList) {
        String answerStr;

        do {
            answerStr = sc.nextLine();

            try {
                Long answerLong = Long.parseLong(answerStr);

                if (selectionList.contains(answerLong)) {
                    return answerLong;
                } else {
                    System.out.println("Wrong input, input a valid number");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong input, input a valid number");
            }
        } while (true);
    }
    
    public static List<Long> readListOfLong(List<Long> selectionList) {
        List<Long> numberList = new ArrayList<>();
        String answerStr;
        List<String> splittedStr;

        do {
            answerStr = sc.nextLine();

            try {
                splittedStr = Arrays.asList(answerStr.split(","));
                splittedStr.stream().forEach(String::trim);

                for (String s : splittedStr) {
                    numberList.add(Long.parseLong(s));
                }

                if (selectionList.containsAll(numberList)) {
                    return numberList;
                } else {
                    System.out.println("Wrong input, Seperate multiple values by a comma");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong input, Seperate multiple values by a comma");
            }
        } while (true);
    }
    
    public static int readInt() {
        String answerStr;
        int answerInt;

        do {
            answerStr = sc.nextLine();

            try {
                answerInt = Integer.parseInt(answerStr);
                if (answerInt < 0) {
                    System.out.println("Cant be a negative number");
                    continue;
                }
                return answerInt;
            } catch (NumberFormatException e) {
                System.out.println("Must input a number");
            }
        } while (true);
    }

    

    public static double readDouble() {
        String answerStr;
        double answerInt;

        do {
            answerStr = sc.nextLine();

            try {
                answerInt = Double.parseDouble(answerStr);
                if (answerInt < 0) {
                    System.out.println("Cant be a negative number");
                    continue;
                }
                return answerInt;
            } catch (NumberFormatException e) {
                System.out.println("Must input a number");
            }
        } while (true);
    }

    public static String readString() {
        String answerStr;

        do {
            answerStr = sc.nextLine();

            if (answerStr == null || answerStr.isEmpty()) {
                System.out.println("Input can not be empty");
                continue;
            }
            return answerStr;

        } while (true);
    }

    public static LocalDate readDate() {
        String answerStr;

        do {
            answerStr = sc.nextLine();

            try {
                return LocalDate.parse(answerStr);
            } catch (DateTimeParseException e) {
                System.out.println("Wrong input, enter a date in format YYYY-MM-DD");
            }
        } while (true);
    }

    public static LocalDateTime readDateTime() {
        String answerStr;

        do {
            answerStr = sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            try {
                return LocalDateTime.parse(answerStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Wrong input, enter a date in format YYYY-MM-DD HH:MM");
            }
        } while (true);
    }

    public static boolean readYesOrNo() {
        String answerStr;

        do {
            answerStr = sc.nextLine();

            if ("yes".equalsIgnoreCase(answerStr)) {
                return true;
            } else if ("no".equalsIgnoreCase(answerStr)) {
                return false;
            } else {
                System.out.println("Must input yes or no");
            }
        } while (true);
    }
}
