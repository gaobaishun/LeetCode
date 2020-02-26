import java.util.ArrayList;

public class TreeTool {
    public Integer[] stringsToIntegers(String s){
        String[] s2=s.split(",");
        Integer[] integers=new Integer[s2.length];
        s2[0]=s2[0].substring(1);
        s2[s2.length-1]=s2[s2.length-1].substring(0,s2[s2.length-1].length()-1);
        for (int i=0;i<s2.length;i++){
            String temp=s2[i];
            if (!s2[i].equals("null")){
//                if(i==0){
//                temp=temp.substring(1);
//                System.out.println(temp);
//
//                } else if(i==s2.length-1){
//                temp=temp.substring(0,temp.length()-1);
//                System.out.println(temp);
//                }else{
//                System.out.println(temp);
//                }
                integers[i]=Integer.valueOf(temp);
            }
        }
        return integers;
    }
    public TreeNode generateTree(String s){
        Integer[] integers=this.stringsToIntegers(s);
        TreeNode head=null;
        if(integers[0]!=null){
            head=new TreeNode(integers[0]);
        }

        ArrayList<TreeNode> que=new ArrayList<>();
        que.add(head);
        for (int i=0;i<integers.length;i++){
            TreeNode temp=que.get(i);
            if(integers[i]==null)
                continue;
            if((i*2+1)>=integers.length||integers[i*2+1]==null){
                temp.left=null;

            }else{
                temp.left=new TreeNode(integers[i*2+1]);

            }
            que.add(temp.left);

            if((i*2+2)>=integers.length||integers[i*2+2]==null){
                temp.right=null;

            }else{
                temp.right=new TreeNode(integers[i*2+2]);

            }
            que.add(temp.right);

        }
        return head;
    }
    public static void main(String[] args){
        String s="[2,1,3]";
//        String[] s2=s.split(",");
//        for (String  t:
//                s2) {
//            System.out.println(t+"_");
//        }
//        Integer[] integers=new Integer[s2.length];
//        for (int i=0;i<s2.length;i++){
//            String temp=s2[i];
//            if(i==0){
//                temp=temp.substring(1);
//                System.out.println(temp);
//
//            } else if(i==s2.length-1){
//                temp=temp.substring(0,temp.length()-1);
//                System.out.println(temp);
//            }else{
//                System.out.println(temp);
//            }
//            integers[i]=Integer.getInteger(temp);
//        }
        Integer[] ints=new TreeTool().stringsToIntegers(s);
        for (int t :
                ints) {
            System.out.println(t+"*");
        }
        System.out.println();

        new TreeTool().generateTree(s);
    }
}
