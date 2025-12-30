class CarInfo {
    String name;
    int model;

    public void printInfo(String name){
        System.out.println(name);
    }

    public void printInfo(int model){
        System.out.println(model);
    }

}

public class polymorphism {
    public static void main(String[] args){
        CarInfo car1 = new CarInfo();
        CarInfo car2 = new CarInfo();
        
        Blueprint vehicle1 = new Blueprint("Beamer", "Sports");

        vehicle1.callThem();

        car1.name = "Porshe";
        car1.model = 0023;

        car2.name = "Bmw";
        car2.model = 2345;
        
        car1.printInfo(car1.model);
    }
}
