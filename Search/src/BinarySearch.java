/**
 * 二分法搜索
 */
public class BinarySearch {

    public static boolean search(int[] array,int target,int start,int end){
        if(end<start){
            return false;
        }

        int helfNum=(end+start)/2;
        if(array[helfNum]==target){
            return true;
        }else if(array[helfNum]>target){
            return search(array,target,start,helfNum-1);
        }else{

            return search(array,target,helfNum+1,end);
        }
    }

    public static void main(String[] args) {
        int[] a={1,4,7,11,15};
        System.out.println(search(a,4,0,a.length-1));
    }
}
