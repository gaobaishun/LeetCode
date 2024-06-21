import java.util.ArrayList;
import java.util.List;

/**
 * @CLassName: 判断是否为环形链表
 * @Description: 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 *
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * @Author: gaobaishun
 * @Date: 1/2/2019 9:06 PM
 * @Version 1.0
 **/
public class CycleList {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }

        ListNode tempNode=head.next;//当前节点
        ListNode tmp=head;
        while(tempNode!=null){

        }
        return false;
    }

    public boolean isCycle(ListNode node){
        return true;
    }



    public ListNode reverseList(ListNode head) {
        ListNode headNode=new ListNode(0);
        headNode.next=head;
        ListNode tempNode=new ListNode(1);
        tempNode.next=head;

        if(tempNode.next==null) {
            return null;
        }
        if(tempNode.next.next == null){
            return head;
        }
        ListNode temp2=new ListNode(2);
        temp2.next=null;
        while(true) {

            temp2.next=tempNode.next.next;

            tempNode.next.next=temp2.next.next;

            temp2.next.next=headNode.next;
            headNode.next=temp2.next;
            // ListNode ll=headNode;
            // while(true) {
            // 	if(ll.next ==null) {
            // 		break;
            // 	}
            // 	System.out.print(ll.next.val+"");
            // 	ll=ll.next;
            // }
            if(tempNode.next.next==null) {
                break;
            }

            System.out.println(" ");
        }
        return headNode.next;
    }

   public static void main(String[] args){
        ListNode n1=new ListNode(2);
        n1.next=new ListNode(34);
       System.out.println(n1.hashCode());
       //change(n1);
       System.out.println(new CycleList().hasCycle(n1));
       System.out.println(n1);

   }
}

