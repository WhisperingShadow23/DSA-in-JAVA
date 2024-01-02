import java.util.Scanner;
public class Array{
    public static void main(String args []){
        // Simple form of array

        // int array[] = {1, 2,3,4};
        // for(int i =0;i<3;i++){

        //     System.out.println(array[i]);
        // }

        // Taking an input from the user
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int array[] = new int[size];
       // for taking the input we use the first loop
       for(int i =0;i<size;i++){
         array [i]=sc.nextInt();
        }
         for(int i=0;i<size;i++){
             System.out.println(array[i]);
            }
    }
}