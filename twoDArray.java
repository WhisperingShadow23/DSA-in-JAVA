import java.util.Scanner;

public class twoDArray{

  
  public static void main (String args []){
    // Simple twoD Array
    // int numbers[][]  = new int[3][3];
    // // numbers[i] = {20,30,40};
    // for(int i = 0; i<3;i++){
    // for(int j = 0; j<3; j++){
    //   System.out.println(numbers[i][j]);
    // }
    // }
    Scanner sc = new Scanner(System.in);
    int row  = sc.nextInt();
    int col  = sc.nextInt();
    int numbers[][] = new int[row][col];
    // outer looops for the Input from the user 
    for(int i = 0;i<row; i++){
      for(int j = 0; j<col;j++){
        numbers[i][j] = sc.nextInt();
      }
    }
    // Inner loops for output & printing the statement
    for(int i = 0; i<row;i++){
      for(int j= 0; j<col; j++){
        System.out.println(numbers[i][j]);
      }
    }
  }
}
  