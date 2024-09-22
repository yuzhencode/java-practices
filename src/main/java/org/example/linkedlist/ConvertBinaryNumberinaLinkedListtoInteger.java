package org.example.linkedlist;


public class ConvertBinaryNumberinaLinkedListtoInteger {
    public int getDecimalValue(ListNode head) {

        int decValue = 0;
        // Traverse the linked list
        while(head != null){
            // Shift the result left and add the current node's value
            decValue = decValue << 1;
            decValue = decValue | head.val;
            head = head.next;
        }
        return decValue;

    }

    public static void main(String[] args) {
        // create ListNode head = [1, 0, 1]
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        // create ListNode head = [1, 1, 0, 1]
        head = new ListNode(1, head);

        ConvertBinaryNumberinaLinkedListtoInteger solution = new ConvertBinaryNumberinaLinkedListtoInteger();
        System.out.println(solution.getDecimalValue(head));
    }

}
