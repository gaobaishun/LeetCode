import java.util.*;

public class Symmetric {
    public boolean isSymmetric(TreeNode root) {
//        ArrayList<Integer> nodeList=new ArrayList<>();
//        LNR(root,nodeList);
//        int head=0;
//        int tail=nodeList.size()-1;
//        while(head<tail){
//            if(nodeList.get(head)==nodeList.get(tail)){
//                head++;
//                tail--;
//            }else{
//                return false;
//            }
//        }
//        return true;
//        if(root==null){
//            return true;
//        }
//        ArrayList<Integer> nodeList1=new ArrayList<>();
//        LNR(root.left,nodeList1);
//        ArrayList<Integer> nodeList2=new ArrayList<>();
//        RNL(root.right,nodeList2);
//
//        if(nodeList1==null&&nodeList2==null){
//            return true;
//        }else if(nodeList1.size()==nodeList2.size()){
//            for (int i = 0; i < nodeList1.size(); i++) {
//                if(nodeList1.get(i)!=nodeList2.get(i)){
//                    return false;
//                }
//            }
//            return true;
//        }else{
//            return false;
//        }
        if(root==null){
            return true;
        }

        return isSym(root.left,root.right);
    }

    public void LNR(TreeNode root, ArrayList<Integer> list){
        if(root!=null) {
            LNR(root.left, list);
            list.add(root.val);
            LNR(root.right, list);
        }
    }

    public void RNL(TreeNode root, ArrayList<Integer> list){
        if(root!=null) {
            LNR(root.right, list);
            list.add(root.val);
            LNR(root.left, list);
        }
    }

    /**
     * 递归解决镜像对称
     * @param root1
     * @param root2
     * @return
     */
    public boolean isSym(TreeNode root1,TreeNode root2){
        if(root1!=null&&root2!=null){
            if(root1.val!=root2.val){
                return false;
            }
            if(isSym(root1.left,root2.right)&&isSym(root1.right,root2.left)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }

    }

    public boolean isSym2(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }else if(root1!=null&&root2!=null){
            ArrayList<TreeNode> queue1=new ArrayList<>();
            ArrayList<TreeNode> queue2=new ArrayList<>();
            queue1.add(root1);
            queue2.add(root2);
            int q1=0;
            int q2=0;
            while(queue1.size()!=0&&queue2.size()!=0){
                TreeNode q1Node=queue1.remove(q1);
                TreeNode q2Node=queue2.remove(q2);
                if(q1Node==null&&q2Node==null){
                    continue;
                }else if(q1Node!=null&&q2Node!=null) {
                    if (q1Node.val != q2Node.val)
                        return false;
                    queue1.add(q1Node.left);
                    queue2.add(q2Node.right);
                    queue1.add(q1Node.right);
                    queue2.add(q2Node.left);
                }else{
                    return false;
                }
            }
            return true;

        }else{
            return false;
        }
    }

    public static void main(String[] args){
        TreeNode treeNode=new TreeTool().generateTree("[1,2,2,3,4,4,3]");
        ArrayList<Integer> list=new ArrayList<>();
        new Symmetric().LNR(treeNode,list);
        for (Integer i :
                list) {
            System.out.println(i);
        }

        System.out.println(new Symmetric().isSym2(treeNode.left,treeNode.right));

        LinkedList<Integer> list1=new LinkedList<>();
        list1.add(null);
        list1.add(2);
        //list1.remove(0);
        System.out.println(list1.size());
        System.out.println(list1.get(0));
    }
}
