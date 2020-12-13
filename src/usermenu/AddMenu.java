/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermenu;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import services.AssignmentBriefingService;
import services.AssignmentSubmissionService;
import services.CourseService;
import services.StudentCourseService;
import services.StudentService;
import services.TrainerCourseService;
import services.TrainerService;
import utilities.ReadFromUserUtilities;

/**
 *
 * @author Leyteris
 */
public class AddMenu {

    static void addElement() {
        Scanner sc = new Scanner(System.in);
        String choiceMenu = "";

        choiceMenu += "Enter the number of the procedure you want to do, or q to quit\n";
        choiceMenu += "1  - Add course\n";
        choiceMenu += "2  - Add trainer\n";
        choiceMenu += "3  - Add student\n";
        choiceMenu += "4  - Add assignment briefing to a course\n";
        choiceMenu += "5  - Add student submission\n";
        choiceMenu += "6  - Enroll a student to course\n";
        choiceMenu += "7  - Assign traner to course\n";

        System.out.println(choiceMenu);
        Long answerLong = ReadFromUserUtilities.readNumberOrQuit(LongStream.rangeClosed(1, 7).boxed().collect(Collectors.toList()));

        if (answerLong == -1) {
            return;
        }

        switch (answerLong.intValue()) {
            case 1:
                CourseService.addCourse();              
                break;
            case 2:
                TrainerService.addTrainer();
                break;
            case 3:
                StudentService.addStudent();            
                break;
            case 4:
                AssignmentBriefingService.addAssignmentBriefing();              
                break;
            case 5:
                AssignmentSubmissionService.addAssignmentSubmission();                
                break;
            case 6:
                StudentCourseService.enrollStudent();                
                break;
            case 7:
                TrainerCourseService.assignTrainer();//??? eite edo eite sto TrainerCourseService               
                break;           
        }
    }
}
