class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = -1;
        for(int i=n-1; i>=0; i--){
            if(map.containsKey(nums[i])){
                return i/3 + 1;
            }
            else{
                map.put(nums[i], 1);
            }
        }
        return 0;
    }
}