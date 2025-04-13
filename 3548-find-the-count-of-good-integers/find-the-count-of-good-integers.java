class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<String> validSignatures = new HashSet<>();
        int half = (n + 1) / 2;
        long total = 0;

        // Generate all half-length permutations
        permute("", half, n, k, validSignatures);

        for (String sig : validSignatures) {
            total += countPermutations(sig, n);
        }

        return total;
    }

    // Generate palindromes and collect digit signatures
    private void permute(String path, int len, int fullLen, int k, Set<String> validSignatures) {
        if (path.length() == len) {
            String palindrome = buildPalindrome(path, fullLen % 2 == 1);
            if (palindrome.charAt(0) != '0') {
                long num = Long.parseLong(palindrome);
                if (num % k == 0) {
                    char[] chars = palindrome.toCharArray();
                    Arrays.sort(chars);
                    validSignatures.add(new String(chars));
                }
            }
            return;
        }

        for (char ch = '0'; ch <= '9'; ch++) {
            permute(path + ch, len, fullLen, k, validSignatures);
        }
    }

    // Build palindrome from half
    private String buildPalindrome(String half, boolean isOdd) {
        StringBuilder sb = new StringBuilder(half);
        if (isOdd) sb.setLength(sb.length() - 1);
        return half + sb.reverse().toString();
    }

    // Count permutations (no leading zero)
    private long countPermutations(String digits, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : digits.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        long total = 0;
        for (char first = '1'; first <= '9'; first++) {
            if (!freq.containsKey(first) || freq.get(first) == 0) continue;

            freq.put(first, freq.get(first) - 1);
            total += permutations(freq, n - 1);
            freq.put(first, freq.get(first) + 1);
        }

        return total;
    }

    // Calculate permutations with digit frequency
    private long permutations(Map<Character, Integer> freq, int remaining) {
        long numerator = factorial(remaining);
        for (int count : freq.values()) {
            numerator /= factorial(count);
        }
        return numerator;
    }

    // Precompute factorials up to 10
    private long factorial(int x) {
        long res = 1;
        for (int i = 2; i <= x; i++) {
            res *= i;
        }
        return res;
    }
}