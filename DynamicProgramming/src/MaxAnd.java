import java.util.HashMap;
import java.util.Map;

public class MaxAnd {
    public Map<Integer,Integer> map=new HashMap<>();
    public int maxSubArray(int[] nums) {
//        int max;
//        int len=nums.length;
//        int start=0;
//        int end=len-1;
//        int tempValue=0;
//        for (int i=0;i<len;i++){
//            tempValue=tempValue+nums[i];
//        }
//        max=tempValue;
//        while(start<end){
//               while(nums[start]<0&&start<end){
//                   tempValue=tempValue-nums[start];
//                   start++;
//               }
//               while(nums[end]<0&&start<end){
//                   tempValue=tempValue-nums[end];
//                   end--;
//               }
//               if(tempValue>max){
//                   max=tempValue;
//               }
//               tempValue=tempValue-nums[start]-nums[end];
//               start++;
//               end--;
//        }
//        System.out.println(start+"-"+end);
//        return max;
//          int max;
//          int start=0;
//          int len=nums.length;
//          int end=len-1;
//          int tempValue=0;
//          for (int i=0;i<len;i++){
//            tempValue=tempValue+nums[i];
//          }
//          max=tempValue;
//          int leftV;
//          int rightV;
//          boolean t=true;
//          while(start<end){
//
//              if (t){
//                  tempValue=tempValue-nums[start];
//                  if(tempValue>max){
//                      max=tempValue;
//                  }
//                  start++;
//                  t=false;
//              }else {
//                  t=true;
//                  tempValue=tempValue-nums[end];
//                  end--;
//                  if(tempValue>max){
//                      max=tempValue;
//                  }
//              }
//          }
//          return max;
        int all=0;
        for (int a :
                nums) {
            all = all + a;
        }
        return maxV(nums,0,nums.length-1,all);
    }

