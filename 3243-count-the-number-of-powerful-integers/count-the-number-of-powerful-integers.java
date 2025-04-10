class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        return countPowerfulUpTo(finish, limit, s) - countPowerfulUpTo(start - 1, limit, s);
    }

    private long countPowerfulUpTo(long cap, int limit, String suffix) {
        String capStr = Long.toString(cap);
        int prefixLen = capStr.length() - suffix.length();

        // If number is shorter than suffix, there can't be a valid match
        if (prefixLen < 0) return 0;

        long[][] dp = new long[prefixLen + 1][2]; // dp[pos][tight]: number of ways

        // Base case: at the position where suffix would begin
        dp[prefixLen][0] = 1; // No tight constraint
        dp[prefixLen][1] = capStr.substring(prefixLen).compareTo(suffix) >= 0 ? 1 : 0;

        // Fill dp table in reverse
        for (int i = prefixLen - 1; i >= 0; i--) {
            int currentDigit = capStr.charAt(i) - '0';

            // Case 1: No tight constraint => use any digit from 0 to limit
            dp[i][0] = (limit + 1) * dp[i + 1][0];

            // Case 2: Still under tight constraint
            if (currentDigit <= limit) {
                dp[i][1] = (long) currentDigit * dp[i + 1][0] + dp[i + 1][1];
            } else {
                dp[i][1] = (long) (limit + 1) * dp[i + 1][0];
            }
        }

        return dp[0][1];
    }
}