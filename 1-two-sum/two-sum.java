class pair implements Comparable<pair>{
    int num;
    int idx;
    pair(int a, int b){
        num = a;
        idx = b;
    }
    public int compareTo(pair o){
        return this.num-o.num;
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        pair[] arr = new pair[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i] = new pair(nums[i],i);
        }

        Arrays.sort(arr);

        
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            int left = arr[i].num;
            int right = arr[j].num;
            int sum = left + right;
            if(sum == target){
                return new int[]{arr[i].idx , arr[j].idx};
            }
            else if(sum < target){
                i++;
            }
            else{
                j--;
            }
        }
        return new int[2];

    }
}