    public int maxV(int[] nums,int start,int end,int allnum){
        if(start==end){
            return allnum;
        }
        int index=nums.length*start+end;
        if(map.get(index)==null){
            map.put(index,allnum);
        }
        index=nums.length*(start+1)+end;
        int left;
        if(map.get(index)==null) {
             left= maxV(nums, start + 1, end, allnum - nums[start]);
        }else{
            left=map.get(index);
        }
        int right;
        index=nums.length*start+(end-1);
        if(map.get(index)==null){
            right=maxV(nums,start,end-1,allnum-nums[end]);
        }else{
            right=map.get(index);
        }

        if(allnum>left&&allnum>right){
            return allnum;
        }else if(left>right){
            return left;
        }else{
            return right;
        }
    }
    public static void main(String[] args){
        int[] a={-57,9,-72,-72,-62,45,-97,24,-39,35,-82,-4,-63,1,-93,42,44,1,-75,-25,
                -87,-16,9,-59,20,5,-95,-41,4,-30,47,46,78,52,74,93,-3,53,17,34,-34,34,-69,-21,-87,
                -86,-79,56,-9,-55,-69,3,5,16,21,-75,-79,2,-39,25,72,84,-52,27,36,98,20,-90,52,-85,
                44,94,25,51,-27,37,41,-6,-30,-68,15,-23,11,-79,93,-68,-78,90,11,-41,-8,-17,-56,17,
                86,56,15,7,66,-56,-2,-13,-62,-77,-62,-12,37,55,81,-93,86,-27,-39,-3,-30,-46,6,-8,
                -79,-83,50,-10,-24,70,-93,-38,27,-2,45,-7,42,-57,79,56,-57,93,-56,79,48,-98,62,11,
                -48,-77,84,21,-47,-10,-87,-49,-17,40,40,35,10,23,97,-63,-79,19,6,39,62,-38,-27,81,
                -68,-7,60,79,-28,-1,-33,23,22,-48,-79,51,18,-66,-98,-98,50,41,13,-63,-59,10,-49,-38,
                -70,56,77,68,95,-73,26,-73,20,-14,83,91,61,-50,-9,-40,1,11,-88,-80,21,89,97,-29,8,10,
                -15,48,97,35,86,-96,-9,64,48,-37,90,-26,-10,-13,36,-27,-45,-3,-1,45,34,77,-66,22,73,54,
                11,70,-97,-81,-43,-13,44,-69,-78,30,-66,-11,-29,58,52,-61,-68,-81,25,44,-32,57,-81,66,2,
                52,43,35,-26,16,-33,61,-37,-54,80,-3,32,24,27,30,-69,38,-81,2,-4,47,17,5,42,-58,-51,-90,
                98,-33,76,-22,95,-4,89,-31,-87,-44,-69,-48,1,87,48,-90,-12,-24,39,18,-86,35,96,-14,-41,
                13,90,-98,32,-83,-89,7,-17,63,84,-21,-40,51,24,-51,83,31,0,-38,-5,-74,-29,59,1,87,-22,-9,-1,
                -49,76,57,41,44,35,-27,60,23,56,-80,-14,41,-2,22,-31,99,47,-48,7,-75,13,-97,-50,61,61,27,48,
                -84,94,-76,-56,70,57,84,-9,-7,-66,-49,-84,89,-29,-22,7,45,-99,75,21,24,-95,-71,48,17,-92,74,
                -22,45,1,-97,61,-5,-74,81,-57,83,42,33,-47,75,61,-55,41,-68,22,-51,53,-1,-99,-25,-76,-95,3,48,
                -1,-13,23,53,-68,-76,33,92,-4,35,50,38,18,-8,-52,47,-33,-91,91,85,-60,14,-89,93,89,-89,-55,89,
                92,47,38,-9,-66,-39,-79,-58,-39,53,-65,56,-11,61,-29,83,-46,19,31,-3,27,-1,-18,67,-87,-8,37,79,
                -20,58,68,-28,-18,-17,39,-8,43,59,33,81,13,44,37,-98,6,85,84,59,4,-8,-44,-69,91,15,74,80,83,-12,59,
                -37,-54,5,34,27,87,-50,-81,8,-90,52,-11,-1,-4,-97,0,78,87,-39,37,-32,30,70,-1,21,-38,-50,-22,-55,15,
                -85,8,60,19,-81,-35,-17,-31,-40,90,-45,-88,-44,53,-15,-41,-70,-37,-77,-33,77,-9,96,24,66,-6,85,92,72,
                -70,7,86,14,-32,-18,33,9,64,78,68,32,-90,57,87,62,-58,-77,68,-19,-54,-65,-42,13,-68,58,-44,25,43,-52,
                -26,73,55,-63,-13,-77,18,96,31,-40,51,-1,91,60,-44,55,22,-26,78,-10,32,-99,2,66,13,33,25,68,-65,-32,
                -84,-14,-82,70,22,5,69,-59,-22,-23,0,-70,53,-32,89,85,-77,-11,-40,77,55,68,77,-43,34,-33,66,-41,-88,
                -98,27,-72,-13,21,74,85,-74,21,-74,-19,97,2,10,50,46,-1,13,69,87,72,23,20,40,1,76,-49,67,43,10,79,21,
                -86,83,84,34,34,69,37,-45,72,-82,-70,-26,27,56,97,-97,-31,66,67,-82,-11,-13,57,66,-37,85,11,82,-5,-33,
                3,-15,-50,-13,95,60,-66,9,-84,-94,26,-78,-44,-70,77,-47,-90,-53,95,76,-36,-38,-60,98,-72,-21,83,15,-38,
                -44,72,-58,-83,20,49,-64,94,18,11,48,16,2,-26,47,99,-21,-50,55,-23,-94,-73,46,-85};
        //System.out.println(new MaxAnd().maxSubArray(a));
        int all=0;
        for (Integer b :
                a) {
            all = all + b;
        }
        System.out.println(new MaxAnd().maxV(a,0,a.length-1,all));
    }
}
