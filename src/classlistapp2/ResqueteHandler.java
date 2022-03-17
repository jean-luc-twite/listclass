/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classlistapp2;

import ac.za.tut.student.Student;
import ac.za.tut.studentException.StudentException;
import ac.za.tut.studentManager.StudentManager;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class ResqueteHandler implements Runnable{
    private Student students;

    public ResqueteHandler(Student students) {
        this.students = students;
    }
   
    @Override
    public void run() {
        int option;
         Student std1,std2,std3,std4,std5,std6;
         int marks;
          int markFA,markSA;
         Student targetStudent;
         String studentNum;
        StudentManager sm = new StudentManager();
        Scanner sc =new Scanner(System.in);
        try{
          System.out.println(Thread.currentThread().getName() + " started ");  
        
    
          process();     
   System.out.println(Thread.currentThread().getName() + " finished ");
    }catch(StudentException e){
            System.out.println(e.getMessage());
    }
    }

    public int getUserOption() {
        int option;
        //instantiate the scanner
        Scanner sc =new Scanner(System.in);
        //ask user to make choices 
        System.out.println("please select the option below " + "\n" + 
                          "-------------------------------" + "\n" + 
                          "press 1--> to Get and display the classlist" + "\n" +
                          "press 2--> to  Edit the marks of a student for a specific test" + "\n"+
                          "press 3--> to Get and display the details of a specific student "+"\n" +
                          "press 4--> to Add a student record" + "\n" +
                          "press 5--> to Remove a student " + "\n" +
                          "press 6--> to exit the program " + "\n\n" +
                         "your option?");
        option =sc.nextInt();
        return option;
    }
   public synchronized void process()throws StudentException{
        Student std1,std2,std3,std4,std5,std6;
        int option;
         int marks;
          int markFA,markSA;
         Student targetStudent;
         String studentNum;
         // instantiate the Manager
        StudentManager sm = new StudentManager();
        //instatantiate scanner
        Scanner sc =new Scanner(System.in);
        //create student
        std1 = new Student("220770621","twite","ilunga",28,47);
        std2 = new Student("221230965","mulumba","enock",84,49);
        std3 = new Student("220390519","mumpasa","david",78,68);
        std4 = new Student("220825213","katabe","kipoka",54,43);
        std5 = new Student("220995143","mukadi","samis",65,96);
        //add student into the map
        sm.addStudent("220770621", std1);
        sm.addStudent("221230965", std2);
        sm.addStudent("220390519", std3);
        sm.addStudent("220825213", std4);
        sm.addStudent("220995143", std5);
         option =getUserOption();
         while(option !=6){
              switch(option){
         case 1:
      
        //display elements of the map 
        for(Map.Entry student:sm.getStudent().entrySet()){
            System.out.println("\nName " + ((Student)(student.getValue())).getName() + "\n" +
                              "surName " + ((Student)(student.getValue())).getSurName() +"\n"+
                              "student Number " + ((String)(student.getKey())) + "\n" +
                              "Formative assessment " + ((Student)(student.getValue())).getFA() + "\n" +
                              "Summative assessment " + ((Student)(student.getValue())).getSA());
        }
      break;
         case 2:
             System.out.println("please get the student you want modifie");
             studentNum = sc.next();
             //get the student
             targetStudent =sm.getStudent().get(studentNum);
             if(targetStudent !=null){
                 System.out.println("please select which the marks below you want change" + "\n" +
                                    "--------------------------------------------------" + "\n" +
                                    "press 1--> for Formative Assessement" + "\n" +
                                    "press 2--> for Summative Assessements" + "\n" +
                                   "your choise?");
                 marks = sc.nextInt();
                 if(marks == 1){
                     System.out.println("please enter the new marks");
                      markFA =sc.nextInt();
                     targetStudent.setFA(markFA);
                 }else if(marks == 2){
                      System.out.println("please enter the new marks");
                      markSA =sc.nextInt();
                     targetStudent.setSA(markSA);
                 }else{
                     System.out.println(marks + " is invalid");
                 }
                 System.out.println("\ndetails of the modified student"+ "\n" +
                              "--------------------------------" + "\n" +
                              "name :" + targetStudent.getName() + "\n" +
                              "surName :"+ targetStudent.getSurName() + "\n" +
                              "studentNumber :" + targetStudent.getStudentNumber() + "\n" +
                              "Formative assessment :" +targetStudent.getFA()+ "\n" +
                              "Summative assessment :" + targetStudent.getSA());
             }else{
                 System.out.println( studentNum + "is not in the map ");
             }
             break;
         case 3:
              System.out.println("please get the target student");
             studentNum = sc.next();
             //get the student
             targetStudent =sm.getStudent().get(studentNum);
             //display details of the target student
               if(targetStudent !=null){
           System.out.println("\ndetails of the target student"+ "\n" +
                              "--------------------------------" + "\n" +
                              "name :" + targetStudent.getName() + "\n" +
                              "surName :"+ targetStudent.getSurName() + "\n" +
                              "studentNumber :" + targetStudent.getStudentNumber() + "\n" +
                              "Formative assessment :" +targetStudent.getFA()+ "\n" +
                              "Summative assessment :" + targetStudent.getSA());
       }else{
           System.out.println(studentNum + "is not in the map ");
       }
         break;
         case 4:
             System.out.println("please enter the name ");
             String name = sc.next();
             // ask user to enter the surname
             System.out.println("please enter surname ");
             String surName = sc.next();
             //ask user to enter the studentNumber
             System.out.println("please enter student number");
              studentNum = sc.next();
              //ask user to enter Formative assessement'marks
              System.out.println("please enter the Formative marks ");
              markFA =sc.nextByte();
              //ask user user to enter the Summative marks
              System.out.println("please enter summative marks");
               markSA =sc.nextByte();
              //create student
               std6 =new Student(studentNum,name,surName,markFA,markSA);
               //ADD  specfic STUDENT INTO THE MAP
               sm.addStudent(studentNum, std6);
               break;
         case 5:
               System.out.println("please get the  student you want to remove");
             studentNum = sc.next();
             //get the student
             targetStudent =sm.getStudent().remove(studentNum);
             break;
         default:
             System.out.println(option + " is invalid please enter the correct one");
            }
        //desplay the optionn again
            option =getUserOption();      
   }
}
}
