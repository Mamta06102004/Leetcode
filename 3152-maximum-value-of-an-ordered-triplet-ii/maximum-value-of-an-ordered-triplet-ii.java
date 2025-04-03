class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] pmax = pfunc(nums);
        int[] smax = sfunc(nums);
        long max = Long.MIN_VALUE;

        for(int j=1; j<n-1; j++){
            long ans = (long)(pmax[j-1]-nums[j])*(long)smax[j+1];
            max = Math.max(max, ans);
        }
        if(max<0){
            return 0L;
        }
        else{
            return max;
        }
    }
    public int[] pfunc(int[] arr){
        int[] ans = new int[arr.length];
        ans[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            ans[i] = Math.max(arr[i], ans[i-1]);
        }
        return ans;
    }
    public int[] sfunc(int[] arr){
        int[] ans = new int[arr.length];
        ans[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--){
            ans[i] = Math.max(arr[i], ans[i+1]);
        }
        return ans;
    }
}