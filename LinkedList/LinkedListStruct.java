package LinkedList;

/*
 ============================================================
                    COMPLETE LINKED LIST GUIDE
 ============================================================

 Author  : Aman Oza
 Purpose : DSA + Interview Preparation

 ------------------------------------------------------------
 WHAT THIS FILE TEACHES:
 ------------------------------------------------------------

 1) How to create a Node (Global Template)
 2) Convert Array → Linked List
 3) Length of Linked List
 4) Searching in Linked List
 5) Traversal (Printing)
 6) Deleting:
        - Head
        - Tail (2 approaches)
        - Node at Index
        - Node by Value
 7) Inserting:
        - At Head
        - At Last
        - At Index
        - Before Given Value
 8) Time Complexity & Space Complexity analysis

 ============================================================
*/


public class LinkedListStruct {

    public static void main(String[] args) {

        /*
         ------------------------------------------------------------
         Example 1: Manual Node Creation
         ------------------------------------------------------------

         x → 3 → null
         y → 2 → 3 → null
        */

        Node x = new Node(3);
        Node y = new Node(2, x);


        /*
         ------------------------------------------------------------
         Example 2: Creating Linked List from Array
         ------------------------------------------------------------

         Array:
         {1,5,3,4,7,2,3,9,2,3,2,3,4}

         Linked List:
         1 → 5 → 3 → 4 → 7 → 2 → ...
        */

        int[] arr = {1, 5, 3, 4, 7, 2,3, 9 , 2,3 ,2 ,3, 4};

        Node head = makeLinkedList(arr);


        /*
         ------------------------------------------------------------
         BASIC OPERATIONS
         ------------------------------------------------------------
        */

        System.out.println("Length of Linked List: " + lengthOfLL(head));

        System.out.println("Search 2: " + searchInLinkedList(head, 2));
        System.out.println("Search 3: " + searchInLinkedList(head, 3));
        System.out.println("Search 8: " + searchInLinkedList(head, 8));


        /*
         ------------------------------------------------------------
         DELETION OPERATIONS
         ------------------------------------------------------------
        */
       printLinkedList(head);

       Node deletedHead = deleteHead(head);
       printLinkedList(deletedHead);

       Node deletedTail = deleteTail(deletedHead);
       printLinkedList(deletedTail);

       Node deletedTail2 = deleteTail2(deletedTail);
       printLinkedList(deletedTail2);

       Node deletedNode2 = deleteNodeK(deletedTail2,1);
       printLinkedList(deletedNode2);

       Node deletedTail4 = deleteNodeK(deletedNode2,10);
       printLinkedList(deletedTail4);

       Node deletedTail5 = deleteNodeK(deletedTail4,6);
       printLinkedList(deletedTail5);

       Node deletedTail6 = deleteNodeK(deletedTail5,3);
       printLinkedList(deletedTail6);

       Node deletedTail7 = deleteNodeK(deletedTail6,2);
       printLinkedList(deletedTail7);

       Node deletedTail8 = deleteNodeK(deletedTail7,5);
       printLinkedList(deletedTail8);

       Node deletedValue3 = deleteNodeValue(deletedTail8, 3);
       printLinkedList(deletedValue3);

       Node deletedValue7 = deleteNodeValue(deletedTail8, 7);
       printLinkedList(deletedValue7);


       /*
         ------------------------------------------------------------
         INSERTION OPERATIONS
         ------------------------------------------------------------
        */

       Node insertionAtHead1 = insertionAtHead(deletedValue7, 10);
       printLinkedList(insertionAtHead1);

       Node insertionAtHead2 = insertionAtLast(insertionAtHead1, 12);
       printLinkedList(insertionAtHead2);

       Node insertionAt2 = insertionAtIndex(insertionAtHead1, 13,1);
       printLinkedList(insertionAt2);

       Node insertionAt5 = insertionAtIndex(insertionAt2,21,2);
       printLinkedList(insertionAt5);

       Node insertionBefore21 = insertionAtXBeforeValue(insertionAt2,21,23);
       printLinkedList(insertionBefore21);

       Node insertionBefore22 = insertionAtXBeforeValue(insertionBefore21,1,24);
       printLinkedList(insertionBefore22);
    }


    /*
     ============================================================
                ARRAY → LINKED LIST CONVERSION
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(n)

     Explanation:
     - First element becomes head.
     - Attach new nodes at the end.
    */

    public static Node makeLinkedList(int[] arr) {

        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            prev.next = newNode;
            prev = newNode;
        }

