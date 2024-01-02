import java.util.ArrayList;
import java.util.List;
public class ArrayLists{
    public static void main(String args []){
    // Writing the syntax of the Arrays List in java Data Structure
    ArrayList<Integer> list = new ArrayList<>();
    // ArrayList<Booolean> list = new ArrayList<>();
    // ArrayList<String> list = new ArrayList<>();
    // ArrayList<Float> list = new ArrayList<>();
    // ArrayList<Character> list = new ArrayList<>();
    
    // Add Element
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);

    // Delete & remove elemnt
    list.remove(3);
    System.out.println(list);
    // Reverse list
    List<Integer>  ho= list.reversed();
    System.out.println(ho);
    // get value of indexed numbers
   int g =  list.get(3);
    System.out.println(g);
    // set element
  int h =   list.set(2, 3);
    System.out.println(h);
    }
}