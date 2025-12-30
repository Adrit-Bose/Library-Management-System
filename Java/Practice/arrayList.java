import java.util.ArrayList;

public class arrayList {
    public static void main(String[] args){

        ArrayList<String> fruit = new ArrayList<>();

        fruit.add("Banana");
        fruit.add("Apple");
        fruit.add("Guava");
        fruit.add("Grape");
        fruit.add("Mange");

        System.out.println("Fruits in the array list are: " + fruit);

        fruit.set(0, "Papaya");
        fruit.set(1, "Egsg");
        fruit.set(2, "Kiwi");
        fruit.set(3, "Cali");
        
        System.out.println("Updated fruit list in ArrayList: " + fruit);

        fruit.remove(1);
        System.out.println("Updated fruit list after remove in ArrayList: " + fruit);

        System.out.println(fruit.size());

        System.out.println("fruit at position 3: " + fruit.get(3));
        System.out.println("List of ArrayList: " + fruit);

        System.out.println("Check if it contain eggs: " + fruit.contains("Eggs"));
    }
}

import java.util.*;

class DateItem {
    String date;

    DateItem(String date) {
        this.date = date;
    }
}

class sortItems implements Comparator<DateItem> {
    public int compare(DateItem a, DateItem b) {
        return a.date.compareTo(b.date);
    }
}

public class Main {
    public static void main(String args[]) {
        ArrayList<DateItem> dateList = new ArrayList<>();
        dateList.add(new DateItem("2020-03-25"));
        dateList.add(new DateItem("2019-01-27"));
        dateList.add(new DateItem("1998-01-27"));
        dateList.add(new DateItem("1998-02-26"));
        Collections.sort(dateList, new sortItems());
        System.out.println("Sorted in Ascending Order");
        for (DateItem d : dateList) {
            System.out.println(d.date);
        }
    }
}