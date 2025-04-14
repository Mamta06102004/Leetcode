class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int stone : stones){
            map.put(stone, new HashSet<>());
        }
        map.get(stones[0]).add(1);
        for(int i=0; i<stones.length-1; i++){
            int st = stones[i];
            HashSet<Integer> jumps = map.get(st);
            for(int k : jumps){
                int validst = st + k;
                if(validst == stones[stones.length-1]) return true;
                if(map.containsKey(validst)){
                    if(k-1 > 0) map.get(validst).add(k-1);
                    map.get(validst).add(k);
                    map.get(validst).add(k+1);
                }
            }
        }
        return false;
    }
}