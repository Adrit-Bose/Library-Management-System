package Abstract Class;

import java.util.Scanner;

public class StudentB extends student {
    Scanner scanner = new Scanner(System.in);

    public int math;
    public int english;
    public int hindi;
    public int science;

    public StudentA(int math, int english, int hindi, int science) {
        this.math = math;
        this.english = english;
        this.hindi = hindi;
        this.science = science;
    }

     @Override
    void getPercentage() {
    System.out.println("Enter marks of Math");
    int math = scanner.nextInt();

    System.out.println("Enter marks of English");
    int english = scanner.nextInt();

    System.out.println("Enter marks of Hindi");
    int hindi = scanner.nextInt();

    System.out.println("Enter marks of Science");
    int science = scanner.nextInt();
    
    double result = (math + english + hindi + science)/400.0 * 100;
    
    System.out.println("Student A total percentage in: " + result);
    }
}
