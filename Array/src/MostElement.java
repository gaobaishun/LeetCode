import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 多数元素
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 n/2 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 */
public class MostElement {

    /**
     * 我的解决办法
     * @param nums
     * @return
     */
    public static int getMostOfElements(int[] nums){
        Map<Integer, Integer> countNum = new HashMap<>();
        int length = nums.length;
        for (int i :
                nums) {
            if(countNum.containsKey(i)){
                Integer num = countNum.get(i);
                countNum.put(i,++num);
            }else {
                countNum.put(i,1);
            }


            Integer num2=countNum.get(i);

            if(num2>length/2){
                return i;
            }

        }

        return 0;
    }

    /**
     * 位运算解决办法
     * @param nums
     * @return
     */
    public static int getMostOfElements2(int[] nums){
        int length = nums.length;
        int result=0;
        for (int i = 0 , bit=1; i < 32; i++,bit=bit<<1) {
            int bitCounts=0;
            for (int j :
                    nums) {
                if((j&bit)==bit){
                    bitCounts++;
                }

                if(bitCounts>length/2){
                    result=result|bit;
                    break;
                }
            }

        }

        return result;
    }


    public static void main(String[] args) {
        int[] array={3,2,3};
        System.out.println(getMostOfElements2(array));
        Random random=new Random();
        random.ints(0,10);
        int i=1;
        System.out.println(i++);
        System.out.println(++i);
        Map<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(1,i++);
        System.out.println(hashMap);
        System.out.println(hashMap.get(1));
        System.out.println(i);
        System.out.println(1&3);
    }
}
