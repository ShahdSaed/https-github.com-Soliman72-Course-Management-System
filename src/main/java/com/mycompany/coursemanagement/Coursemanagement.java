package com.mycompany.coursemanagement;

import java.util.*;
import java.time.LocalTime;

public class Coursemanagement {

     public static void main(String[] args) {
        // Step 1: Create Admin
        Admin admin = new Admin("Admin User", "admin@example.com", "admin123");

        // Step 2: Create Teacher
        Teacher teacher1 = new Teacher("Mr. Smith", "teacher123", "smith@example.com", "Mathematics");
        Teacher teacher2 = new Teacher("Ms. Johnson", "teacher456", "johnson@example.com", "Physics");

        // Add teachers via Admin
        admin.addTeacher(teacher1);
        admin.addTeacher(teacher2);

        // Step 3: Create Students
        Student student1 = new Student("John Doe", "student123", "john@example.com");
        Student student2 = new Student("Jane Roe", "student456", "jane@example.com");

        // Add students via Admin
        admin.addStudent(student1);
        admin.addStudent(student2);

        // Step 4: Create Courses
        Course mathCourse = new Course("Mathematics", teacher1, "Algebra and Calculus", 200.0, LocalTime.of(10, 0));
        Course physicsCourse = new Course("Physics", teacher2, "Mechanics and Thermodynamics", 250.0, LocalTime.of(14, 0));

        // Add courses via Admin
        admin.addCourse(mathCourse);
        admin.addCourse(physicsCourse);

        // Step 5: Enroll students in courses
        admin.setCoursesOfStudent(student1, mathCourse);  // John enrolls in Math
        admin.setCoursesOfStudent(student2, physicsCourse);  // Jane enrolls in Physics

        // Admin can assign teacher to course
        admin.setTeacherOfCourse(mathCourse, teacher1);
        admin.setTeacherOfCourse(physicsCourse, teacher2);

        // Step 6: Create Assignment
        Assignment assignment1 = new Assignment(1, "Solve Algebra Problems", "Algebra Assignment", new Date());
        Assignment assignment2 = new Assignment(2, "Mechanics Problems", "Physics Assignment", new Date());

        // Add assignments to courses
        mathCourse.addAssignment(assignment1);
        physicsCourse.addAssignment(assignment2);

        // Step 7: Create and add Notice via Admin
        Notice notice1 = new Notice("Midterm Exam", "The midterm exam will be held on next Monday", "Mathematics", new Date());
        admin.addNotice(notice1, mathCourse);

        // Step 8: Display all courses, students, teachers, and notices via Admin
        System.out.println("Displaying all teachers:");
        Admin.viewAllTeachers();

        System.out.println("\nDisplaying all students:");
        Admin.viewAllStudents();

        System.out.println("\nDisplaying all courses:");
        Admin.viewAllCourses();

        System.out.println("\nDisplaying all notices:");
        Admin.viewAllNotices();

        // Step 9: Display course-specific details
        System.out.println("\nDetails for Math course:");
        System.out.println("Course Name: " + mathCourse.getCourseName());
        System.out.println("Teacher: " + mathCourse.getTeacher().getName());
        mathCourse.viewStudents();
        mathCourse.viewAssignments();
        mathCourse.viewNotices();
    }
}
