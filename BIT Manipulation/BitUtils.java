import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BitUtils {

    // Swap two numbers using XOR (no 3rd variable)
    public static void swapXOR() {
        int A = 5;
        int B = 6;
        System.out.println("Before swap: A=" + A + " B=" + B);
        A = A ^ B;
        B = A ^ B;
        A = A ^ B;
        System.out.println("After swap: A=" + A + " B=" + B);
    }

    // Check if a bit is set at index i (0-based)
    public static boolean isBitSet(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    // Set a bit at index i
    public static int setBit(int n, int i) {
        return n | (1 << i);
    }

    // Clear a bit at index i
    public static int clearBit(int n, int i) {
        int mask = ~(1 << i);
        return n & mask;
    }

    // Toggle bit at index i
    public static int toggleBit(int n, int i) {
        return n ^ (1 << i);
    }

    // Remove rightmost set bit
    public static int removeLastSetBit(int n) {
        return n & (n - 1);
    }

    // Check if number is power of two
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    // Count set bits (Brian Kernighan’s algorithm)
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    // Check odd/even with bitwise
    public static boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    // Right shift (divide by 2)
    public static int rightShiftDivide(int n) {
        return n >> 1;
    }
    
    // TC O(Log2n) sqaure and SC O(1)
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long ans = 0;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        long n = Math.abs((long) dividend);
        long m = Math.abs((long) divisor);

        while (n >= m) {
            long temp = m;
            long multiple = 1;

            while (n >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            n -= temp;
            ans += multiple;
        }

        return (int) (sign * ans);
    }

    // TC = O(1)
    // SC = O(1)
    public static int xor1ToN(int n) {
        switch (n % 4) {
            case 0: return n;
            case 1: return 1;
            case 2: return n + 1;
            default: return 0;
        }
    }

    // TC = O(1)
    // SC = O(1)
    public static int xorLToR(int L, int R) {
        if (L == 0) return xor1ToN(R);
        return xor1ToN(R) ^ xor1ToN(L - 1);
    }
    
    // TC = O(n), SC = O(1)
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    // TC = O(n), SC = O(1)
    public static int singleNumberII(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }

    // TC = O(n), SC = O(1)
    public static int[] singleNumberIII(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;

        int diffBit = xor & (-xor); // lowest set bit

        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & diffBit) == 0) x ^= num;
            else y ^= num;
        }
        return new int[]{x, y};
    }

    // TC = O(n)
    // SC = O(n)
    public static int firstNonRepeating(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (map.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }

    /**
     * Generates all subsets (power set) using bit masks
     * TC = O(2^n * n) // 2^n subsets & building each subset takes O(n)
     * SC = O(2^n * n) // store all subsets
     */
    public static List<List<Integer>> powerSet(int[] nums) {
        int n = nums.length;
        int totalMasks = 1 << n;  // 2^n

        List<List<Integer>> allSubsets = new ArrayList<>();

        for (int mask = 0; mask < totalMasks; mask++) {
            List<Integer> subset = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            allSubsets.add(subset);
        }

        return allSubsets;
    }

    /**
     * Count minimum flip operations to convert a into b
     * TC = O(1) (actually O(log n) bitwise)
     * SC = O(1)
     */
    public static int minBitFlips(int a, int b) {
        int xor = a ^ b;        // marks bits that differ
        int count = 0;
        
        while (xor != 0) {
            xor &= (xor - 1);   // remove lowest set bit
            count++;
        }
        
        return count;
    }

}