        return head;
    }


    /*
     ============================================================
                    LENGTH OF LINKED LIST
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static int lengthOfLL(Node head) {

        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }


    /*
     ============================================================
                    SEARCH IN LINKED LIST
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static boolean searchInLinkedList(Node head, int val) {

        while (head != null) {
            if (head.data == val) {
                return true;
            }
            head = head.next;
        }

        return false;
    }


    /*
     ============================================================
                    PRINT LINKED LIST
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static void printLinkedList(Node head) {

        while (head != null) {
            System.out.print(head.data + " → ");
            head = head.next;
        }

        System.out.println("null");
    }


    /*
     ============================================================
                    DELETE HEAD
     ============================================================

     Time Complexity  : O(1)
     Space Complexity : O(1)
    */

    public static Node deleteHead(Node head){
      if(head==null) return null;
      Node temp = head;
      head = head.next;
      temp.next = null;
      return head;
    }


    /*
     ============================================================
                    DELETE TAIL (Approach 1)
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static Node deleteTail(Node head){
      if(head==null || head.next==null) return null;
      Node curr = head;
      Node prev = null;
      while(curr.next!=null){
        prev=curr;
        curr=curr.next;
      }
      prev.next=null;
      return head;
    }


    /*
     ============================================================
                    DELETE TAIL (Optimized Traversal)
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static Node deleteTail2(Node head){
      if(head==null || head.next==null) return null;
      Node curr = head;
      while(curr.next.next!=null){
        curr=curr.next;
      }
      curr.next=null;
      return head;
    }


    /*
     ============================================================
                    DELETE NODE AT INDEX (1-based)
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static Node deleteNodeK(Node head,int index){
      if(head==null) return null;
      if (index == 1) {
        head = head.next;
        return head;
      }

      Node curr = head;
      Node prev = null;
      int i = 1;

      while(curr.next!=null && i<index){
        prev = curr;
        curr=curr.next;
        i++;
      }

      if(index>=i+1){
        return head;
      }

      prev.next=curr.next;
      curr.next=null;
      return head;
    }


    /*
     ============================================================
                    DELETE NODE BY VALUE (First Occurrence)
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static Node deleteNodeValue(Node head,int value){
      if(head==null) return null;

      if (head.data == value) {
        head = head.next;
        return head;
      }

      Node curr = head;
      Node prev = null;

      while(curr.next!=null){
        prev=curr;
        curr=curr.next;
        if(curr.data==value){
            break;
        }
      }

      if(curr.next==null && curr.data!=value){
        return head;
      }

      prev.next=curr.next;
      curr.next=null;
      return head;
    }


    /*
     ============================================================
                    INSERT AT HEAD
     ============================================================

     Time Complexity  : O(1)
     Space Complexity : O(1)
    */

    public static Node insertionAtHead(Node head,int value){

        // Node newHead = new Node(value);
        // if(head==null) return newHead;
        // newHead.next=head;
        // head = newHead;
        // return head;
        return new Node(value,head);
    }


    /*
     ============================================================
                    INSERT AT LAST
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static Node insertionAtLast(Node head,int value){
        Node newHead = new Node(value);
        if(head==null) return newHead;

        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newHead;
        return head;
    }


    /*
     ============================================================
                    INSERT AT INDEX (1-based)
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static Node insertionAtIndex(Node head,int value,int index){

        if (index <= 0) return head;

        Node newHead = new Node(value);

        if(head==null && index==1) return newHead;
        if(head==null && index!=1) return null;

        if(index==1){
            newHead.next = head;
            head = newHead;
            return head;
        }

        Node curr = head;
        int i=1;

        while(curr.next!=null && i<index-1){
            curr = curr.next;
            i++;
        }

        if(index!=i+1){
            return head;
        }

        newHead.next = curr.next;
        curr.next = newHead;
        return head;
    }


    /*
     ============================================================
            INSERT BEFORE A GIVEN VALUE (First Occurrence)
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static Node insertionAtXBeforeValue(Node head,int value,int newValue){

        Node newHead = new Node(newValue);
        if(head==null) return null;

        if(head.data == value){
            newHead.next = head;
            head = newHead;
            return head;
        }

        Node curr = head;

        while(curr.next!=null){
            if(curr.next.data==value){
                break;
            }
            curr = curr.next;
        }

        if(curr.next==null){
            return head;
        }

        newHead.next = curr.next;
        curr.next = newHead;
        return head;
    }
}


/*
 ============================================================
                GLOBAL NODE TEMPLATE
 ============================================================

 This is the standard structure used in interviews.
*/

class Node {

    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}