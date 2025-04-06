class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //1. Larger % Smaller can be 0 (not s%l) --> Sort the array
        //2. if [a,b,c], b%a=0 & c%b=0 then -> c%a will be 0
        //3. Same as --Longest Increasing Subsequence(O(n2))

        List<Integer> ans = new ArrayList<>();
        if(nums.length == 1){
            ans.add(nums[0]);
            return ans;
        } 

        int[] lislen = new int[nums.length];
        int[] previndex = new int[nums.length];
        Arrays.fill(lislen, 1);
        Arrays.fill(previndex, -1);
        int maxlen = 0, index = -1;
        Arrays.sort(nums);

        for(int i=1; i<nums.length; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[i] % nums[j] == 0 && 1 + lislen[j] > lislen[i]){
                    lislen[i] = lislen[j] + 1;
                    previndex[i] = j;
                }
            }
            if(lislen[i] > maxlen){
                maxlen = lislen[i];
                index = i;
            }
        }
        while(index != -1){
            ans.add(nums[index]);
            index = previndex[index];
        }

        return ans;
    }
}