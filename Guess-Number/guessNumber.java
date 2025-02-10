import java.util.Random;
import java.util.Scanner;

public class guessNumber {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Random random = new Random(); 

    int randomNumber = random.nextInt(5) + 3;   
    
    System.out.println("Guess the number");

    int guess = 0;
    while (guess != randomNumber){
        System.out.println("Enter the number");
        guess = scan.nextInt();

        if(guess > randomNumber){
            System.out.println("Guess Number is not the number");
        }
        
        if(guess < randomNumber){
            System.out.println("Guess Number is not the number");   
        }
    
        else{
            System.out.println("It is correct");
        }
    }
        scan.close();
    }
}
