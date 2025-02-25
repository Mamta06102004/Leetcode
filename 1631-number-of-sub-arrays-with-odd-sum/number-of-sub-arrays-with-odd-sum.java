class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int countOdd = 0, countEven = 1; 
        int prefixSum = 0, result = 0;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {
                result = (result + countOdd) % MOD;
                countEven++;
            } else {
                result = (result + countEven) % MOD;
                countOdd++;
            }
        }

        return result;
    }
}