class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }
        
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;
        
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                int ai = arr[k] - arr[j];
                if (ai >= arr[j] || !indexMap.containsKey(ai)) continue;
                
                int i = indexMap.get(ai);
                int len = dp.getOrDefault(i * n + j, 2) + 1;
                dp.put(j * n + k, len);
                maxLen = Math.max(maxLen, len);
            }
        }
        
        return maxLen >= 3 ? maxLen : 0;
    }
}