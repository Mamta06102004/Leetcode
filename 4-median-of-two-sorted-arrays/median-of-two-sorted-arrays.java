class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }

        int lo = 0;
        int hi = n1;
        int t = n1 + n2;
        while(lo <= hi){
            int m1 = (lo + hi)/2;
            int m2 = (t+1)/2 - m1;
            int am = (m1 == nums1.length) ? Integer.MAX_VALUE : nums1[m1];
            int amm1 = (m1 == 0) ? Integer.MIN_VALUE : nums1[m1-1];
            int bm = (m2 == nums2.length) ? Integer.MAX_VALUE : nums2[m2];
            int bmm1 = (m2 == 0) ? Integer.MIN_VALUE : nums2[m2-1];

            if(amm1 <= bm && bmm1 <= am){
                if(t%2 != 0){               //odd len
                    return Math.max(amm1, bmm1);
                }
                else{                       //even len
                    double lmax = Math.max(amm1, bmm1);
                    double rmin = Math.min(am, bm);
                    return (lmax + rmin)/2;
                    
                }
            }
            else if(amm1 > bm){
                hi = m1 - 1;
            }
            else if(bmm1 > am){
                lo = m1 + 1;
            } 
        }
        return 0.0;
    }
}