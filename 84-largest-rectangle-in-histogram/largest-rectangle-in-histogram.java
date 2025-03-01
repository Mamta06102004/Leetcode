class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for(int i = 0; i<=heights.length; i++){
            int temp = 0;
            if(i != heights.length) temp = heights[i];
            while(s.size()>0 && temp < heights[s.peek()]){
                int tbs = s.pop();
                int nsr = i;
                int x1 = nsr-1;
                int nsl = -1;
                if(s.size() != 0) nsl = s.peek();
                int x2 = nsl+1;
                int area = heights[tbs] * (x1 -x2 +1);
                ans = Math.max(ans,area);
            }
            s.push(i);
        }
        return ans;

    }
}