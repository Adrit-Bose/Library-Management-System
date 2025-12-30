import java.util.Scanner;

public class arrayPrac {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){

        int[] userArray = getUserArray(6);
        int userSum  = userSum(userArray);
        System.out.println("Your number is " + userSum);

        sc.close();
    } 

    public static int[] getUserArray(int number){

        System.out.println("Entered number is: " + number);
        int[] userDigit = new int[number];

        for(int i=0; i < userDigit.length; i++) {
            userDigit[i] = sc.nextInt();
        }
        return userDigit;
    }

    public static int userSum(int[] array){

        int sum = 0;
        for(int i=0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }
}


