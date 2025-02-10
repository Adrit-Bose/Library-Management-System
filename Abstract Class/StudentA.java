package Abstract

import java.util.Scanner;

public class StudentA extends Student{
    Scanner scanner = new Scanner(System.in);
    
    public StudentA(String name){
        super(name);
    }

    public int math;
    public int english;
    public int hindi;

    public StudentA(int math, int english, int hindi) {
        this.math = math;
        this.english = english;
        this.hindi = hindi;
    }

    @Override
    void getPercentage() {
    System.out.println("Enter marks of Math");
    int math = scanner.nextInt();

    System.out.println("Enter marks of English");
    int english = scanner.nextInt();

    System.out.println("Enter marks of Hindi");
    int hindi = scanner.nextInt();
    
    double result = (math + english + hindi)/300.0 * 100;
    
    System.out.println("Student A total percentage in: " + result);
    }
}
