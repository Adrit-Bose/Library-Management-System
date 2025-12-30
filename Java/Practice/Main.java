public class Main{

    public static void main(String[] args) {
    int temp = 20;
    if (temp < 30){
        System.out.println("warm");
    }else if(temp > 20 && temp <30){
        System.out.println("Normal");
    }else{
        System.out.println("Normal");
    }
    
    switch (temp) {
        case warm:
        System.out.println("Tempreature is Warm");
        break;
    
        case Normal:
        System.out.println("Temp is Normal");
        break;

        default:
        System.out.println("Temp is cold");
            break;
    }
    }
}