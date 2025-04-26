class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long count = 0, equals = 0;
        Map<Integer, Long> mpp = new HashMap<>();
        mpp.put(0, 1L);
        for (int i : nums) {
            if (i % modulo == k) equals++;
            int rem = (int)(equals % modulo);
            int needed = (rem - k + modulo) % modulo;
            count += mpp.getOrDefault(needed, 0L);
            mpp.put(rem, mpp.getOrDefault(rem, 0L) + 1);
        }
        return count;
        // int res = 0;
        // for (int i = 0; i < nums.size(); i++) {
        //     int cnt = 0;
        //     for (int j = i; j < nums.size(); j++) {
        //         if (nums.get(j) % modulo == k) cnt++;
        //         if (cnt % modulo == k) res++;
        //     }
        // }
        // return res;
        // HashSet<Integer> set = new HashSet<>(); 
        // for(int i=0; i<nums.size(); i++){
        //     set.add(nums[i]);
        // }
        // int k = set.size();
        // int count = 0;

        // for(int sp=0; sp<nums.length; sp++){
        //     HashSet<Integer> set2 = new HashSet<>();   
        //     for(int ep=sp; ep<nums.length; ep++){
        //         set2.add(nums[ep]);
        //         if(set2.size() == k){
        //             count++;
        //             // count += nums.length - ep;
        //             // break;
        //         }
        //     }
        // }
        // return count;
    }
}