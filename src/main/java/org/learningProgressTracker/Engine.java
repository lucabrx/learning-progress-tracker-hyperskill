package org.learningProgressTracker;


public class Engine {
    final static String EXIT = "exit", BACK = "back", ADD = "add students", LIST = "list";
    final static String FIND = "find", ADD_P = "add points", STAT = "statistics", NOTIFY = "notify";

    private static ClassRoom classRoom;

    public Engine() {
        classRoom = new ClassRoom();
    }

    public void run() {
        System.out.println("Learning Progress Tracker");
        while (true) {
            switch (Utils.getLine()) {
                case "" -> System.out.println("No input.");
                case EXIT -> {
                    System.out.println("Bye!");
                    return;
                }
                case BACK -> System.out.println("Enter 'exit' to exit the program.");
                case ADD -> addStudents();
                case LIST -> showStudents();
                case FIND -> findStudents();
                case ADD_P -> addPoints();
                case STAT -> getStats();
                case NOTIFY -> getNotify();
                default -> System.out.println("Unknown command!");
            }
        }
    }

    private static void addStudents() {
        System.out.println("Enter student credentials or 'back' to return:");
        var count = 0;
        while (true) {
            var input = Utils.getLine();
            if (BACK.equals(input)) {
                System.out.printf("Total %d students have been added.\n", count);
                return;
            } else {
                if (classRoom.addStudent(input)) count++;
            }
        }
    }

    private static void showStudents() {
        if (!classRoom.getStudents().isEmpty()) {
            System.out.println("Students:");
            for (var st : classRoom.getStudents().entrySet()) {
                System.out.println(st.getKey());
            }
        } else {
            System.out.println("No students found.");
        }
    }

    private static void findStudents() {
        System.out.println("Enter an id or 'back' to return:");
        while (true) {
            var input = Utils.getLine();
            if (BACK.equals(input)) {
                return;
            } else {
                classRoom.findStudent(input);
            }
        }
    }

    private static void addPoints() {
        System.out.println("Enter an id and points or 'back' to return:");
        while (true) {
            var input = Utils.getLine();
            if (BACK.equals(input)) {
                return;
            } else {
                classRoom.addPoints(input);
            }
        }
    }

    private static void getStats() {
        System.out.println("Type the name of a course to see details or 'back' to quit");
        classRoom.getStats();
        while (true) {
            var input = Utils.getLine();
            if (BACK.equals(input)) {
                return;
            } else {
                classRoom.getStat(input);
            }
        }
    }

    private void getNotify() {
        classRoom.sendMails();
    }

}