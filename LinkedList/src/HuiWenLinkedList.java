import org.w3c.dom.NodeList;

import java.util.List;
import java.util.Random;

/**
 * @CLassName: HuiWenLinkedList
 * @Description: 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @Author: gaobaishun
 * @Date: 2018/12/30 14:56
 * @Version 1.0
 **/
public class HuiWenLinkedList<main> {

    public boolean isPalindrome(ListNode head) {
        int len = getLength(head);
        int sonLen=len/2;
        if(sonLen==0){
            return true;
        }

        int temp=1;
        ListNode tempNode=head;
        while(tempNode!=null){
            if(temp==sonLen+1){
                tempNode=headEndChange(tempNode);
                break;
            }else{
                tempNode=tempNode.next;
            }
            temp++;
        }
        while(tempNode!=null){

            if (tempNode.val == head.val) {
                tempNode = tempNode.next;
                head = head.next;

            } else {
                return false;
            }
        }
        return true;
    }

    /*
     * @Author gaobaishun
     * @Description 获得链表长度
     * @Date 15:09 2018/12/30
     * @Param
     * @return
     **/
    private int getLength(ListNode head){
        int len=1;
        if(head==null){
            return 0;
        }
        while(head.next!=null){
            len++;
            head=head.next;
        }
        return len;
    }

    private ListNode headEndChange(ListNode listNode){
        ListNode tempNode=null;

        if(listNode==null){
            return null;
        }
        ListNode otherNode=listNode.next;
        listNode.next=null;
        while(otherNode!=null){
            tempNode=otherNode;
            otherNode=otherNode.next;
            tempNode.next=listNode;
            listNode=tempNode;


        }
        return listNode;
    }

    public static void main(String[] args){
        ListNode test=new ListNode(1);
        ListNode tempNode=test;
        Random random=new Random(System.currentTimeMillis());
        for(int i=0;i<0;i++){
            tempNode.next=new ListNode(random.nextInt(100));
            tempNode=tempNode.next;
        }
        tempNode=test;
        while(tempNode!=null){
            System.out.print(tempNode.val+" ");
            tempNode=tempNode.next;
        }
        System.out.println(" ");
        tempNode=test;
        tempNode=new HuiWenLinkedList().headEndChange(tempNode);

        while(tempNode!=null){
            System.out.print(tempNode.val+" ");
            tempNode=tempNode.next;
        }

        ListNode test1=new ListNode(1);
        test1.next=new ListNode(2);
        System.out.println(new HuiWenLinkedList().isPalindrome(test1));
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}