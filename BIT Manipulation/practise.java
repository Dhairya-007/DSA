public class practise {
  public static void main(String[] args) {
    System.out.println(ConvertToDecimal(ConvertToBinary(2)));
    System.out.println(ConvertToDecimal(ConvertToBinary(5)));
    System.out.println(ConvertToDecimal(ConvertToBinary(11)));
    System.out.println(ConvertToDecimal(ConvertToBinary(23)));

    System.out.println(ConvertToBinary(2));
    System.out.println(ConvertToBinary(5));
    System.out.println(ConvertToBinary(11));
    System.out.println(ConvertToBinary(32));

    System.out.println("\n--- Bit Manipulation Tests ---");

    BitUtils.swapXOR();

    int n = 13;
    System.out.println("Is bit 2 set in " + n + "? - " + BitUtils.isBitSet(n, 2));
    System.out.println("Set bit 1 in " + n + ": " + BitUtils.setBit(n, 1));
    System.out.println("Clear bit 0 in " + n + ": " + BitUtils.clearBit(n, 0));
    System.out.println("Toggle bit 3 in " + n + ": " + BitUtils.toggleBit(n, 3));

    System.out.println("Remove last set bit from " + n + ": " + BitUtils.removeLastSetBit(n));
    System.out.println(n + " is power of two? " + BitUtils.isPowerOfTwo(n));
    System.out.println("Count set bits in " + n + ": " + BitUtils.countSetBits(n));
    System.out.println(n + " is odd? " + BitUtils.isOdd(n));
    System.out.println(n + " right shifted by 1: " + BitUtils.rightShiftDivide(n));

  }

  // Method - 1 Convert to Binary

  public static String ConvertToBinary(int x){

    if(x == 0) return "0";

    String res = "";
    // while(x!=0){
    //   int rem = x%2;
    //   res = res + rem;
    //   x /= 2;
    // }
    // return reverseString(res);

    while(x!=0){
      int rem = x%2;
      res = rem + res;
      x /= 2;
    }
    return res;
  }

  public static int ConvertToDecimal(String x){

    int n = x.length();
    int answer = 0;
    int i = n-1;
    int p = 1;
    while(i>-1){
      int digit = (int)x.charAt(i)-'0';
      answer = answer + p*digit;
      p *= 2;
      i--;
    }

    return answer;
  }

  public static String reverseString(String x){

    char[] arr = x.toCharArray();

    int n = x.length();
    int i = 0;
    while(i<n/2){
      char temp = arr[i];
      arr[i] = arr[n-1-i];
      arr[n-1-i]=temp;
      i++;
    }

    return new String(arr);
  }
}