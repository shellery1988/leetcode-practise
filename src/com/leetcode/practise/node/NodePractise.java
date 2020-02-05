package com.leetcode.practise.node;

import java.util.Objects;

public class NodePractise {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(6);
        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        System.out.println(listNodeToString(n1));
        ListNode k = listNodeRevert(n1);
        System.out.println(listNodeToString(k));
    }

    public static String listNodeToString(ListNode n){
        if(n==null)
            return "";
        ListNode tmp = n;
        StringBuffer sb = new StringBuffer();
        while (tmp.next!=null){
            sb.append(tmp.val).append("->");
            tmp = tmp.next;
        }
        sb.append(tmp.val);
        return sb.toString();
    }

    public static ListNode listNodeRevert(ListNode n){
        if(n==null)
            return null;
        ListNode k = null;
        ListNode tmp = null;
        while (n.next!= null){
            k= new ListNode(n.next.val);
            if(tmp==null){
                k.next = new ListNode(n.val);
            } else{
                k.next = tmp;
            }
            tmp= k;
            n = n.next;
        }
        return k;
    }

}

class ListNode{

    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

}
