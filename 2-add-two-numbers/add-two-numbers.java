/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. Create a dummy node to act as the starting anchor
        ListNode dummy = new ListNode(0);
        // 2. 'curr' is our construction worker that moves as we add nodes
        ListNode curr = dummy;
        int carry = 0;

        // 3. Keep looping as long as there are digits to add OR a leftover carry
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Start with the carry from the previous column

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next; // Move to the next digit in list 1
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next; // Move to the next digit in list 2
            }

            carry = sum / 10;            // Calculate new carry (e.g., 13 / 10 = 1)
            curr.next = new ListNode(sum % 10); // Create node for ones digit (e.g., 13 % 10 = 3)
            
            // 4. Move 'curr' forward to the node we just created
            curr = curr.next;
        }

        // Return the node AFTER dummy, which is the actual start of our number
        return dummy.next;
    }
}