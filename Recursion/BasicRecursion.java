package Recursion;

public class BasicRecursion {

  public static void main(String[] args) {

    printNameCountTime(1, 8);
    print1ToN(1,5);
    printNTo1(1,5);

    System.out.println("Sum (parameterized recursion) = " + printSumToN(1,6,0)); // O(n) time, O(n) stack

    System.out.println("Factorial (parameterized recursion) = " + printFactorialToN(1, 6, 1)); // O(n) time, O(n) stack

    System.out.println("Sum (functional recursion) = " + printSumToNFunctional(5)); // O(n) time, O(n) stack

    System.out.println("Factorial (functional recursion) = " + printNFactorial(6)); // O(n) time, O(n) stack


    System.out.println("Fibonacci(0) = " + fibonacci(0)); // O(2^n) time, O(n) stack
    System.out.println("Fibonacci(1) = " + fibonacci(1));
    System.out.println("Fibonacci(2) = " + fibonacci(2));
    System.out.println("Fibonacci(3) = " + fibonacci(3));
    System.out.println("Fibonacci(4) = " + fibonacci(4));
    System.out.println("Fibonacci(5) = " + fibonacci(5));
    System.out.println("Fibonacci(6) = " + fibonacci(6));

    int[] arr = {1, 2, 9, 5 , 8, 7};
    String s1 = "Dhaiyra";
    String s2 = "naman";

    System.out.println("Is \"" + s1 + "\" Palindrome? -> " + checkStringPalindrom(s1, 0)); // O(n)
    System.out.println("Is \"" + s2 + "\" Palindrome? -> " + checkStringPalindrom(s2, 0)); // O(n)

    reverseArrar(arr, 0, arr.length-1); // O(n)
    reverseArrar1Pointer(arr, 0); // O(n)

    System.out.println("Array after reversing twice:");
    for(int a:arr){
      System.out.println(a);
    }
  }

  // Time: O(n) | Space: O(n)
  public static void printNameCountTime(int index,int count){
    if(index>count){
      return;
    }
    System.out.println("Dhairya"); 
    printNameCountTime(index+1, count);
  }

  // Time: O(2^n) | Space: O(n)
  // Reason: Each call splits into 2 recursive calls
  public static int fibonacci(int index){
    if(index<=1){
      return index;
    }
    return fibonacci(index-1)+fibonacci(index-2);
  }

  // Time: O(n) | Space: O(n)
  public static void print1ToN(int index,int count){
    if(index>count){
      return;
    }
    System.out.println(index);
    print1ToN(index+1, count);
  }

  // Time: O(n) | Space: O(n)
  public static void printNTo1(int index,int count){
    if(index>count){
      return;
    }
    printNTo1(index+1, count);
    System.out.println(index);
  }

  // Time: O(n) | Space: O(n)
  // Parameterized recursion
  public static int printSumToN(int index,int count,int sum){
    if(index>count){
      return sum;
    }
    return printSumToN(index+1, count,sum+index);
  }

  // Time: O(n) | Space: O(n)
  // Functional recursion
  public static int printSumToNFunctional(int n){
    if(n<=0){
      return 0;
    }
    return n + printSumToNFunctional(n-1);
  }

  // Time: O(n) | Space: O(n)
  public static int printFactorialToN(int index,int count,int product){
    if(index>count){
      return product;
    }
    return printFactorialToN(index+1, count,product*index);
  }

  // Time: O(n) | Space: O(n)
  public static int printNFactorial(int n){
    if(n<=1){
      return 1;
    }
    return n * printNFactorial(n-1);
  }

  // Time: O(n/2) ≈ O(n) | Space: O(n)
  public static void reverseArrar(int [] arr,int left,int right){
    if(left>=right){
      return;
    }
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    reverseArrar(arr, left+1, right-1);
  }

  // Time: O(n/2) ≈ O(n) | Space: O(n)
  public static void reverseArrar1Pointer(int [] arr,int index){
    if(index>=arr.length/2){
      return;
    }
    int temp = arr[index];
    arr[index] = arr[arr.length-1-index];
    arr[arr.length-1-index] = temp;
    reverseArrar1Pointer(arr, index+1);
  }

  // Time: O(n) | Space: O(n)
  public static boolean checkStringPalindrom(String s,int index){
    if(index>=s.length()/2){
      return true;
    }
    char [] temp = s.toCharArray(); // creates new array each call
    if(temp[index] == temp[s.length()-1-index]){
      return checkStringPalindrom(s, index+1);
    } else {
      return false;
    }
  }

  // Time: O(n) | Space: O(n)
  // Two pointer recursion ignoring non-alphanumeric
  public static boolean isPalindromingString(String s,int left,int right){
    if(left>=right){
        return true;
    }

    if (!Character.isLetterOrDigit(s.charAt(left))) {
        return isPalindromingString(s, left + 1, right);
    }

    if (!Character.isLetterOrDigit(s.charAt(right))) {
        return isPalindromingString(s, left,right-1);
    }

    char[] temp = s.toCharArray(); // Extra array each recursion (can be optimized)
    if (Character.toLowerCase(temp[left]) != Character.toLowerCase(temp[right])) {
        return false;
    }
    return isPalindromingString(s,left+1,right-1);
  }
}