class Solution {
    public int maxProfit(int[] prices) {
        int minprice = prices[0];
        int maxprofit=0;
        for(int price:prices){
            maxprofit=Math.max(maxprofit,price-minprice);
            minprice=Math.min(minprice,price);
        }
        return maxprofit;
    }
}
