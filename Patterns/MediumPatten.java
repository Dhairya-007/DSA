package Patterns;

import java.util.Scanner;

public class MediumPatten {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of rows: ");
    int numberOfRows = sc.nextInt();


    // ============================================================
    // 1️⃣ Diamond Star Pattern
    // Example (n = 4)
    /*
    *
    **
    ***
    ****
    ***
    **
    *
    */
    // ============================================================
    for(int i=1;i<=(2*numberOfRows)-1;i++){
      if(i<=numberOfRows){
        for(int j=1;j<=i;j++){
          System.out.print("*");
        }
      } else {
        for(int j=1;j<=2*(numberOfRows)-i;j++){
          System.out.print("*");
        }
      }
      System.out.println();
    }

    System.out.println();


    // ============================================================
    // 2️⃣ Binary Triangle
    // Example (n = 4)
    /*
    1
    01
    101
    0101
    */
    // ============================================================
    for(int i=1;i<=numberOfRows;i++){
      int start = (i%2==1) ? 1 : 0;
      for(int j=1;j<=i;j++){
        System.out.print(start);
        start = 1 - start;
      }
      System.out.println();
    }

    System.out.println();


    // ============================================================
    // 3️⃣ Mirror Number Pattern
    // Example (n = 4)
    /*
    1      1
    12    21
    123  321
    12344321
    */
    // ============================================================
    for(int i=1;i<=numberOfRows;i++){
      for(int j=1;j<=i;j++){
        System.out.print(j);
      }
      for(int j=1;j<=2*(numberOfRows-i);j++){
        System.out.print(" ");
      }
      for(int j=i;j>0;j--){
        System.out.print(j);
      }
      System.out.println();
    }

    System.out.println();


    // ============================================================
    // 4️⃣ Floyd’s Triangle
    // Example (n = 4)
    /*
    1
    2 3
    4 5 6
    7 8 9 10
    */
    // ============================================================
    int print = 1;
    for(int i=1;i<=numberOfRows;i++){
      for(int j=1;j<=i;j++){
        System.out.print(print++ +" ");
      }
      System.out.println();
    }
      
    System.out.println();


    // ============================================================
    // 5️⃣ Alphabet Increasing
    // Example (n = 4)
    /*
    A
    AB
    ABC
    ABCD
    */
    // ============================================================
    for(int i=1;i<=numberOfRows;i++){
      for(char j='A';j<'A'+i;j++){
        System.out.print(j);
      }
      System.out.println();
    }

    System.out.println();


    // ============================================================
    // 6️⃣ Reverse Alphabet
    // Example (n = 4)
    /*
    ABCD
    ABC
    AB
    A
    */
    // ============================================================

    for(int i=numberOfRows;i>=1;i--){
      for(char j='A';j<'A'+i;j++){
        System.out.print(j);
      }
      System.out.println();
    }
    
    System.out.println();



    // ============================================================
    // 7️⃣ Same Alphabet in Row
    // Example (n = 4)
    /*
    A
    BB
    CCC
    DDDD
    */
    // ============================================================
    for(int i=1;i<=numberOfRows;i++){
      for(int j=1;j<=i;j++){
        System.out.print((char)(i+64));
      }
      System.out.println();
    }

    System.out.println();


    // ============================================================
    // 8️⃣ Alphabet Palindrome Pyramid
    // Example (n = 4)
    /*
       A
      ABA
     ABCBA
    ABCDCBA
    */
    // ============================================================
 
    for(int i=1;i<=numberOfRows;i++){
      for(int j=numberOfRows;j>i;j--){
        System.out.print(" ");
      }
      for(char j='A';j<'A'+i;j++){
        System.out.print(j);
      }
      for(char j=(char) ('A'+i-2);j>='A';j--){
        System.out.print(j);
      }
      System.out.println();
    }
    System.out.println();


    // ============================================================
    // 9️⃣ Butterfly Pattern
    // Example (n = 4)
    /*
    ****    ****
    ***      ***
    **        **
    *          *
    *          *
    **        **
    ***      ***
    ****    ****
    */
    // ============================================================

    for(int i=numberOfRows;i>=1;i--){
      for(int j=1;j<=i;j++){
        System.out.print("*");
      }
      for(int j=2*numberOfRows;j>2*i;j--){
        System.out.print(" ");
      }
      for(int j=1;j<=i;j++){
        System.out.print("*");
      }
      System.out.println();
    }
    for(int i=1;i<=numberOfRows;i++){
      for(int j=1;j<=i;j++){
        System.out.print("*");
      }
      for(int j=2*numberOfRows;j>2*i;j--){
        System.out.print(" ");
      }
      for(int j=1;j<=i;j++){
        System.out.print("*");
      }
      System.out.println();
    }
    System.out.println();



    // ============================================================
    // 🔟 Hollow Square
    // Example (n = 4)
    /*
    ****
    *  *
    *  *
    ****
    */
    // ============================================================
    
    for(int i=1;i<=numberOfRows;i++){
      for(int j=1;j<=numberOfRows;j++){
        if(j==1 || j==numberOfRows || i==1 || i==numberOfRows){
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
    System.out.println();
    


    // ============================================================
    // 1️⃣1️⃣ Concentric Square Pattern (ACTIVE)
    // Example (n = 4)
    /*
    4444444
    4333334
    4322234
    4321234
    4322234
    4333334
    4444444
    */
    // ============================================================

    int size = 2 * numberOfRows - 1;

    for (int i = 1; i <= size; i++) {
      for (int j = 1; j <= size; j++) {

        int top = i - 1;
        int left = j - 1;
        int bottom = size - i;
        int right = size - j;

        int minDistance = Math.min(
                Math.min(top, bottom),
                Math.min(left, right)
        );

        System.out.print(numberOfRows - minDistance);
      }
      System.out.println();
    }

    System.out.println();


    sc.close();
  }
}