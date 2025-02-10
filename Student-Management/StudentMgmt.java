import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

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

public class StudentMgmt {
    public static ArrayList<Student> students = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Select your need");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("Bye! Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option! Please try again.");
            }
        }
    }

    public static void addStudent() {
        System.out.println("Enter the name of the student:");
        String name = scanner.nextLine();

        System.out.println("Enter the age:");
        int age = scanner.nextInt();

        System.out.println("Enter the grade:");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        students.add(new Student(name, age, grade));
        System.out.println("Student has been added.");
    }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students exist.");
            return;
        }

        System.out.println("\nStudent List:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }

    public static void updateStudent() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        viewStudents();
        System.out.println("Enter the student number to update:");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        Student student = students.get(index);

        System.out.println("Enter the new name (Leave blank to keep current name):");
        String name = scanner.nextLine();
        if (!name.isBlank()) {
            student.setName(name);
        }

        System.out.println("Enter the new age (Enter -1 to skip):");
        int age = scanner.nextInt();
        if (age != -1) {
            student.setAge(age);
        }

        System.out.println("Enter the new grade (Enter -1 to skip):");
        double grade = scanner.nextDouble();
        if (grade != -1) {
            student.setGrade(grade);
        }

        System.out.println("Student updated successfully.");
    }

    public static void deleteStudent() {
        if (students.isEmpty()) {
            System.out.println("No students exist.");
            return;
        }

        viewStudents();
        System.out.println("Enter the student number to delete:");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index < 0 || index >= students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        students.remove(index);
        System.out.println("Student removed successfully.");
    }
}
