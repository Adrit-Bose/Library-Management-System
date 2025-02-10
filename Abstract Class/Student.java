package Abstract Class;

public abstract class Student {

    public String Name;
    public Student(String name){
        Name = name;
    }
    
    public abstract void getPercentage();

    public String getName(){
        return Name;
    }
}
