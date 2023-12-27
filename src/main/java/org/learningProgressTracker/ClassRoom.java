package org.learningProgressTracker;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
    List<Student> students;

    public ClassRoom() {
        students = new ArrayList<>();
    }

    public boolean addStudent(String studentLine) {
        Student student = new Student();
        var array = studentLine.split(" ");
        if (array.length < 3) {
            System.out.println("Incorrect credentials");
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < array.length - 1; i++) {
            if (i > 1) stringBuilder.append(" ");
            stringBuilder.append(array[i]);
        }
        if (!student.setFirstName(array[0])) {
            System.out.println("Incorrect first name.");
            return false;
        }
        if (!student.setLastName(stringBuilder.toString())) {
            System.out.println("Incorrect last name.");
            return false;
        }
        if (!student.setEmail(array[array.length - 1])) {
            System.out.println("Incorrect email.");
            return false;
        }
        students.add(student);
        System.out.println("The student has been added.");
        return true;
    }
}

