package LinkedList;

/*
 1) How to create a Doubly Linked List Node
 2) Convert Array → Doubly Linked List
 3) Traversal (Printing)
 4) Deleting:
        - Head
        - Tail
        - Node at Index
        - Node by Value
 5) Inserting:
        - At Head
        - At Last
        - At Index
        - Before Given Value
 6) Pointer management (next & back)
 7) Time Complexity & Space Complexity analysis

 ============================================================
*/

public class DoubleLinkedList {

    public static void main(String[] args) {

        /*
         ------------------------------------------------------------
         Example: Creating Doubly Linked List from Array
         ------------------------------------------------------------

         Array:
         {1,5,3,4,7,2,3,9,11,4,12,21}

         Doubly Linked List:
         null ← 1 ⇄ 5 ⇄ 3 ⇄ 4 ⇄ 7 ⇄ 2 ...
        */

        int[] arr = {1, 5, 3, 4, 7, 2, 3, 9, 11, 4, 12, 21};

        DLLNode head = makeDoublyLinkedList(arr);
        printDoublyLinkedList(head);


        /*
         ------------------------------------------------------------
         DELETION OPERATIONS
         ------------------------------------------------------------
        */

        DLLNode deletedDLLHead = deleteDLLHead(head);
        printDoublyLinkedList(deletedDLLHead);

        DLLNode deletedDLLHead2 = deleteDLLHead(deletedDLLHead);
        printDoublyLinkedList(deletedDLLHead2);

        DLLNode deletedDLLTail = deleteDLLTail(deletedDLLHead2);
        printDoublyLinkedList(deletedDLLTail);

        DLLNode deletedDLLTail2 = deleteDLLTail(deletedDLLTail);
        printDoublyLinkedList(deletedDLLTail2);

        DLLNode deletedDLLNode2 = deleteDLLNodeK(deletedDLLTail2,2);
        printDoublyLinkedList(deletedDLLNode2);

        DLLNode deletedDLLNode3 = deleteDLLNodeK(deletedDLLNode2,1);
        printDoublyLinkedList(deletedDLLNode3);

        DLLNode deletedDLLValue2 = deleteDLLNodeValue(deletedDLLNode3,2);
        printDoublyLinkedList(deletedDLLValue2);

        DLLNode deletedDLLValue3 = deleteDLLNodeValue(deletedDLLValue2,7);
        printDoublyLinkedList(deletedDLLValue3);

        DLLNode deletedDLLValue4 = deleteDLLNodeValue(deletedDLLValue3,1);
        printDoublyLinkedList(deletedDLLValue4);


        /*
         ------------------------------------------------------------
         INSERTION OPERATIONS
         ------------------------------------------------------------
        */

        DLLNode insertionAtHead1 = insertionDLLAtHead(deletedDLLValue4, 10);
        printDoublyLinkedList(insertionAtHead1);

        DLLNode insertionAtHead2 = insertionDLLAtLast(insertionAtHead1, 12);
        printDoublyLinkedList(insertionAtHead2);

        DLLNode insertionAt2 = insertionDLLAtIndex(insertionAtHead1, 13,1);
        printDoublyLinkedList(insertionAt2);

        DLLNode insertionAt5 = insertionDLLAtIndex(insertionAt2,21,8);
        printDoublyLinkedList(insertionAt5);

        DLLNode insertionBefore21 = insertionDLLAtXBeforeValue(insertionAt2,21,23);
        printDoublyLinkedList(insertionBefore21);

        DLLNode insertionBefore22 = insertionDLLAtXBeforeValue(insertionBefore21,3,24);
        printDoublyLinkedList(insertionBefore22);

    }


    /*
     ============================================================
            ARRAY → DOUBLY LINKED LIST CONVERSION
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(n)

     Explanation:
     - First element becomes head
     - Each new node is attached to the previous node
     - Both next and back pointers are maintained
    */

    public static DLLNode makeDoublyLinkedList(int[] arr) {

        if (arr.length == 0) return null;

        DLLNode head = new DLLNode(arr[0]);
        DLLNode prev = head;

        for (int i = 1; i < arr.length; i++) {

            DLLNode newNode = new DLLNode(arr[i]);

            newNode.back = prev;
            prev.next = newNode;

            prev = newNode;
        }

        return head;
    }


