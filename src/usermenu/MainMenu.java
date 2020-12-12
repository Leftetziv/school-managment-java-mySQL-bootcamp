/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import services.*;
import utilities.ReadFromUserUtilities;

/**
 *
 * @author Leyteris
 */
public class MainMenu {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String choiceMenu = "";

        choiceMenu += "Enter the number of the procedure you want to do, or q to quit\n";
        choiceMenu += "1  - Show all Students\n";
        choiceMenu += "2  - Show all Trainers\n";
        choiceMenu += "3  - Show all Assignment Briefings\n";
        choiceMenu += "4  - Show all Assignment Submissions\n";
        choiceMenu += "5  - Show all Courses\n";
        choiceMenu += "6  - Show all Students per course\n";
        choiceMenu += "7  - Show all Trainers per course\n";
        choiceMenu += "8  - Show all Assignments Briefings per Course\n";
        choiceMenu += "9  - Show all Assignments Submissions per Course\n";
        choiceMenu += "10 - Show all Assignments Submissions per Course per Student\n";
        choiceMenu += "11 - Show all Students in Multiple Courses\n";
        choiceMenu += "12 - ADD NEW\n";

        Long answerLong;
        
        do {
            System.out.println(choiceMenu);
            answerLong = ReadFromUserUtilities.readNumberOrQuit(LongStream.rangeClosed(1, 12).boxed().collect(Collectors.toList()));

            if (answerLong != -1) {
                switch (answerLong.intValue()) {
                    case 1:
                        StudentService.printAllStudents();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 2:
                        TrainerService.printAllTrainers();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 3:
                        AssignmentBriefingService.printAllAssignmentsBriefings();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 4:
                        AssignmentSubmissionService.printAllAssignmentsSubmissions();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 5:
                        CourseService.printAllCourses();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 6:
                        StudentService.printStudentsPerCourse();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 7:
                        TrainerService.printTrainersPerCourse();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 8:
                        AssignmentBriefingService.printAssignmentBriefingsPerCourse();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 9:
                        AssignmentSubmissionService.printAssignmentSubmissionsPerCourse();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 10:
                        AssignmentSubmissionService.printAssignmentSubmissionsPerCoursePerStudent();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 11:
                        StudentCourseService.printMulticourseStudents();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    case 12:    //add new
                        AddMenu.addElement();
                        System.out.println("Press enter to continue...");
                        sc.nextLine();
                        break;
                    default:
                        System.out.println("Enter on of the given numbers");
                }
            } else {
                break;
            }
        } while (true);

    }

}
