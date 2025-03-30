class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        
        // Step 1: Store the last occurrence of each character
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        
        // Step 2: Partition the string
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex.get(s.charAt(i))); // Expand the partition
            
            if (i == end) { // If the current index reaches the end of partition
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        
        return result;
    }
}