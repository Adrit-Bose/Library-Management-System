import java.util.Scanner;

public class calculator{
    public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    System.out.println("Choose your Operator");
    System.out.println("1. Addition");
    System.out.println("2. Subtraction");
    System.out.println("3. Division");
    System.out.println("4. Multiplication");
    
    System.out.println("Enter Your Choice");
    int Operator = scan.nextInt();

    System.out.println("Enter the first number: ");
    int num1 = scan.nextInt();

    System.out.println("Enter the second number: ");
    int num2 = scan.nextInt();
    
    int result;  

    switch(Operator){
    
    case 1 : result = num1 + num2;
    System.out.println("Result of the Addition is: " + result);
    break;

    case 2 : 
    if(num1 > num2){
        result = num1 - num2;
        System.out.println("Result of Substraction is: " + result);
    }else{
        result = num2 - num1;
        System.out.println("Result of Substraction is: " + result);
    }
    break;

    case 3 : 
    if(num1 > num2){
    result = num1 / num2;
    System.out.println("Result of Division is: " + result);
    }else {
        result = num2 / num1;
    System.out.println("Result of Division is: " + result);
    }
    break;

    case 4 : result = num1 * num2;
    System.out.println("Result of multiplication is: "+ result);
    break;

        }
    }
}