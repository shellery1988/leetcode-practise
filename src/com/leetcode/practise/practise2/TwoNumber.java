package com.leetcode.practise.practise2;

/**
 * Author:   liuss
 * Date:     2020/1/14 20:06
 * Description:
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class TwoNumber {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode m = l1, n = l2;
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        int p=0;
        while(m != null || n != null){
            int k = (m==null ? 0:m.val) + (n==null? 0:n.val) + p;
            p = k / 10;    //除10商
            curr.next = new ListNode(k % 10);
            curr = curr.next;
            m = m==null?null:m.next;
            n = n==null?null:n.next;
        }
        if(p>0){
            curr.next = new ListNode(p);
        }
        return pre.next;
    }

}
