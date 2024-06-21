public class Temp {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int index1=0;
//        int index2=0;
//        int tempt;
//        while(index1<m-1&&index2<n-1){
//            if(nums1[index1]>nums2[index2]){
//                tempt=nums1[index1];
//                nums1[index1]=nums2[index2];
//                nums2[index2]=tempt;
//            }
//        }

        int tempt=0;
        for (int i = m; i <n+m ; i++) {
            System.out.println("?");
            nums1[i]=nums2[tempt];
            tempt++;
        }

        int nums1Index=m-1;
        int nums2Index=m+n-1;
        while(n>0){
            nums1Index=m-1;
            nums2Index=m+n-1;
            while(nums1[nums1Index]<nums1[nums2Index]){
                nums2Index--;
            }
            while(nums1[nums1Index]>nums1[nums2Index]){
                nums1Index--;
            }
            System.out.println(nums1[nums1Index]+"-"+nums1Index);
            System.out.println(nums1[nums2Index]+"-"+nums2Index);
            move(nums1,nums2,nums1Index+1,nums2Index,m);
            m=nums1Index+1;
            n=nums2Index-m+1;
            System.out.println("n1="+nums1Index);
            System.out.println("n2="+nums2Index);
        }
    }
    public void move(int[] nums1,int[] nums2,int point1,int point2,int m){
        int jishu=-1;
        for(int i=point1;i<m;i++){
            jishu++;
            nums2[jishu]=nums1[i];

        }
        for(int j=m;j<=point2;j++){
            nums1[j-m+point1]=nums1[j];
        }
        for(int k=point2;k>point2-(m-point1);k--){
            //System.out.println(k+"-"+jishu);
            nums1[k]=nums2[jishu];
            jishu--;
        }
        for (int t :
                nums1) {
            System.out.print(t+"_");
        }
        System.out.println(" *");
    }

    public int firstBadVersion(int n) {
        int temp=1+(n-1)/2;
        int start=1;
        int end=n;
        if(checkFirstBadV(1)){
            return 1;
        }
        while(!checkFirstBadV(temp)){
            if(!isBadVersion(start)&&!isBadVersion(temp)){
                start=temp+1;
                temp=start+(end-start)/2;
            }else{
                end=temp-1;
                temp=start+(end-start)/2;
            }
            System.out.println(temp);
        }
        return temp;
    }
    public boolean checkFirstBadV(int vNo){
        if(vNo==1) {
            if(isBadVersion(vNo)) {
                return true;
            }else{
                return false;
            }
        }else{
            if(isBadVersion(vNo)&&!isBadVersion(vNo-1)){
                return true;
            }else{
                return false;
            }
        }
    }

    public boolean isBadVersion(int v){
        if(v>=2147483647){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        int[] a1={1,2,3,2,5,6};
        int[] a2={2,5,6};
        //new Temp().merge(a1,3,a2,3);
        //new Temp().move(a1,a2,1,3,3);
//        for (int t :
//                a1) {
//            System.out.print(t);
//        }

        int[] u={0};
        int[] m={1};
        u=m;
        //System.out.println(u[0]);

        int v=2147483647;
        System.out.println(new Temp().firstBadVersion(v));
        System.out.println(Integer.MAX_VALUE>2126753390);

    }
}
