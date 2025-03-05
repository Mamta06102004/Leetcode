class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<k; i++){
            while(dq.size()>0 && nums[i]>dq.getLast()){
                dq.removeLast();
            }
            dq.addLast(nums[i]);
        }
        ans[0] = dq.getFirst();
        int idx = 1;
        for(int j=k; j<nums.length; j++){
            //insert ith element
            while(dq.size()>0 && nums[j]>dq.getLast()){
                dq.removeLast();
            }
            dq.addLast(nums[j]);

            //remove i-k th element
            if(dq.getFirst() == nums[j-k]){
                dq.removeFirst();
            }

            ans[idx] = dq.getFirst();
            idx++;
        }
        return ans;
    }
}