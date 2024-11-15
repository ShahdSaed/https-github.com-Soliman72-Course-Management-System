/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_project;

import java.io.IOException;
import static java.lang.Math.round;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teacher extends User {
    // Attributes
    private String specialty;
    private final int ID;
    private static int count = 0;
    private ArrayList<Course> courses;

    // Constructor
    public Teacher(String name, String password, String email, String specialty) {
        super(name, email, password);
        this.specialty = specialty;
        this.ID = ++count;  // Automatically increment the teacher ID
        this.courses = new ArrayList<>();
    }

    // Getter and Setter for specialty
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public String getSpecialty() {
        return specialty;
    }

    public void addCourses(Course course) {
        this.courses.add(course);
    }
    
    // Get the teacher's ID
    public int getID() {
        return ID;
    }
    
    // Get the list of courses taught by the teacher
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setDescriptionOfCourse(Course course, String description) {
        // Assuming Course class has a setDescription method
        course.setDescription(description);
    }
    // Set description of an assignment
    public void setDescriptionOfAssignment(Assignment assignment, String description) {
        assignment.setDescription(description);
    }

    // Set title of an assignment
    public void setTitleOfAssignment(Assignment assignment, String title) {
        assignment.setTitle(title);
    }

    // Set the deadline of an assignment
    public void setDeadlineOfAssignment(Assignment assignment, Date deadline) {
        assignment.setDeadline(deadline);
    }

    // Create an assignment for a course
    public void createAssignment(Course course, Assignment assignment) {
        course.addAssignment(assignment);
    }

    // Assign a grade for an assignment to a student
    public void assignGrade(Assignment assignment, Student student) {
        Grade grade=calculateAssignmentGrade();
        System.out.println("Assigning grade " + grade.getGrade() + " to student " + student.getName() + " for assignment " + assignment.getTitle());
        student.addGrade(assignment, grade);
    }
    
    public void assignGrade(Student student){
        student.calculateCourseGrade();
    }
    //calculate Assignment Grade
    public Grade calculateAssignmentGrade(){
        Grade grade = new Grade();
        grade.setGrade(round(50));
        grade.setType("Assignment");
        if(grade.getGrade()>0&&grade.getGrade()<25)
            grade.setComment("fail");
        else if(grade.getGrade()>=25&&grade.getGrade()<40)
            grade.setComment("good");
        else if(grade.getGrade()>=40&&grade.getGrade()<=50)
            grade.setComment("Well done");
        return grade;        
    }
    // Set assignment grade for a student
    public void setAssignmentGradeOfStudent(Assignment assignment, Grade grade, Student student) {
        System.out.println("Setting grade " + grade.getGrade() + " for student " + student.getName() + " in assignment " + assignment.getTitle());
        student.addGrade(assignment, grade);
    }

    // Static method to get the number of teachers
    public static int numberOfTeacher() {
        return count;
    }
    
    public void logIn(String email,String password){
        FileManagement fileManager = new FileManagement();
        try {
            ArrayList<Student> students = fileManager.readFromFile("students.txt", line -> {
                String[] parts = line.split(",");
                
                // Ensure the data has exactly 3 parts (name, email, password)
                if (parts.length >0) {
                    return new Student(parts[0], parts[1], parts[2]);
                } else {
                    // Log error message for invalid data
                    System.err.println("Invalid student data: " + Arrays.toString(parts));
                    return null;  // Handle invalid data (e.g., skip this entry)
                }
                
            }); 
            for(Student student : students){
                if(email==student.getEmail()&&password==student.getPassword())
                    System.out.println(student.getName()+"Logged in");
                else
                    System.out.println("Incorrect Email or Password");
            }
        }catch (IOException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void logOut(){
        FileManagement fileManager = new FileManagement();
        try {
            ArrayList<Student> students = fileManager.readFromFile("students.txt", line -> {
                String[] parts = line.split(",");
                
                // Ensure the data has exactly 3 parts (name, email, password)
                if (parts.length >0) {
                    return new Student(parts[0], parts[1], parts[2]);
                } else {
                    // Log error message for invalid data
                    System.err.println("Invalid student data: " + Arrays.toString(parts));
                    return null;  // Handle invalid data (e.g., skip this entry)
                }
                
            }); 
            for(Student student : students){
                
                    
            }
        }catch (IOException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
