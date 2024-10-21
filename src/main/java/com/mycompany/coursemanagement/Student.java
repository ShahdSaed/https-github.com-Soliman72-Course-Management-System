/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.coursemanagement;
import java.util.*;


public class Student extends User {
    // Attributes
    private final int ID;
    private static int count = 0;
    private List<Course> courses;
    private Map<Assignment, Grade> assignmentGrade;
    private Map<Course, Grade> courseGrade;

    // Constructor
    public Student(String name, String password, String email) {
        super(name, email, password);
        this.ID = ++count; // Automatically increment the student ID
        this.courses = new ArrayList<>();
        this.assignmentGrade = new HashMap<>();
        this.courseGrade = new HashMap<>();
    }

    // Getters
    public int getID() {
        return ID;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Map<Assignment, Grade> getAssignmentGrade() {
        return assignmentGrade;
    }

    public Map<Course, Grade> getCourseGrade() {
        return courseGrade;
    }

    // View details of the student
    public void viewDetails() {
        System.out.println("Student ID: " + ID);
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
    }

    // View enrolled courses
    public void viewCourses() {
        System.out.println("Enrolled Courses:");
        for (Course course : courses) {
            System.out.println(course.getCourseName());
        }
    }

    // Calculate and display course grades
    public void calculateCourseGrade() {
        for (Course course : courses) {
            // Logic to calculate the course grade based on assignments (if needed)
            Grade courseGrade = new Grade(90, "Well Done", "Course"); // Example
            this.courseGrade.put(course, courseGrade);
        }
    }

    // View all assignment grades
    public void viewAssignmentGrades() {
        System.out.println("Assignment Grades:");
        for (Map.Entry<Assignment, Grade> entry : assignmentGrade.entrySet()) {
            System.out.println("Assignment: " + entry.getKey().getTitle() + ", Grade: " + entry.getValue().getGrade());
        }
    }

    // View all course grades
    public void viewCourseGrades() {
        System.out.println("Course Grades:");
        for (Map.Entry<Course, Grade> entry : courseGrade.entrySet()) {
            System.out.println("Course: " + entry.getKey().getCourseName() + ", Grade: " + entry.getValue().getGrade());
        }
    }

    // View grade for a specific course
    public void viewCourseGrade(Course course) {
        if (courseGrade.containsKey(course)) {
            System.out.println("Course: " + course.getCourseName() + ", Grade: " + courseGrade.get(course).getGrade());
        } else {
            System.out.println("No grade available for this course.");
        }
    }

    // Enroll the student in a new course
    public void enrollCourse(Course course) {
        courses.add(course);
    }

    // Submit an assignment and add the grade
    public void submitAssignment(Assignment assignment, Course course) {
        Grade assignmentGrade = new Grade(85, "Good Job", "Assignment"); // Example grade
        this.assignmentGrade.put(assignment, assignmentGrade);
        System.out.println("Submitted assignment: " + assignment.getTitle() + " for course: " + course.getCourseName());
    }

    // Calculate total price of courses (if there's a price attribute in Course)
    public double totalPriceOfCourses() {
        double totalPrice = 0;
        for (Course course : courses) {
            totalPrice += course.getPrice(); // Assuming Course class has a getPrice() method
        }
        return totalPrice;
    }

    // Static method to get the number of students
    public static int numberOfStudent() {
        return count;
    }

    // Add grade for a specific assignment
    public void addGrade(Assignment assignment, Grade grade) {
        assignmentGrade.put(assignment, grade);
    }
}
