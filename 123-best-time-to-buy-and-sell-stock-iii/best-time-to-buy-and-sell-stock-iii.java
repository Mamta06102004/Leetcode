class Solution {
    public int maxProfit(int[] prices) {
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int maxP = 0;
        int minBP = prices[0];
    
        left[0] = 0;
        for(int i=1; i<prices.length; i++){
            int tp = prices[i] - minBP;
            maxP = Math.max(maxP, tp);

            minBP = Math.min(minBP, prices[i]);
            left[i] = maxP;
        }

        maxP = 0;
        int maxSP = prices[prices.length-1];
        right[prices.length-1] = 0;

        for(int i=prices.length-2; i>=0; i--){
            int tp = maxSP - prices[i];
            maxP = Math.max(maxP, tp);
            
            maxSP = Math.max(maxSP, prices[i]);
            right[i] = maxP;
        }

        int ans = 0;
        for(int i=0; i<prices.length; i++){
            ans = Math.max(ans, left[i] + right[i]);
        }
        return ans;

    }
}