package org.learningProgressTracker;

// Learning Progress Tracker
//> add students
//Enter student credentials or 'back' to return:
//> John Doe jdoe@yahoo.com
//The student has been added.
//> Jane Spark janes@gmail.com
//The student has been added.
//> back
//Total 2 students have been added.
//> list
//Students:
//10000
//10001
//> add points
//Enter an id and points or 'back' to return:
//> 1000 10 10 5 8
//No student is found for id=1000.
//> 10001 10 10 5 8
//Points updated.
//> 10001 5 8 7 3
//Points updated.
//> 10000 7 7 7 7 7
//Incorrect points format.
//> 10000 -1 2 2 2
//Incorrect points format.
//> 10000 ? 1 1 1
//Incorrect points format.
//> back
//> exit
//Bye!
public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.run();
    }

}
