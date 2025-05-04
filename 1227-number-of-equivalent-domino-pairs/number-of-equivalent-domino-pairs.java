class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;

        for(int[] d:dominoes){
            int a = d[0];
            int b = d[1];
            String pair;
            if (a <= b) {
                pair = a + "," + b;
            } 
            else {
                pair = b + "," + a;
            }

            count += map.getOrDefault(pair, 0);
            map.put(pair, map.getOrDefault(pair, 0)+ 1);
        }

        return count;
    }
}