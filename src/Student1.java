import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student1 {

    // A class to represent a student
    static class Student {
        String name;
        int id;
        int age;
        String email;
        String course;

        Student(int id, String name, int age, String email, String course) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.email = email;
            this.course = course;
        }

        @Override
        public String toString() {
            return '\n' + "ID: " + id + '\n' + "Name: " + name + '\n' + "Age: " + age + '\n' + "Email: " + email + '\n' + "Course: " + course;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Application Title and Initial Prompt for users
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("***************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        String initialChoice = scanner.nextLine();

        if (!initialChoice.equals("1")) {
            System.out.println("Exiting the application...");
            return;
        }
        //Menu using a while loop
        while (running) {
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("(1) Capture a new Student");
            System.out.println("(2) Search for a Student by ID");
            System.out.println("(3) Delete a Student");
            System.out.println("(4) Print Student report");
            System.out.println("(5) Exit Application");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    //Calling the saveStudent() method
                    saveStudent(students, scanner);
                    break;

                case 2:
                    //Calling the searchStudent() method
                    searchStudent(students, scanner);
                    break;

                case 3:
                    //Calling the deleteStudent() method
                    deleteStudent(students, scanner);
                    break;

                case 4:
                    //Calling the studentReport() method
                    studentReport(students);
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting the application...");
                    break;

                default:
                    System.out.println("Invalid option! Please choose again.");
                    break;
            }
        }
        scanner.close();
    }
    //Capturing student information
    public static void saveStudent(ArrayList<Student> students, Scanner scanner) {
        // Adding the Student information
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("***************************************");
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        // Validating the age input to make sure that it's a number and above 16
        int age;
        while (true) {
            System.out.print("Enter student age (must be above 16): ");
            try {
                age = scanner.nextInt();
                if (age > 16) {
                    // going to next line
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("You have entered the incorrect student age");
                    System.out.print("Please re-enter the student age >> ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                // Consume invalid input
                scanner.next();
            }
        }

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter student course: ");
        String course = scanner.nextLine();

        students.add(new Student(id, name, age, email, course));
        System.out.println("Student added successfully!");
    }

    public static void searchStudent(ArrayList<Student> students, Scanner scanner) {
        // Search for Student by ID
        System.out.print("Enter student ID to search: ");
        int searchId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean found = false;
        for (Student student : students) {
            if (student.id == searchId) {
                System.out.println("Student found:");
                System.out.println(student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found!");
        }
    }

    // Method to delete a student by ID
    public static void deleteStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.print("Enter student ID to delete: ");
        int deleteId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean removed = students.removeIf(student -> student.id == deleteId);
        if (removed) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void studentReport(ArrayList<Student> students) {
        // View All the current Students
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("Student Report");
            System.out.println("***************************************");
            for (Student student : students) {
                System.out.println(student);
                System.out.println("***************************************");
            }
        }
    }
}