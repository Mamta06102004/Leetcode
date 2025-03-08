class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int numStr = n-k+1;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<numStr; i++){
            int count = 0;
            int idx = i;
            for(int j=0; j<k; j++){
                if(blocks.charAt(idx) == 'W'){
                    count++;
                }
                idx++;
            }
            ans = Math.min(ans, count);
        }
        return ans;
    }
}