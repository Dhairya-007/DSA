package Patterns;

import java.util.Scanner;

public class PatternPractice {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int numberOfRows = sc.nextInt();

        /*
         ======================================================
                         PATTERN 1
         Solid Square
         Example (n = 3)
         ***
         ***
         ***
         ======================================================
        */
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfRows; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println(); // Space between patterns


        /*
         ======================================================
                         PATTERN 2
         Right Angle Triangle (Stars)
         Example (n = 3)
         *
         **
         ***
         ======================================================
        */
        for (int i = 1; i <= numberOfRows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();


        /*
         ======================================================
                         PATTERN 3
         Increasing Numbers Triangle
         Example (n = 3)
         1
         12
         123
         ======================================================
        */
        for (int i = 1; i <= numberOfRows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println();


        /*
         ======================================================
                         PATTERN 4
         Repeating Row Numbers
         Example (n = 3)
         1
         22
         333
         ======================================================
        */
        for (int i = 1; i <= numberOfRows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }

        System.out.println();


        /*
         ======================================================
                         PATTERN 5
         Inverted Star Triangle
         Example (n = 3)
         ***
         **
         *
         ======================================================
        */
        for (int i = numberOfRows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();


        /*
         ======================================================
                         PATTERN 6
         Pyramid Pattern
         Example (n = 3)
           *
          ***
         *****
         ======================================================
        */
        for (int i = 1; i <= numberOfRows; i++) {

            // Print spaces
            for (int j = 1; j <= numberOfRows - i; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        System.out.println();


        /*
         ======================================================
                         PATTERN 7
         Inverted Pyramid
         Example (n = 3)
         *****
          ***
           *
         ======================================================
        */
        for (int i = numberOfRows; i >= 1; i--) {

            // Print spaces
            for (int j = 1; j <= numberOfRows - i; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        System.out.println();


                /*
         ==========================================
                INVERTED NUMBER TRIANGLE
         Example (n = 5)

         12345
         1234
         123
         12
         1
         ==========================================
        */

        // Outer loop controls rows
        for (int i = numberOfRows; i >= 1; i--) {

            // Inner loop prints numbers from 1 to i
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // Move to next line after each row
            System.out.println();
        }

        sc.close();
    }
}