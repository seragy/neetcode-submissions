class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = slow.next;
        slow.next = null; // Break the list into two halves
        ListNode prev = null;
        while (secondHalf != null) {
            ListNode tmp = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = tmp;
        }

        // Step 3: Merge the two halves
        ListNode firstHalf = head;
        secondHalf = prev;
        while (secondHalf != null) {
            ListNode tmp1 = firstHalf.next;
            ListNode tmp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = tmp1;

            firstHalf = tmp1;
            secondHalf = tmp2;
        }
    }
}
