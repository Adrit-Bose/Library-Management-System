package Oops;

import java.util.Scanner;

class Blueprint{
    String colour;
    String type;

    public void Testing(){
        System.out.println("This is in Testing phase");
    }

    public void printColour(){
        System.out.println(this.colour);
    }

    public void printType(){
        System.out.println(this.type);
    }

    public void takeInput(){
        Scanner scan = new Scanner(System.in);
        Integer phase = scan.nextInt();
        System.out.println(phase);
    }

    Blueprint(String colour, String type){
        this.colour = colour;
        this.type = type;
    }

    public void callThem(){
        System.out.println(this.colour);
        System.out.println(this.type);
    }

}

public class Oops {
    public static void main(String args[]){
        
        Blueprint car1 = new Blueprint("Black", "Sport" );
        car1.callThem();

        Blueprint car2 = new Blueprint("Red", "Suv");
        car2.callThem();
    }
}
