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

        return null;
    }

    public void quckliyP(int[] nums,int start,int end){
        int sint=nums[start];
        int startIndex=start;
        int endIndex=end;
        int temp=-1;
        while(true){
            while(nums[++startIndex]>=sint) {
                if(startIndex==end){
                    break;
                }
            }
            while(nums[--end]<=sint){
                if(endIndex==start){
                    break;
                }
            }
            if(startIndex>=endIndex) break;
            temp=nums[startIndex];
            nums[startIndex]=nums[endIndex];
            nums[endIndex]=temp;
        }
        temp=nums[start];
        nums[start]=nums[endIndex];
        nums[endIndex]=temp;
        quckliyP(nums,start,endIndex);
        quckliyP(nums,end,startIndex);
    }

    public static void main(String[] args){
        int[] temp={-1,0,1,2,-1,-4};
        new ThreeNumberAddZero().quckliyP(temp,0,5);
        System.out.println(temp);
    }
}
