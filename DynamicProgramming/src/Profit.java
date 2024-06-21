public class Profit {
    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int maxP=0;
        int tempP=0;
        for (int i=0;i<prices.length;i++){
            for (int j=i+1;j<prices.length;j++){
                tempP=prices[j]-prices[i];
                if(tempP>maxP){
                    maxP=tempP;
                }
            }
        }
        return maxP;
    }
}
