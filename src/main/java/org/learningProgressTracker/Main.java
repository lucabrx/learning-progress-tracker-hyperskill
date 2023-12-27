package org.learningProgressTracker;

public class Main {
    final static String EXIT = "exit";
    final static String BACK = "back";
    final static String ADD = "add students";


    public static void main(String[] args) {
        ClassRoom classRoom = new ClassRoom();
        System.out.println("Learning Progress Tracker");
        while (true) {
            switch (Utils.getLine()) {
                case "" -> System.out.println("No input.");
                case EXIT -> {
                    System.out.println("Bye!");
                    return;
                }
                case BACK -> System.out.println("Enter 'exit' to exit the program.");
                case ADD -> addStudents(classRoom);
                default -> System.out.println("Unknown command!");
            }
        }
    }

    private static void addStudents(ClassRoom classRoom) {
        System.out.println("Enter student credentials or 'back' to return:");
        var count = 0;
        while (true) {
            String input = Utils.getLine();
            if (BACK.equals(input)) {
                System.out.printf("Total %d students have been added.\n", count);
                return;
            } else {
                if (classRoom.addStudent(input)) count++;
            }
        }
    }
}
