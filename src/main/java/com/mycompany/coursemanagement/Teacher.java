/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursemanagement;

import java.util.*;

public class Teacher extends User {
    // Attributes
    private String specialty;
    private final int ID;
    private static int count = 0;
    private List<Course> courses;

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

    // Get the teacher's ID
    public int getID() {
        return ID;
    }

    // Get the list of courses taught by the teacher
    public List<Course> getCourses() {
        return courses;
    }

    public void setDescriptionOfCourse(Course course, String description) {
        // Assuming Course class has a setDescription method
        course.setDescription(description);
    }

    // Edit assignments of a course
    public void editAssignmentsOfCourse(Course course) {
        // Logic to edit assignments of the course
        // This will depend on how the assignments are managed in the Course class
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
    public void assignGrade(Assignment assignment, Grade grade, Student student) {
        student.addGrade(assignment, grade);
    }

    // Set assignment grade of a student
    public void setAssignmentGradeOfStudent(Assignment assignment, Grade grade, Student student) {
        student.addGrade(assignment, grade);
    }

    // Static method to get the number of teachers
    public static int numberOfTeacher() {
        return count;
    }
}