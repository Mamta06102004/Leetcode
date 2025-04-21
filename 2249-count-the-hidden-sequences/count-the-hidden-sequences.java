class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long a = 0, maxima = 0, minima = 0;
        for (int i = 0; i < differences.length; i++) {
            a += differences[i];
            maxima = Math.max(maxima, a);
            minima = Math.min(minima, a);
        }
        return (int) Math.max(0, (upper - lower) - (maxima - minima) + 1);
    }
}