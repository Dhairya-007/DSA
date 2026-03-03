package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 ============================================================
                        BASIC HASHING
 ============================================================

 This file demonstrates:

 1) Frequency counting using ARRAY hashing
    - Works when range is known and small
    - Very fast (O(1) access)

 2) Character frequency using ARRAY hashing
    - Used for lowercase alphabets (a-z)

 3) Frequency counting using HashMap
    - Works for large or unknown ranges
    - Handles negative numbers
    - Used in most interview problems

 Time Complexity:
    - Building frequency: O(n)
    - Query: O(1)

 Space Complexity:
    - Array hashing: O(k) (k = range)
    - HashMap: O(n)

 ============================================================
*/

public class BasicHashing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ---------------- INTEGER ARRAY HASHING ----------------
        integerArrayHashing(sc);

        // ---------------- CHARACTER HASHING ----------------
        characterHashing(sc);

        // ---------------- HASHMAP HASHING ----------------
        hashMapHashing(sc);

        // Character HASHING
        hashMapHashingString(sc);

        // Highest and lowest freq elements
        highestLowestFrequency(sc);

        sc.close();
    }

    /* ============================================================
                       INTEGER ARRAY HASHING
       ============================================================ */
    public static void integerArrayHashing(Scanner sc) {

        System.out.println("\nEnter Array Length :- ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Assuming numbers are between 0 and 12
        int[] freq = new int[13];

        System.out.println("Type Numbers according to length:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            freq[arr[i]]++;  // Direct indexing
        }

        System.out.println("\nFrequency using Array Hashing:");
        for (int i = 0; i < freq.length; i++) {
            System.out.println(i + " -> " + freq[i]);
        }
    }

    /* ============================================================
                       CHARACTER HASHING
       ============================================================ */
    public static void characterHashing(Scanner sc) {

        sc.nextLine(); // consume leftover newline

        System.out.println("\nEnter String :- ");
        String s = sc.nextLine();

        int[] freqChar = new int[26];

        for (int i = 0; i < s.length(); i++) {

            char ch = Character.toLowerCase(s.charAt(i));

            if (ch >= 'a' && ch <= 'z') {
                freqChar[ch - 'a']++;
            }
        }

        System.out.println("\nCharacter Frequency:");
        for (int i = 0; i < 26; i++) {
            System.out.println((char) (i + 'a') + " -> " + freqChar[i]);
        }
    }

    /* ============================================================
                         HASHMAP HASHING
       ============================================================ */
    public static void hashMapHashing(Scanner sc) {

        System.out.println("\nEnter Array Length for HashMap :- ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();

        System.out.println("Enter numbers:");

        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();

            // getOrDefault(key, defaultValue)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println("\nFrequency using HashMap:");

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }

    public static void hashMapHashingString(Scanner sc) {
        sc.nextLine(); // consume leftover newline
        System.out.println("\nEnter String for HashMap :- ");
        System.out.println("\nEnter String :- ");
        String s = sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = Character.toLowerCase(s.charAt(i));

            if (ch >= 'a' && ch <= 'z') {
                map.put(ch,map.getOrDefault(ch, 0)+1);
            }
        }
        System.out.println("\nFrequency using HashMap:");
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

    /* ============================================================
        FIND HIGHEST & LOWEST FREQUENCY ELEMENT
   ============================================================ */
    public static void highestLowestFrequency(Scanner sc) {

        System.out.println("\nEnter Array Length :- ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        System.out.println("Enter Numbers:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;

        int maxElement = -1;
        int minElement = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int element = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFreq) {
                maxFreq = frequency;
                maxElement = element;
            }

            if (frequency < minFreq) {
                minFreq = frequency;
                minElement = element;
            }
        }

        System.out.println("\nHighest Frequency Element:");
        System.out.println(maxElement + " -> " + maxFreq);

        System.out.println("\nLowest Frequency Element:");
        System.out.println(minElement + " -> " + minFreq);
    }
}