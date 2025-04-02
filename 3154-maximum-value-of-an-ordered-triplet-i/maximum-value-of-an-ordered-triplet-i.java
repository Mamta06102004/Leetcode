class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long max = Long.MIN_VALUE;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    long ans = (long)(nums[i]-nums[j])*(long)(nums[k]);
                    max = Math.max(max, ans);
                }
            }
        }
        if(max<0){
            return 0L;
        }
        else{
            return max;
        }
    }
}