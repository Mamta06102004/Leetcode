class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); 
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int k = set.size();
        int count = 0;

        for(int sp=0; sp<nums.length; sp++){
            HashSet<Integer> set2 = new HashSet<>();   
            for(int ep=sp; ep<nums.length; ep++){
                set2.add(nums[ep]);
                if(set2.size() == k){
                    count += nums.length - ep;
                    break;
                }
            }
        }
        return count;
    }
}