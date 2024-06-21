/**
 * 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions/xmi2l7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MergeTwoSortArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int temp=0;
        if(m!=0) {
            while (nums2[0] < nums1[m - 1]) {


                for (int i = 0; i < m; i++) {
                    if (nums1[i] > nums2[0]) {


                        temp = nums1[i];
                        nums1[i] = nums2[0];
                        nums2[0] = temp;

                    }
                }
                temp = nums2[0];
                for (int i = 1; i < n; i++) {
                    if (nums2[i] < temp) {
                        nums2[i - 1] = nums2[i];
                        nums2[i] = temp;

                    } else {
                        break;
                    }
                }
            }
        }
        if(nums2.length>0) {
            for (int i = m; i <nums1.length; i++) {
                nums1[i]=nums2[i-m];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1={0};
        //{1,2,2,3,0,0,0}
        int[] nums2={1};
        //{4,5,6}
        new MergeTwoSortArray().merge(nums1,0,nums2,1);
        System.out.println(nums1);
    }
}
