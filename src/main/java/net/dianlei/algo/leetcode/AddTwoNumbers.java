package net.dianlei.algo.leetcode;

import net.dianlei.algo.leetcode.domain.ListNode;
import net.dianlei.algo.leetcode.domain.Pair;

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
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//    }
//}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode tmpNode = result;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int total = (l1.val + l2.val + carry);
            int value = total % 10;
            carry = total /10;
            tmpNode.next = new ListNode(value);
            tmpNode = tmpNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // add carry to the longer list if two lists have different length
        while (l1 != null) {
            int total = (l1.val + carry);
            int value = total % 10;
            carry = total / 10;
            tmpNode.next = new ListNode(value);
            tmpNode = tmpNode.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int total = (l2.val + carry);
            int value = total % 10;
            carry = total / 10;
            tmpNode.next = new ListNode(value);
            tmpNode = tmpNode.next;
            l2 = l2.next;
        }

        // it's possible that there is carry after we finish both lists.
        //  for example: [9,9,9,9,9,9,9]  + [9,9,9,9]
        if(carry > 0) {
            tmpNode.next = new ListNode(carry);
        }
        // remove empty head node
        return result.next;
    }

//    private Pair<Integer, Integer> addWithCarry(int num1, int num2, int num3) {
//        int value = (num1 + num2 + num3) % 10;
//        int carry = (num1 + num2 + num3) / 10;
//        Pair<Integer, Integer> pair = new Pair<>(value, carry);
//        return pair;
//    }

//        private int addWithCarry(int num1, int num2, int num3) {
//        int value = (num1 + num2 + num3) % 10;
//        int carry = (num1 + num2 + num3) / 10;
//        Pair<Integer, Integer> pair = new Pair<>(value, carry);
//        return pair;
//    }

}
