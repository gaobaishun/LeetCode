import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Tou {
    public Map<Integer,Integer> map=new HashMap<>();
    public int rob(int[] nums) {
        int len=nums.length;
        int v1=robS(nums,0,len-1);
        int v2=robS(nums,1,len-1);
        return v1>v2? v1:v2 ;
    }
    public int robS(int[] nums,int start,int end){

        int len=nums.length;
        if(start==end){
            return nums[start];
        }
        if(start>end){
            return 0;
        }
//        if(start>=93){
//            System.out.println(start);
//        }
        int v1;
        int v;
        int key=indexToKey(start+2,end,len);
        if(map.containsKey(key)){
            v1=nums[start]+map.get(key);
        }else{
            //System.out.println("1-"+start+"-"+key);
            v=robS(nums,start+2,end);
            map.put(key,v);
            v1=nums[start]+v;
        }

        int v2;
        key=indexToKey(start+3,end,len);
        if(map.containsKey(key)){
            v2=nums[start]+map.get(key);
        }else{
            //System.out.println("2-"+start+"-"+key);
            v=robS(nums,start+3,end);
            map.put(key,v);
            v2=nums[start]+v;
        }

        return v1>v2? v1:v2;
    }
    public int indexToKey(int start,int end,int len){
        return start*len+end;
    }
    public static void main(String[] args){
        int[] r={226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,
                211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
        //System.out.println(new Tou().rob(r));
        System.out.println(System.currentTimeMillis());
        Random random=new Random(System.currentTimeMillis());

        int i=0;
        while(i!=9){
            i=random.nextInt(10);
            System.out.println(i);
        }

    }
}