    /*
     ============================================================
                    PRINT DOUBLY LINKED LIST
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static void printDoublyLinkedList(DLLNode head) {

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

    public static DLLNode deleteDLLHead(DLLNode head){

        if(head==null || head.next==null) return null;

        DLLNode temp = head;

        head = head.next;
        head.back = null;

        temp.next = null;

        return head;
    }


    /*
     ============================================================
                    DELETE TAIL
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static DLLNode deleteDLLTail(DLLNode head){

        if(head==null || head.next==null) return null;

        DLLNode curr = head;
        DLLNode prev = null;

        while(curr.next!=null){
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
        curr.back = null;

        return head;
    }


    /*
     ============================================================
                    DELETE NODE AT INDEX (1-based)
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static DLLNode deleteDLLNodeK(DLLNode head,int index){

        if(head==null) return null;

        if(index==1){
            head = head.next;
            if(head!=null) head.back = null;
            return head;
        }

        DLLNode curr = head;
        DLLNode prev = null;

        int i = 1;

        while(curr.next!=null && i<index){
            prev = curr;
            curr = curr.next;
            i++;
        }

        if(index>=i+1) return head;

        if(curr.next!=null) curr.next.back = prev;

        prev.next = curr.next;

        curr.next = null;
        curr.back = null;

        return head;
    }


    /*
     ============================================================
                DELETE NODE BY VALUE (First Occurrence)
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static DLLNode deleteDLLNodeValue(DLLNode head,int value){

        if(head==null) return null;

        if(head.data == value){
            head = head.next;
            if(head!=null) head.back = null;
            return head;
        }

        DLLNode curr = head;
        DLLNode prev = null;

        while(curr.next!=null){
            prev = curr;
            curr = curr.next;

            if(curr.data == value){
                break;
            }
        }

        if(curr.next==null && curr.data!=value) return head;

        if(curr.next!=null) curr.next.back = prev;

        prev.next = curr.next;

        curr.next = null;
        curr.back = null;

        return head;
    }


    /*
     ============================================================
                    INSERT AT HEAD
     ============================================================

     Time Complexity  : O(1)
     Space Complexity : O(1)
    */

    public static DLLNode insertionDLLAtHead(DLLNode head,int value){

        DLLNode newHead = new DLLNode(value);

        if(head==null) return newHead;

        newHead.next = head;
        head.back = newHead;

        return newHead;
    }


    /*
     ============================================================
                    INSERT AT LAST
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static DLLNode insertionDLLAtLast(DLLNode head,int value){

        DLLNode newTail = new DLLNode(value);

        if(head==null) return newTail;

        DLLNode temp = head;

        while(temp.next!=null){
            temp = temp.next;
        }

        temp.next = newTail;
        newTail.back = temp;

        return head;
    }


    /*
     ============================================================
                    INSERT AT INDEX (1-based)
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static DLLNode insertionDLLAtIndex(DLLNode head,int value,int index){

        if(index<=0) return head;

        DLLNode newNode = new DLLNode(value);

        if(head==null && index==1) return newNode;
        if(head==null && index!=1) return null;

        if(index==1){
            newNode.next = head;
            head.back = newNode;
            return newNode;
        }

        DLLNode curr = head;

        int i=1;

        while(curr.next!=null && i<index-1){
            curr = curr.next;
            i++;
        }

        if(index!=i+1) return head;

        newNode.next = curr.next;
        newNode.back = curr;

        if(curr.next!=null) curr.next.back = newNode;

        curr.next = newNode;

        return head;
    }


    /*
     ============================================================
            INSERT BEFORE A GIVEN VALUE (First Occurrence)
     ============================================================

     Time Complexity  : O(n)
     Space Complexity : O(1)
    */

    public static DLLNode insertionDLLAtXBeforeValue(DLLNode head,int value,int newValue){

        DLLNode newNode = new DLLNode(newValue);

        if(head==null) return null;

        if(head.data == value){
            newNode.next = head;
            head.back = newNode;
            return newNode;
        }

        DLLNode curr = head;

        while(curr.next!=null){
            if(curr.next.data == value){
                break;
            }
            curr = curr.next;
        }

        if(curr.next==null) return head;

        newNode.next = curr.next;
        newNode.back = curr;

        curr.next.back = newNode;

        curr.next = newNode;

        return head;
    }

}


/*
 ============================================================
                GLOBAL DLL NODE TEMPLATE
 ============================================================

 Standard Doubly Linked List Node structure used in interviews
*/

class DLLNode {

    int data;
    DLLNode next;
    DLLNode back;

    DLLNode(int data, DLLNode next, DLLNode back){
        this.data = data;
        this.next = next;
        this.back = back;
    }

    DLLNode(int data){
        this.data = data;
        this.next = null;
        this.back = null;
    }
}