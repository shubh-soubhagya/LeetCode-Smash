/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                // The clone's random is the node immediately after the original's random
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // Move to the next original node
        }

        // STEP 3: SEPARATE THE TWO LISTS
        Node newHead = head.next;
        Node currOld = head;
        Node currNew = newHead;

        while (currOld != null) {
            currOld.next = currOld.next.next; // Restore original list
            if (currNew.next != null) {
                currNew.next = currNew.next.next; // Extract clone list
            }
            currOld = currOld.next;
            currNew = currNew.next;
        }

        return newHead;
    }
}