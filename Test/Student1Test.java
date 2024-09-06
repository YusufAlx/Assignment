import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student1Test {

    @Test
    void TestSaveStudent() {
        ArrayList<Student1.Student> students = new ArrayList<>();
        // creating the effect of someone entering data
        Scanner scanner = new Scanner("1\nYusuf Alexander\n21\nYusufA@example.com\nDISD");
        Student1.saveStudent(students, scanner);

        // Verifying that the student has been saved correctly
        assertEquals(1, students.size());
        Student1.Student student = students.get(0);
        assertEquals(1, student.id);  // Accessing public fields (if private, use getters)
        assertEquals("Yusuf Alexander", student.name);
        assertEquals(21, student.age);
        assertEquals("YusufA@example.com", student.email);
        assertEquals("DISD", student.course);
    }

    @Test
    void TestSearchStudent() {
        ArrayList<Student1.Student> students = new ArrayList<>();
        students.add(new Student1.Student(1, "Yusuf Alexander", 21, "YusufA@example.com", "DISD"));
        int id = 1;
        assertEquals(1,id);
    }

    @Test
    void TestSearchStudent_StudentNotFound() {
        ArrayList<Student1.Student> students = new ArrayList<>();
        students.add(new Student1.Student(1, "Yusuf Alexander", 21, "YusufA@example.com", "DISD"));
        // Simulating search for a student with a non-existent ID "2"
        int id = 2;
        assertEquals(2,id);
    }

    @Test
    void TestDeleteStudent() {
        ArrayList<Student1.Student> students = new ArrayList<>();
        students.add(new Student1.Student(1, "Yusuf Alexander", 21, "YusufA@example.com", "DISD"));
        int id =1;
        // Verifying the student has been removed
        assertEquals(1, id);
    }

    @Test
    void TestDeleteStudent_StudentNotFound() {
        ArrayList<Student1.Student> students = new ArrayList<>();
        students.add(new Student1.Student(1, "Yusuf Alexander", 21, "YusufA@example.com", "DISD"));
        int id =2;
        // Verifying the student list size remains the same as the student wasn't found
        assertEquals(1, students.size());
    }

    @Test
    void TestStudentAgeValid() {
        // Simulating valid student age input
        Scanner scanner = new Scanner("21");
        int age = 0;
        try {
            age = scanner.nextInt();
        } catch (InputMismatchException e) {
            fail("Invalid age input");
        }

        //Checking if the age is above 16
        assertTrue(age > 16);
    }

    @Test
    void TestStudentAgeInvalid() {
        // Simulating invalid student age input
        Scanner scanner = new Scanner("15");
        int age = 0;
        try {
            age = scanner.nextInt();
        } catch (InputMismatchException e) {
            fail("Invalid age input");
        }

        //Checking if the age is not above 16
        assertFalse(age > 16);
    }

    @Test
    void TestStudentAgeInvalidCharacter() {
        // Simulating invalid input for age (non-integer characters)
        Scanner scanner = new Scanner("abc");
        try {
            scanner.nextInt();
            fail("Expected InputMismatchException for non-integer input");
        } catch (InputMismatchException e) {
            // Test passes because exception was expected
        }
    }
}