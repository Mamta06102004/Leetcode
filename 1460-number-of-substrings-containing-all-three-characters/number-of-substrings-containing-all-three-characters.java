class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int[] freq = {0, 0, 0}; // Frequency array for 'a', 'b', 'c'
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;
            
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += s.length() - right;
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }
        
        return count;
    }
}