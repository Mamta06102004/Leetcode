class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,ArrayList<Integer>> hmap = new HashMap<>();

        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        
        //put the mapping in HashMap and calculate inDegree
        
        
        for(int[] p : prerequisites){
            int start = p[1];
            int end = p[0];
            
            inDegree[end]++;

            if(!hmap.containsKey(start)){
                hmap.put(start , new ArrayList<Integer>());
            }
            hmap.get(start).add(end);
            
        }
        
        for(int i = 0 ; i < inDegree.length ; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int removed = q.poll();
            
            if(hmap.containsKey(removed)){
                for(int r : hmap.get(removed)){
                    inDegree[r]--;
                    if(inDegree[r] == 0){
                        q.add(r);
                    }
                }
            }
            numCourses--;
        }
        
        return numCourses == 0;
    }
}