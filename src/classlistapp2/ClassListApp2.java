/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package classlistapp2;

import ac.za.tut.student.Student;
import ac.za.tut.studentManager.StudentManager;

/**
 *
 * @author HP
 */
public class ClassListApp2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create common source
        Student students = new Student();
       StudentManager sm = new StudentManager();
       sm.getStudent();
        //pass througth the runnable
        ResqueteHandler thread = new ResqueteHandler(students);
        //create the three thread 
        Thread lecturer1 = new Thread(thread);
        Thread lecturer2 = new Thread(thread);
        Thread lecturer3 = new Thread(thread);
        //name the thread
        lecturer1.setName(" Mr Mulenga ");
        lecturer2.setName(" Mr Mulumba ");
        lecturer3.setName(" Mr Sibiya ");
        //start
        lecturer1.start();
        lecturer2.start();
        lecturer3.start();
        
    }
    
}
