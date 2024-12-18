class Solution {
    public int[] finalPrices(int[] prices) {
        int i=0;
        while(i<prices.length){
            int j=i+1;
            while(j<prices.length){
            if(j>i && prices[j]<=prices[i]){
                prices[i]=prices[i]-prices[j];
                break;
            }
            j++;
          }
          i++;
        }
        return prices;
    }
}