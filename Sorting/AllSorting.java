package Sorting;

/*
 ============================================================
                    ALL SORTING ALGORITHMS
 ============================================================

 1) Selection Sort
    - Picks minimum element and places at correct position
    - Time Complexity:
        Best   : O(n^2)
        Average: O(n^2)
        Worst  : O(n^2)
    - Space Complexity: O(1)
    - Stable: ❌ No

 2) Bubble Sort
    - Adjacent comparison, largest element bubbles to end
    - Time Complexity:
        Best   : O(n)  (with optimization)
        Average: O(n^2)
        Worst  : O(n^2)
    - Space Complexity: O(1)
    - Stable: ✅ Yes

 3) Insertion Sort
    - Inserts element at correct position in sorted part
    - Time Complexity:
        Best   : O(n)
        Average: O(n^2)
        Worst  : O(n^2)
    - Space Complexity: O(1)
    - Stable: ✅ Yes

 4) Merge Sort
    - Divide and Conquer
    - Time Complexity:
        Best   : O(n log n)
        Average: O(n log n)
        Worst  : O(n log n)
    - Space Complexity: O(n)
    - Stable: ✅ Yes

 5) Quick Sort
    - Divide and Conquer (Partition based)
    - Time Complexity:
        Best   : O(n log n)
        Average: O(n log n)
        Worst  : O(n^2)
    - Space Complexity: O(log n)
    - Stable: ❌ No
*/

public class AllSorting {

  public static void main(String[] args) {

    int[] original = new int[]{1,-2,4,3,0,6,5};

    System.out.println("Original Array:");
    printArray(original);

    // ---------------- Selection Sort ----------------
    int[] selectionArr = original.clone();
    SelectionSort(selectionArr);
    System.out.println("\nAfter Selection Sort:");
    printArray(selectionArr);

    // ---------------- Bubble Sort ----------------
    int[] bubbleArr = original.clone();
    BubbleSort(bubbleArr);
    System.out.println("\nAfter Bubble Sort:");
    printArray(bubbleArr);

    // ---------------- Recursive Bubble Sort ----------------
    int[] recBubbleArr = original.clone();
    RecursiveBubbleSort(recBubbleArr, recBubbleArr.length);
    System.out.println("\nAfter Recursive Bubble Sort:");
    printArray(recBubbleArr);

    // ---------------- Insertion Sort ----------------
    int[] insertionArr = original.clone();
    InsertionSort(insertionArr);
    System.out.println("\nAfter Insertion Sort:");
    printArray(insertionArr);

    // ---------------- Recursive Insertion Sort ----------------
    int[] recInsertionArr = original.clone();
    RecursiveInsertionSort(recInsertionArr, recInsertionArr.length);
    System.out.println("\nAfter Recursive Insertion Sort:");
    printArray(recInsertionArr);

    // ---------------- Merge Sort ----------------
    int[] mergeArr = original.clone();
    MergeSort(mergeArr, 0, mergeArr.length - 1);
    System.out.println("\nAfter Merge Sort:");
    printArray(mergeArr);

    // ---------------- Quick Sort ----------------
    int[] quickArr = original.clone();
    QuickSort(quickArr, 0, quickArr.length - 1);
    System.out.println("\nAfter Quick Sort:");
    printArray(quickArr);
}

public static void printArray(int[] arr){
    for(int num : arr){
        System.out.print(num + " ");
    }
    System.out.println();
}

  /* ============================================================
                       SELECTION SORT
     ============================================================ */
  public static void SelectionSort(int [] arr){

    // Traverse array
    for(int i=0;i<arr.length-1;i++){

      // Assume current index is minimum
      int index = i;

      // Find actual minimum in remaining array
      for(int j=i+1;j<=arr.length-1;j++){
        if(arr[j]<arr[index]){
          index = j;
        }
      }

      // Swap if new minimum found
      if(index!=i){
        int temp = arr[i];
        arr[i]=arr[index];
        arr[index]=temp;
      }
    }
  }

  /* ============================================================
                         BUBBLE SORT
     ============================================================ */
  public static void BubbleSort(int [] arr){

    int n = arr.length;

    // Each pass places largest element at correct position
    for(int i=0;i<n-1;i++){

      boolean swapped = false;

      for(int j=0;j<n-i-1;j++){
        if(arr[j]>arr[j+1]){
          int temp = arr[j];
          arr[j]=arr[j+1];
          arr[j+1]=temp;
          swapped = true;
        }
      }

      // If no swapping happened, array is already sorted
      if(!swapped) break;
    }
  }

  /* ============================================================
                   RECURSIVE BUBBLE SORT
     ============================================================ */
  public static void RecursiveBubbleSort(int[] arr, int n){

    // Base condition
    if(n == 1) return;

    // One full pass
    for(int i=0;i<n-1;i++){
      if(arr[i] > arr[i+1]){
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
      }
    }

    // Recur for remaining array
    RecursiveBubbleSort(arr, n-1);
  }

  /* ============================================================
                      INSERTION SORT
     ============================================================ */
  public static void InsertionSort(int [] arr){

    int n = arr.length;

    for(int i=1;i<=n-1;i++){

      int j=i;

      // Shift element left until correct position found
      while(j>0 && arr[j-1]>arr[j]){
        int temp = arr[j];
        arr[j] = arr[j-1];
        arr[j-1] = temp;
        j--;
      }
    }
  }

  /* ============================================================
                 RECURSIVE INSERTION SORT
     ============================================================ */
  public static void RecursiveInsertionSort(int[] arr, int n){

    if(n <= 1) return;

    // Sort first n-1 elements
    RecursiveInsertionSort(arr, n-1);

    // Insert last element at correct position
    int last = arr[n-1];
    int j = n-2;

    while(j >= 0 && arr[j] > last){
      arr[j+1] = arr[j];
      j--;
    }

    arr[j+1] = last;
  }

  /* ============================================================
                         MERGE SORT
     ============================================================ */
  public static void MergeSort(int [] arr,int left,int right){

    if(left==right){
      return;
    }

    int mid = left + (right-left)/2;

    MergeSort(arr,left,mid);
    MergeSort(arr,mid+1,right);

    Merge(arr,left,mid,right);
  }

  public static void Merge(int[]arr,int left,int mid,int right){

    int l = left;
    int r = mid+1;

    int [] tempArr = new int[right-left+1];
    int index=0;

    // Merge two sorted halves
    while(l<=mid && r<=right){
      if(arr[l]<=arr[r]){
        tempArr[index++]=arr[l++];
      } else {
        tempArr[index++]=arr[r++];
      }
    }

    // Remaining elements
    while(l<=mid){
      tempArr[index++]=arr[l++];
    }

    while(r<=right){
      tempArr[index++]=arr[r++];
    }

    // Copy back to original array
    for(int i=0;i<tempArr.length;i++){
      arr[left+i] = tempArr[i];
    }
  }

  /* ============================================================
                         QUICK SORT
     ============================================================ */
  public static void QuickSort(int [] arr,int low,int high){

    if(low<high){

      int partition = findPivot(arr,low,high);

      QuickSort(arr, low, partition-1);
      QuickSort(arr, partition+1, high);
    }
  }

  public static int findPivot(int[]arr,int low,int high){

    int pivot = arr[low];
    int l = low;
    int h = high;

    while(l<h){

      while(arr[l]<=pivot && l<high){
        l++;
      }

      while(arr[h]>pivot && h>low){
        h--;
      }

      if(l<h){
        int temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
      }
    }

    int temp = arr[low];
    arr[low] = arr[h];
    arr[h] = temp;

    return h;   // corrected return for proper partition
  }
}