class Solution {
    private int hammingDistance(String s1, String s2) {
        int dist = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                dist++;
                if (dist > 1) return dist;  
            }
        }
        return dist;
    }
    
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups){
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;  
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] &&
                    words[i].length() == words[j].length() &&
                    hammingDistance(words[i], words[j]) == 1) {
                    
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
        }
        
        int maxLen = 0, maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }
        
        LinkedList<String> result = new LinkedList<>();
        int curr = maxIndex;
        while (curr != -1) {
            result.addFirst(words[curr]);
            curr = prev[curr];
        }
        return result;
    }
}