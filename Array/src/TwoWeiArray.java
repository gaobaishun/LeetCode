/**
 * 搜索二维矩阵 II
 * 编写一个高效的算法来搜索mn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *

 */
public class TwoWeiArray {

    public boolean searchMatrix(int[][] matrix, int target) {
        return findNumFromArray(matrix,target,0,matrix.length-1,0,matrix[0].length-1);
    }


    /**
     * 从右上角开始找，应为右上角是中间大小
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        //从矩阵右上角开始搜索
        int col = matrix[0].length - 1;//列
        int row = 0;//行

        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                //如果找到就直接返回
                return true;
            } else if (target < matrix[row][col]) {
                //如果查找的值大了，下一步往左找
                col--;
            } else if (target > matrix[row][col]) {
                //如果查找的值小了，下一步往下找
                row++;
            }
        }
        return false;
    }


    private int findFirstBiggerNumIndex(int[] array,int target){
        for (int i = 0; i < array.length; i++) {
            if(array[i]>=target){
                return i;
            }
        }

        return -1;
    }

    private int findLastSmallerNumIndex(int[] array,int target){
        for (int i = 0; i < array.length; i++) {
            if(array[i]>=target){
                return i-1;
            }
        }

        return -1;
    }

    private boolean findNumFromArray(int[][] array,int target,int hStart,int hEnd,int lStart,int lEnd){
        for (int i = hEnd; i >= hStart ; i--) {
            for (int j = lEnd; j >= lStart ; j--) {
                if (array[i][j]==target){
                    return true;
                } else if (array[i][j] < target) {
                    break;
                }
            }
        }

        return false;
    }
    private int[] findMatrix(int[][] matrix,int target,int hStrart,int hEnd){
        if(hStrart==hEnd)
            return matrix[hStrart];
        int helfH=(hStrart+hEnd)/2;
        int l=matrix[0].length;
        if(matrix[helfH][l-1]>target){
            return findMatrix(matrix,target,hStrart,helfH);
        }else{
            return findMatrix(matrix,target,helfH,hEnd);
        }
    }
    private boolean binarySerach(int[] array,int target,int start,int end){
        if(end<start){
            return false;
        }

        int helfNum=(end+start)/2;
        if(array[helfNum]==target){
            return true;
        }else if(array[helfNum]>target){
            return binarySerach(array,target,start,helfNum-1);
        }else{

            return binarySerach(array,target,helfNum+1,end);
        }
    }


    public static void main(String[] args) {
        int v = (int)(10 * (100.0 / 141));
        System.out.println(v);
        int[][] a={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] a2={{1,4,7,11},{2,5,8,12},{3,6,9,16},{10,13,14,17},{18,21,23,26}};
        System.out.println(new TwoWeiArray().searchMatrix(a,15));
    }
}
