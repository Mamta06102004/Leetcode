class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for(int i=0; i<n-1; i++){
            List<int[]> ans = countfreq(result);  
            result = lsToStr(ans);
        }
        return result;
    }
    public List<int[]> countfreq(String s){
        List<int[]> ans = new ArrayList<>();
        int count = 1;

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }
            else{
                ans.add(new int[]{s.charAt(i-1) -'0', count});
                count = 1;
            }
        }
        ans.add(new int[]{s.charAt(s.length()-1)-'0', count});
        return ans;
    }

    public String lsToStr(List<int[]> li){
        StringBuilder sb = new StringBuilder();

        for(int[] pair : li){
            int digit = pair[0];
            int count = pair[1];
            sb.append(count);
            sb.append(digit);
        }
        String s = sb.toString();
        return s;
    }
}