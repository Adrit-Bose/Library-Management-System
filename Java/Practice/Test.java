import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
public class Test {

public static void main(String[] args){


     LinkedList engAlphabet = new LinkedList();
     
     addInAscOrd(engAlphabet,"Dog");
     addInAscOrd(engAlphabet,"Fish");
    addInAscOrd(engAlphabet,"Apple");
    addInAscOrd(engAlphabet,"Cat");
     addInAscOrd(engAlphabet,"Zebra");
    addInAscOrd(engAlphabet,"Monkey");
    addInAscOrd(engAlphabet,"Bat");
    addInAscOrd(engAlphabet,"Icecream");


    addInAscOrd(engAlphabet,"Dog");
    printList(engAlphabet);
    addInAscOrd(engAlphabet,"Jackpot");
    printList(engAlphabet);
    addInAscOrd(engAlphabet,"Abacus");
    printList(engAlphabet);
     


   
   }
   private static void printList(LinkedList linkedlist){
    Iterator i = linkedlist.iterator();
    while(i.hasNext()){
        System.out.println("Printing: " +i.next());
    }
    System.out.println(".......................");
   }


   private static boolean addInAscOrd(LinkedList linkedList, String newWord){
    ListIterator stringListIterator = linkedList.listIterator();
    while(stringListIterator.hasNext()){
        int compare = stringListIterator.next().compareTo(newWord);
        if(compare == 0){
            System.out.println("Word already exists");
            return false;
        }
        else if(compare > 0){
            //new word would come before
            stringListIterator.previous();
            stringListIterator.add(newWord);
            return true;
        }else if(compare < 0){
            return true;


        }
    }
    stringListIterator.add(newWord);
    return true;
  }
   }
