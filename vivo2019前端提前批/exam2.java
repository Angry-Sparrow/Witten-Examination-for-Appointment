package vivotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ${Lee} on 2019/6/10
 * 第二题：将单向链表里 m 到 n 范围的链表反转
 * java版
 */

public class exam2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arrA = parseInts(br.readLine().split(" "));
        int[] arrB = parseInts(br.readLine().split(" "));
        int m = arrA[0];
        int n = arrA[1];
        ListNode head = null;
        ListNode pre  = null;
        for(int v : arrB) {
            ListNode listNode = new ListNode(v);
            if (head == null) {
                head = listNode;
            }
            if (pre!=null) {
                pre.next = listNode;
            }
            pre=listNode;
        }
        print(head);
        solution(head,m,n);
        print(head);
    }
    private static void solution(ListNode head,int m,int n) {
        ListNode tmp = head;
        int index = 1;
        ListNode mNode = new ListNode(tmp.val);
        ListNode nNode = new ListNode(tmp.val);
        while (tmp!=null) {
            if (index==m) {
                mNode.val = tmp.val;
                mNode.next = tmp.next;
            }
            if (index==n) {
                nNode.val = tmp.val;
                nNode.next = tmp.next;
            }
            tmp = tmp.next;
            index++;
        }
        ListNode tmpNext = nNode.next;
        nNode.next = mNode.next;
        mNode.next = tmpNext;
        tmp = head;
        index=1;
        while (tmp!=null) {

            if (index==m-1) {
                tmp.next = nNode;
            }
            if (index==n-1) {
                tmp.next = mNode;
            }
            tmp = tmp.next;
            index++;
        }
    }
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int v) {
            // TODO Auto-generated constructor stub
            val = v;
            next = null;
        }
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            String str = val+" ";
            ListNode node = next;
            while(node !=null) {
                str+=node.val+" ";
                node = node.next;
            }
            return str;

        }
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr==null||strArr.length==0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }
    private static void print(ListNode head) {
        while(head!=null) {
            System.out.println(head.val);
            head=head.next;
        }
    }
}

