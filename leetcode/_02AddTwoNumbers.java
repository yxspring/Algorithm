package leetcode;

import javax.xml.soap.Node;

/**
 * @ProjectName: BCDS
 * @Package: leetcode
 * @ClassName: _02AddTwoNumbers
 * @Author: yuxingsheng
 * @Description: You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/1/13 9:36
 * @Version: 1.0
 */
public class _02AddTwoNumbers {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(7);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=null;
        ListNode l3=addTwoNumbers(l1,l2);
        for(int i=0;i<3;i++){
            System.out.println(l3.val);
            l3=l3.next;
        }

    }
    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int curry=0;
        ListNode p=l1,q=l2,ln=new ListNode(0);
        ListNode m=ln;
        while(p!=null||q!=null){
            int temp=(p==null?0:p.val)+(q==null?0:q.val)+curry;
            ListNode ls=new ListNode(temp%10);
            curry=temp/10;
            m.next=ls;
           if(p !=null) p=p.next;
           if(q!=null) q=q.next;
           m=m.next;
        }
        if(curry>0) m.next=new ListNode(curry);
        return ln.next;
    }
}
