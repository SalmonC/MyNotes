package LeetCode;

/**
 * @author SalmonC
 * @date 2021-07-20 21:44
 */
public class No142 {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode f = new ListNode(3);
        ListNode se = new ListNode(2);
        ListNode th = new ListNode(0);
        ListNode fo = new ListNode(4);
        f.next = se;
        se.next = th;
        th.next = fo;
        fo.next = se;
        ListNode ans = s.detectCycle(f);
        System.out.println(ans);

    }

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val;
        }
    }


    public static class Solution {
        public Solution() {
        }

        public ListNode detectCycle(ListNode head) {
            ListNode l1 = head, l2 = head;
            while (l2 != null && l2.next != null && l2 != l1) {
                l2 = l2.next.next;
                l1 = l1.next;
            }
            if (l2 == null || l2.next == null) return null;
            l1 = head;
            while (l1 != l2) {
                l1 = l1.next;
                l2 = l2.next;
            }
            return l1;
        }
    }
}
