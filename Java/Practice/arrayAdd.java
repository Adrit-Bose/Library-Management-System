import java.util.Scanner;

public class arrayAdd{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Size of Array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the elements of the Array: ");
        for(int i = 0; i < size ; i++){
            array[i] = sc.nextInt();
        }

    System.out.println("Entered Array is: ");
    for ( int i = 0; i < size; i++){
            System.out.print(array[i] + "");
        }
        sc.close();
    }
}