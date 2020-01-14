package leetcode;
/**
 * @ProjectName: BCDS
 * @Package: leetcode
 * @ClassName: _02AddTwoNumbers
 * @Author: yuxingsheng
 * @Description: You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in normal order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 8->0->7  Explanation:243+564=807
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers  变形
 * @Date: 2020/1/13 9:36
 * @Version: 1.0
 */
public class _02AddTwoNumbers_2 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }

    public static void main(String[] args) {
        _02AddTwoNumbers_2 a = new _02AddTwoNumbers_2();
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(7);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=null;
        ListNode l3=a.addTwoNumbers(l1,l2);
        for(int i=0;i<3;i++){
            System.out.println(l3.val);
            l3=l3.next;
        }

    }
    public ListNode inverseListNode(ListNode l1){
        ListNode p=l1,m=new ListNode(0);
        while(p!=null){
            m.val=p.val;
            ListNode temp=new ListNode(0);
            if(p.next!=null){
                temp.next=m;
                m=temp;
            }
            p=p.next;
        }
       return m;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=inverseListNode(l1);
        l2=inverseListNode(l2);
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
