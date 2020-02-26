import java.util.ArrayList;

public class ClimbStairs {
    public int climbStairsP(int n) {
        ArrayList<Integer> sonProblem=new ArrayList<>();
        sonProblem.add(0,0);
        sonProblem.add(1,1);
        sonProblem.add(2,2);
        if(n<=2){
            return sonProblem.get(n);
        }

        return climbP(sonProblem,n);
    }

    public int climbP(ArrayList<Integer> result,int n){
        if(result.size()>=n+1){
            return result.get(n);
        }else{
            int tempt=climbP(result,n-1)+climbP(result,n-2);
            result.add(n,tempt);
            return tempt;
        }
    }
    public static void main(String[] args){
        ArrayList<Integer> list=new ArrayList<>();
        //System.out.println(list.get(2));
        System.out.println(new ClimbStairs().climbStairsP(3));
    }
}
