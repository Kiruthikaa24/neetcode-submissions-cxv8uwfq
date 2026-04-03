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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //base case
        if(list1==null)
        {
            return list2;
        }
        //base case
        if(list2==null)
        {
            return list1;
        }
        //l1=head of linkedlist2 
        //l2=head of linkedlist1
        //if l1>l2 at any point
        if(list1.val>list2.val)
        {
           //we break and we swap here
           ListNode temp=list1;
           list1=list2;
           list2=temp;
        }
        ListNode res=list1;

        //list should not be empty and l1<l2: update temp and point it
        while(list1!=null && list2!=null)
        {
            ListNode prev=null;
        while(list1!=null && list1.val<=list2.val)
        {
            prev=list1;
            list1=list1.next;
        }
        //we "insert" list2 into the merged list:
        //Now the merged chain continues into list2.
        prev.next=list2;
        //swap
        //Now list2 is sitting inside the merged chain.
//But we don’t want to continue merging from list2 → we want to continue comparing with the "smaller" list again.
        ListNode temp=list1;
        list1=list2;
        list2=temp;
        }
        return res;
    }}
