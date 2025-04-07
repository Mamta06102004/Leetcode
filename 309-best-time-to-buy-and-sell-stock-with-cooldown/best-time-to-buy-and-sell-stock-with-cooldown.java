class Solution {
    public int maxProfit(int[] prices) {
        int buy = -prices[0];
        int sell = 0;
        int cool = 0;

        for(int i=1; i<prices.length; i++){
            int nbuy = Math.max(buy, cool-prices[i]);
            int nsell = Math.max(sell, prices[i] + buy);
            cool = Math.max(sell, cool);

            buy = nbuy;
            sell = nsell;
        }

        return sell;
    }
}