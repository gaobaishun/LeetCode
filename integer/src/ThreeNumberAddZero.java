import java.util.*;

/**
 * @CLassName: ThreeNumberAddZero
 * @Description: 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @Author: gaobaishun
 * @Date: 1/3/2019 11:04 PM
 * @Version 1.0
 **/
public class ThreeNumberAddZero {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        int a=0;
        int b=0;
        boolean bo=false;
        for(int ai=0;ai<nums.length;ai++){
            a=nums[ai];
            for(int bi=ai+1;bi<nums.length;bi++){
                b=nums[bi];
                for(int ci=bi+1;ci<nums.length;ci++){
                    List<Integer> list=new ArrayList<>();
                    list.add(a);
                    list.add(b);
                    list.add(nums[ci]);
                    list=paixu(list);
                    if(a+b==0-nums[ci]){
                        for(List<Integer> l:lists){
                            if(l.get(0)==list.get(0)&&l.get(1)==list.get(1)){
                                bo=true;
                                break;
                            }
                        }

                        if(!bo) {
                            lists.add(list);
                        }else{
                            bo=true;
                        }
                    }
                }
            }
        }
        return lists;
    }
    public List<Integer> paixu(List<Integer> list){
        int temp= list.get(0);
        for(int i=1;i<list.size();i++){
            if(temp<=list.get(i)){
                continue;
            }else{
                int t=list.get(i);
                list.set(i,temp);
                temp=t;
            }
        }
        list.set(0,temp);
        if(list.get(1)>list.get(2)){
            temp=list.get(1);
            list.set(1,list.get(2));
            list.set(2,temp);
        }
        return list;
    }

    public static void main(String[] args){
        int[] temp={-1,0,1,2,-1,-4};
        System.out.println(new ThreeNumberAddZero().threeSum(temp));
    }
}
