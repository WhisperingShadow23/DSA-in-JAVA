public class Recursion1{

    // Recalling the functions by itself is called an Recursion". It is mostly using in the Tree and grap data structue
    
    public static void printNumb(int n){
        if(n == 6){
            return;
        }
        System.out.println(n);
        printNumb(n+1);
    }
    public static void main(String args []){
        int n = 1;
       printNumb(n);
    }
}