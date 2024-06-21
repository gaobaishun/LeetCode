import java.util.*;

public class Solution {
    private int[] nums;
    private int[] returnnums;
    public Solution(int[] nums) {
        this.nums=nums;

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        returnnums=nums.clone();
        Random random=new Random();
        int len=returnnums.length;
        int randomNum;
        int temp;
        for (int i=0;i<len;i++){
            randomNum=random.nextInt(len-i)+i;

            temp=returnnums[i];
            returnnums[i]=returnnums[randomNum];
            returnnums[randomNum]=temp;
        }
        return this.returnnums;
    }


    public void test(int times,int[] b){
        int[] a;
        String s="null";
        Map<String,Integer> map=new HashMap<>();
        while(times>0){
            a=new Solution(b).shuffle();
            s="";
            for(int i=0;i<a.length;i++){
                s=s+"_"+a[i];
            }
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
            times--;
        }

        Set<Map.Entry<String,Integer>> set=map.entrySet();
        System.out.println("total:"+set.size());
        for (Map.Entry<String,Integer> entry: set
             ) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }
    public static void main(String[] args){
        int[] a={1,2,3};
        int[] b={-9,10,100,20};
        Solution s=new Solution(a);
        for (int i:
        s.shuffle()){
            System.out.println(i);
        }
        for (int i:
                s.reset()){
            System.out.println(i);
        }

        new Solution(a).test(1000000,a);
    }
}
