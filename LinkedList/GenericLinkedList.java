package LinkedList;

/*
 ============================================================
            GENERIC LINKED LIST (GenericNode<T>)
 ============================================================

 What you will learn:

 1) What is Generics?
 2) How to create GenericNode<T>
 3) How to create Linked List of:
        - Integer
        - String
        - Custom Object
 4) Why generics are powerful

 ============================================================
*/

public class GenericLinkedList {

    public static void main(String[] args) {

        /*
         ------------------------------------------------------------
         Example 1: Integer Linked List
         ------------------------------------------------------------
        */

        GenericNode<Integer> intHead = new GenericNode<>(10);
        intHead.next = new GenericNode<>(20);
        intHead.next.next = new GenericNode<>(30);

        printList(intHead);


        /*
         ------------------------------------------------------------
         Example 2: String Linked List
         ------------------------------------------------------------
        */

        GenericNode<String> strHead = new GenericNode<>("Dhairya");
        strHead.next = new GenericNode<>("Oza");
        strHead.next.next = new GenericNode<>("Java");

        printList(strHead);


        /*
         ------------------------------------------------------------
         Example 3: Using Array → Linked List
         ------------------------------------------------------------
        */

        Integer[] arr = {1, 2, 3, 4, 5};

        GenericNode<Integer> headFromArray = makeLinkedList(arr);
        printList(headFromArray);
    }


    /*
     ============================================================
            Generic Method → Array to Linked List
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(n)
    */

    public static <T> GenericNode<T> makeLinkedList(T[] arr) {

        if (arr.length == 0) return null;

        GenericNode<T> head = new GenericNode<>(arr[0]);
        GenericNode<T> prev = head;

        for (int i = 1; i < arr.length; i++) {
            GenericNode<T> newGenericNode = new GenericNode<>(arr[i]);
            prev.next = newGenericNode;
            prev = newGenericNode;
        }

        return head;
    }


    /*
     ============================================================
                    Generic Print Method
     ============================================================
    */

    public static <T> void printList(GenericNode<T> head) {

        while (head != null) {
            System.out.print(head.data + " → ");
            head = head.next;
        }

        System.out.println("null");
    }
}


/*
 ============================================================
                GLOBAL GENERIC GenericNode TEMPLATE
 ============================================================

 T = Type Parameter
 Can be:
    Integer
    String
    Double
    Student
    Anything!

 This is industry-level structure.
*/

class GenericNode<T> {

    T data;          // Generic Data
    GenericNode<T> next;    // Next pointer of same type

    GenericNode(T data) {
        this.data = data;
        this.next = null;
    }

    GenericNode(T data, GenericNode<T> next) {
        this.data = data;
        this.next = next;
    }
}