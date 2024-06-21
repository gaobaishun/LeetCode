
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Depth {
    public int maxDepth(TreeNode root) {
        int depth=0;
        if(root==null){
            return depth;
        }
        if(root.left==null&&root.right==null){
            depth=1;
        }else if(root.left!=null&&root.right==null){
            depth=maxDepth(root.left)+1;
        }else if(root.right!=null&&root.left==null){
            depth=maxDepth(root.right)+1;
        }else{
            int leftDepth=maxDepth(root.left);
            int rightDepth=maxDepth(root.right);
            if(leftDepth>=rightDepth){
                depth=leftDepth+1;
            }else{
                depth=rightDepth+1;
            }
        }
        return depth;
    }

    public static void main(String[] args){
        TreeNode treeNode=new TreeNode(3);
        TreeNode treeNode1=new TreeNode(9);
        TreeNode treeNode2=new TreeNode(20);
        TreeNode treeNode3=new TreeNode(15);
        TreeNode treeNode4=new TreeNode(7);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode2.left=treeNode3;
        treeNode2.right=treeNode4;

        System.out.println(new Depth().maxDepth(treeNode));
    }
}
