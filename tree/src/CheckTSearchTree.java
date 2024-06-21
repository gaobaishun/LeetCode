import apple.laf.JRSUIUtils;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;

public class CheckTSearchTree {
    public boolean isValidBST(TreeNode root) {
//        ArrayList<Integer> list=new ArrayList<>();
//        LNR(root,list);
//        for (int i = 1; i <list.size() ; i++) {
//            if(list.get(i)<=list.get(i-1)){
//                return false;
//            }
//        }
//        return true;
//        if(root==null){
//            return true;
//        }else if(root.left!=null&&root.left.val>=root.val){
//            return false;
//        }else if(root.right!=null&&root.right.val<=root.val){
//            return false;
//        }
//        return LNR(root.left,root)&&LNR(root.right,root);
        if(root==null){
            return true;
        }
        if(isValidBST(root.left)){
            if(root.left!=null&&findMaxVal(root.left)>= root.val) {
                return false;
            }
        }else{
            return false;
        }
        if(isValidBST(root.right)){
            if(root.right!=null&&findMinVal(root.right)<=root.val){
                return false;
            }
        }else{
            return false;
        }
        return true;

    }
    public int findMaxVal(TreeNode node){// 假设参数node不为空
        TreeNode temp=node;
        while(temp.right!=null){
            temp=temp.right;
        }
        return temp.val;
    }
    public int findMinVal(TreeNode node){
        TreeNode temp=node;
        while(temp.left!=null){
            temp=temp.left;
        }
        return temp.val;
    }
//    public ArrayList<Integer> treeToList(TreeNode node, ArrayList<Integer> list){
//
//        if (node==null){
//            return list;
//        }
//        if(node.left==null){
//            list.add(node.val);
//        }else{
//            treeToList(node.left,list);
//        }
//        list.add(node.val);
//        if(node.right==null){
//            list.add(node.right.val);
//        }else {
//            treeToList(node.right,list);
//        }
//        return list;
//    }
    public static void test(ArrayList<Integer> list){
        list.add(1);
    }

    /**
     * 中序遍历
     * @param root
     */
//    public void LNR(TreeNode root,ArrayList<Integer> list){
//        if(null!=root){
//            LNR(root.left,list);
//            System.out.println(root.val+"%");
//            list.add(root.val);
//            LNR(root.right,list);
//        }
//    }
    public boolean LNR(TreeNode node,TreeNode fatherNode){
        if(null!=node){
            if(fatherNode!=null) {
                if (node == fatherNode.left && node.val >= fatherNode.val)
                    return false;
                if (node == fatherNode.right && node.val <= fatherNode.val)
                    return false;
            }
            if (!LNR(node.left,node)){
                return false;
            }
            System.out.println(node.val+"%");
            if(!LNR(node.right,node)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        ArrayList<Integer> list=new ArrayList<>();
        test(list);
        System.out.println(list.size());
        String s="[2,1,3]";
        TreeTool tool=new TreeTool();
        TreeNode t=tool.generateTree(s);
        list=new ArrayList<>();
        //new CheckTSearchTree().LNR(t,list);
        for (Integer temp:
             list) {
            System.out.println(temp);
        }

    }
}
