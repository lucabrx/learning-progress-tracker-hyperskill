package org.learningProgressTracker;

import java.util.regex.Pattern;



import java.util.HashSet;
import java.util.Set;

public class Student {
    int id;
    private String firstName, lastName, email;

    private final int[] points;

    Set<Integer> notifyCourse;

    public Student(int id) {
        this.id = id;
        points = new int[4];
        notifyCourse = new HashSet<>();
    }

    public int[] getPoints() {
        return points;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    private boolean testString(String input) {
        for (String sl: input.split(" ")) {
            if (sl.length() < 2) return true;
        }
        Pattern pattern = Pattern.compile("[a-zA-Z]+([ '\\-]*[a-zA-Z]*)*");
        Pattern patternNot = Pattern.compile("(\\w*''\\w*)|(\\w*-'\\w*)|(\\w*'-\\w*)|(\\w*--\\w*)|('\\w)|(\\w+')|(-\\w)|(\\w+-)");
        return patternNot.matcher(input).matches() || !pattern.matcher(input).matches();
    }

    private boolean testEmail(String input) {
        Pattern pattern = Pattern.compile("[\\w.]+@\\w+\\.\\w+");
        return pattern.matcher(input).matches();
    }

    public boolean setFirstName(String firstName) {
        if (testString(firstName)) return false;
        this.firstName = firstName;
        return true;
    }

    public boolean setLastName(String lastName) {
        if (testString(lastName)) return false;
        this.lastName = lastName;
        return true;
    }

    public boolean setEmail(String email) {
        if (!testEmail(email)) return false;
        this.email = email;
        return true;
    }

    public void setPoints(int[] arrPoints) {
        for (int i = 0; i < points.length; i++) {
            points[i] += arrPoints[i];
        }
    }

    @Override
    public String toString() {
        return String.format("%d points: Java=%d DSA=%d Databases=%d Spring=%d\n", id, points[0], points[1], points[2], points[3]);
    }

    public int sendMail(int courseId, String courseName, int needPoints) {
        if (points[courseId] >= needPoints && !notifyCourse.contains(courseId)) {
            notifyCourse.add(courseId);
            System.out.printf("To: %s\n", getEmail());
            System.out.println("Re: Your Learning Progress");
            System.out.printf("Hello, %s! You have accomplished our %s course!\n", getFullName(), courseName);
            return getId();
        } else
            return 0;
    }
}