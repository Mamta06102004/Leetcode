class Solution {
    public void sortColors(int[] nums) {
        
        int[] count = new int[3];

        for(int i=0; i<nums.length; i++){
            int val = nums[i];
            count[val]++;
        }

        int k = 0;
        for(int i=0; i<3; i++){
            int c = count[i];
            for(int j=0; j<c; j++){
                nums[k++] = i;
                
            }
        }

    }
}