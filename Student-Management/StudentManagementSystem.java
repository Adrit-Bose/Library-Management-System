import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private double grade;

    // Constructor
    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("Exiting system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        students.add(new Student(name, age, grade));
        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\nStudent List:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }

    private static void updateStudent() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        viewStudents();
        System.out.print("Enter the number of the student to update: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (index < 0 || index >= students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        System.out.print("Enter new name (leave blank to keep current): ");
        String name = scanner.nextLine();
        System.out.print("Enter new age (or -1 to keep current): ");
        int age = scanner.nextInt();
        System.out.print("Enter new grade (or -1 to keep current): ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Student student = students.get(index);
        if (!name.isEmpty())
            student.setName(name);
        if (age != -1)
            student.setAge(age);
        if (grade != -1)
            student.setGrade(grade);

        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        viewStudents();
        System.out.print("Enter the number of the student to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (index < 0 || index >= students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        students.remove(index);
        System.out.println("Student deleted successfully.");
    }
}
