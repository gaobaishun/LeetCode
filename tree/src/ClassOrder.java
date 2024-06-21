import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClassOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
//        LinkedList<TreeNode> queue=new LinkedList<>();
//        if(root==null)
//            return null;
//        queue.add(root);
//        TreeNode node;
//        int times=1;
//        while(queue.size()!=0){
//            List<Integer> list=new ArrayList<>();
//            for(int i=0;i<times;i++) {
//                node = queue.remove(0);
//                if(node!=null) {
//                    list.add(node.val);
//                }else{
//                    list.add(null);
//                }
//            }
//            times=times*2;
//        }
//        return null;
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        classToList(root,list,0);
        for(int i=0;i<list.size();i++){
            if(list.get(i).size()==0){
                list.remove(i);
            }
        }
        return list;
    }

    public void classToList(TreeNode node,List<List<Integer>> list,int classNo){
        List<Integer> list1;
        if(classNo+1>list.size()){
            list.add(new ArrayList<>());
        }
        if(node==null){
            //if(list.get(classNo).size()==0) list.set(classNo,new ArrayList<>());
        }else{
            list1=list.get(classNo);
            list1.add(node.val);
            list.set(classNo,list1);
            classNo++;
            classToList(node.left,list,classNo);
            classToList(node.right,list,classNo);
        }
    }
    public static void main(String args[]){
        TreeNode treeNode=new TreeTool().generateTree("[1,null,2]");
        List<List<Integer>> list=new ArrayList<>();
        new ClassOrder().classToList(treeNode,list,0);
        for (List<Integer> list1:
        list){
            for (Integer i :
                    list1) {
                System.out.print(i+"-");
            }
            System.out.println(" ");
        }
        new ClassOrder().levelOrder(treeNode);
    }
}
