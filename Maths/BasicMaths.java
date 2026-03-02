package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BasicMaths {

  public static void main(String[] args) {

    System.out.println(gcd(3, 12));
    System.out.println(gcd(24, 42));

    printDigits(1234);
    System.out.println();
    System.out.println(countDigits(1224));
    printDigits(-345);
    System.out.println();
    System.out.println(countDigits(-123));
    printDigits(23243);
    System.out.println();
    System.out.println(countDigits(34343));
    printDigits(-5737);
    System.out.println();

    System.out.println(reverseOfNumber(235));
    System.out.println(reverseOfNumber(-345));
    System.out.println(reverseOfNumber(14793));

    System.out.println(CheckArmStrongNumber(371));
    System.out.println(CheckArmStrongNumber(1634));
    System.out.println(CheckArmStrongNumber(35));

    System.out.println(countDigits(-233232));
    printDivisors(34);
    System.out.println();
    printDivisors(36);
    System.out.println();
    printDivisorsOptimized(39);
    System.out.println();
    printDivisorsOptimized(56);
    System.out.println();
    System.out.println(checkPrime(9));
    System.out.println(checkPrime(13));
    System.out.println(checkPrime(19));
    System.out.println(checkPrime(21));

    printPrimeDivisorsOptimized3(34);
    System.out.println();
    printPrimeDivisorsOptimized3(36);
    System.out.println();
    printPrimeDivisorsOptimized3(39);
    System.out.println();
    printPrimeDivisorsOptimized3(56);
    System.out.println();
  }

  // ------------------------------------------------------------
  // Prints digits of a number (in reverse order)
  // TC: O(log10(n))
  // SC: O(log10(n)) (due to LinkedList)
  // ------------------------------------------------------------
  public static void printDigits(int n){
    List<Integer> digits = new LinkedList<>();

    if(n<0) n = Math.abs(n);

    while(n>0){
      digits.add(n%10);
      n/=10;
    }

    for(int digit:digits){
      System.out.print(digit+" ");
    }
  }

  // ------------------------------------------------------------
  // Counts number of digits using logarithm
  // TC: O(1)
  // SC: O(1)
  // ------------------------------------------------------------
  public static int countDigits(int n){
    return (int)Math.log10(Math.abs(n))+1;
  }

  // ------------------------------------------------------------
  // Reverses a number (handles negative)
  // TC: O(log10(n))
  // SC: O(1)
  // ------------------------------------------------------------
  public static int reverseOfNumber(int n){

    int sign = 1;

    if(n<0) {
      n = Math.abs(n);
      sign = -1;
    }

    int answer = 0;

    while(n>0){
      answer = answer*10 + n%10;
      n/=10;
    }

    if(sign==-1) answer = -answer;

    return answer;
  }

  // ------------------------------------------------------------
  // Euclidean Algorithm for GCD
  // TC: O(log(min(n1,n2)))
  // SC: O(1)
  // ------------------------------------------------------------
  public static int gcd(int n1,int n2){

    while(n1>0 && n2>0){
      if(n1>n2) {
        n1 = n1%n2;
      } else {
        n2 = n2 % n1;
      }
    }

    if(n1==0) return n2;
    return n1;
  }

  // ------------------------------------------------------------
  // Checks if number is palindrome
  // TC: O(log10(n))
  // SC: O(1)
  // ------------------------------------------------------------
  public static boolean PalindromeNumber(int n){
    return reverseOfNumber(n)==n;
  }

  // ------------------------------------------------------------
  // Checks Armstrong Number
  // Example: 371 = 3^3 + 7^3 + 1^3
  // TC: O(d) where d = number of digits
  // SC: O(1)
  // ------------------------------------------------------------
  public static boolean CheckArmStrongNumber(int n){

    int digits = 0;
    int copy = n;

    while(copy > 0){
        digits++;
        copy /= 10;
    }

    int sum = 0;
    int temp = n;

    if(n<0) {
      return false;
    }

    while(n>0){
      int rem = n%10;
      sum = (int) (sum + Math.pow(rem, digits));
      n/=10;
    }

    return sum==temp;
  }

  // ------------------------------------------------------------
  // Prints all divisors (Brute Force)
  // TC: O(n)
  // SC: O(n) (worst case all divisors stored)
  // ------------------------------------------------------------
  public static void printDivisors(int n){

    List<Integer> divisors = new LinkedList<>();

    for(int i=1;i<=n;i++){
      if(n%i==0){
        divisors.add(i);
      }
    }

    for(int digit:divisors){
      System.out.print(digit+" ");
    }
  }

  // ------------------------------------------------------------
  // Optimized Divisors using sqrt
  // TC: O(sqrt(n))
  // SC: O(sqrt(n))
  // ------------------------------------------------------------
  public static void printDivisorsOptimized(int n){

    List<Integer> divisors = new LinkedList<>();

    for(int i=1;i*i<=n;i++){
      if(n%i==0){
        divisors.add(i);
        if(n/i!=i){
          divisors.add(n/i);
        }
      }
    }

    for(int digit:divisors){
      System.out.print(digit+" ");
    }
  }

  // ------------------------------------------------------------
  // Prime Check using sqrt
  // TC: O(sqrt(n))
  // SC: O(1)
  // ------------------------------------------------------------
  public static boolean checkPrime(int n){

    if(n <= 1){
        return false;
    }

    for(int i=2;i*i<=n;i++){
      if(n%i==0){
        return false;
      }
    }

    return true;
  }

  // ------------------------------------------------------------
  // Prime Divisors (Using sqrt + checkPrime)
  // TC: O(sqrt(n) * sqrt(n))
  // SC: O(sqrt(n))
  // ------------------------------------------------------------
  public static void printPrimeDivisorsOptimized(int n){

    List<Integer> primeDivisors = new LinkedList<>();

    for(int i=1;i*i<=n;i++){
      if(n%i==0){
        if(checkPrime(i)) primeDivisors.add(i);

        if(n/i!=i){
          if(checkPrime(n/i)) primeDivisors.add(n/i);
        }
      }
    }

    for(int digit:primeDivisors){
      System.out.print(digit+" ");
    }
  }

  // ------------------------------------------------------------
  // Prime Factorization (Better)
  // TC: O(n) worst case
  // SC: O(log n)
  // ------------------------------------------------------------
  public static void printPrimeDivisorsOptimized2(int n){

    List<Integer> primeDivisors = new LinkedList<>();

    for(int i=2;i<=n;i++){
      if(n%i==0){
        primeDivisors.add(i);

        while(n%i==0){
          n = n/i;
        }
      }
    }

    for(int digit:primeDivisors){
      System.out.print(digit+" ");
    }
  }

  // ------------------------------------------------------------
  // Most Optimized Prime Factorization
  // TC: O(sqrt(n))
  // SC: O(log n)
  // ------------------------------------------------------------
  public static void printPrimeDivisorsOptimized3(int n){

    List<Integer> primeDivisors = new LinkedList<>();

    for(int i=2;i*i<=n;i++){
      if(n%i==0){
        primeDivisors.add(i);

        while(n%i==0){
          n = n/i;
        }
      }
    }

    if(n!=1) primeDivisors.add(n);

    for(int digit:primeDivisors){
      System.out.print(digit+" ");
    }
  }

  // ------------------------------------------------------------
  // Fast Power (Binary Exponentiation)
  // TC: O(log n)
  // SC: O(1)
  // ------------------------------------------------------------
  public double myPow(double x, int n) {

      double ans = 1.0;
      long num = n;

      if(num<0) num = (-1)*num;

      while(num>0){

          if(num%2==0){
              x = x*x;
              num = num/2;
          }
          else {
              ans = ans*x;
              num = num-1;
          }
      }

      if(n<0) ans = 1.0/ans;

      return ans;
  }

  // ------------------------------------------------------------
  // Sieve of Eratosthenes
  // TC: O(n log log n)
  // SC: O(n)
  // ------------------------------------------------------------
  public static void sieve(int n) {

        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        System.out.println("Prime numbers up to " + n + " are:");

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
  }

  // ------------------------------------------------------------
  // Sieve + Prefix Prime Count
  // TC: O(n log log n)
  // SC: O(n)
  // ------------------------------------------------------------
  public static int[] sievePrimeCount(int max) {

        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] prefix = new int[max + 1];
        int count = 0;

        for (int i = 0; i <= max; i++) {
            if (isPrime[i]) {
                count++;
            }
            prefix[i] = count;
        }

        return prefix;
  }

  // ------------------------------------------------------------
  // Count primes in range [L, R]
  // TC: O(1)
  // SC: O(1)
  // ------------------------------------------------------------
  public static int countPrimesInRange(int L, int R, int[] prefix) {

        if (L < 0) L = 0;
        if (R < 0) return 0;
        if (R < L) return 0;

        return prefix[R] - (L == 0 ? 0 : prefix[L - 1]);
  }

  // ------------------------------------------------------------
  // Build Smallest Prime Factor (SPF)
  // TC: O(n log log n)
  // SC: O(n)
  // ------------------------------------------------------------
  public static int[] buildSPF(int n) {

        int[] spf = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        return spf;
  }

  // ------------------------------------------------------------
  // Factorization using SPF
  // TC: O(log n)
  // SC: O(log n)
  // ------------------------------------------------------------
  public static List<Integer> getFactors(int x, int[] spf) {

        List<Integer> factors = new ArrayList<>();

        while (x > 1) {
            factors.add(spf[x]);
            x /= spf[x];
        }

        return factors;
  }
}