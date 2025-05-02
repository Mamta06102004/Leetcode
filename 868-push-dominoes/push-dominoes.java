class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int time = Integer.MAX_VALUE;

        // right force
        for(int i = 0; i < n; i++){
            if(dominoes.charAt(i) == 'R'){
                time = 0;
                right[i] = time;
            } 
            else if(dominoes.charAt(i) == '.'){
                if(time != Integer.MAX_VALUE){
                    time++;
                    right[i] = time;
                } 
                else{
                    right[i] = Integer.MAX_VALUE;
                }
            } 
            else{ // L
                time = Integer.MAX_VALUE;
                right[i] = Integer.MAX_VALUE;
            }
        }

        // Left force
        time = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--){
            if(dominoes.charAt(i) == 'L'){
                time = 0;
                left[i] = time;
            }
            else if(dominoes.charAt(i) == '.'){
                if(time != Integer.MAX_VALUE){
                    time++;
                    left[i] = time;
                } else {
                    left[i] = Integer.MAX_VALUE;
                }
            } else { // R
                time = Integer.MAX_VALUE;
                left[i] = Integer.MAX_VALUE;
            }
        }

        // Final result
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            if (left[i] == right[i]) {
                ans[i] = dominoes.charAt(i); // Could be '.', 'R', or 'L'
            } else if (left[i] < right[i]) {
                ans[i] = 'L';
            } else if (right[i] < left[i]) {
                ans[i] = 'R';
            }
        }
        return new String(ans);

    }
}