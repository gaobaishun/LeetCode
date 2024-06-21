public class ArrayToTree {
    public TreeNode sortedArrayToBST(int[] nums) {


        return limitArrayToBST(nums,0,nums.length-1);
    }

    public TreeNode limitArrayToBST(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        int rootIndex=start+(end-start+1)/2;
        TreeNode rootNode=new TreeNode(nums[rootIndex]);
        rootNode.left=limitArrayToBST(nums,start,rootIndex-1);
        rootNode.right=limitArrayToBST(nums,rootIndex+1,end);
        return rootNode;
    }
    public TreeNode atoTree(int[] nums){
        if(nums.length==0){
            return null;
        }
        TreeNode tree=new TreeNode(nums[0]);
        if(nums.length==1){
            return tree;
        }
        TreeNode tempNode=tree;
        TreeNode fatherNode=tempNode;
        boolean isLeft=false;
        for (int i = 1; i < nums.length; i++) {
            while(tempNode!=null){
                fatherNode=tempNode;
                if(nums[i]>tempNode.val){
                    isLeft=false;
                    tempNode=tempNode.right;
                }else{
                    isLeft=true;
                    tempNode=tempNode.left;
                }
            }
            if(isLeft){
                fatherNode.left=new TreeNode(nums[i]);
            }else{
                fatherNode.right=new TreeNode(nums[i]);
            }
            tempNode=tree;
            fatherNode=tree;
        }
        return tree;
    }
    public static void main(String[] args){
        int[] nums={-10,-3,0,5,9};
        TreeNode tree=new ArrayToTree().atoTree(nums);
        TreeNode tr2=new ArrayToTree().sortedArrayToBST(nums);
        System.out.println("end");
    }
}
