class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 0, right = (long) ranks[0] * (long) cars * (long) cars; // Upper bound
        long answer = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (canRepairAllCars(ranks, cars, mid)) {
                answer = mid;
                right = mid - 1; // Try to minimize the time
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }

    public boolean canRepairAllCars(int[] ranks, int cars, long timeLimit) {
        long totalCars = 0;
        for (int rank : ranks) {
            totalCars += (long) Math.sqrt(timeLimit / rank);
            if (totalCars >= cars) return true; // No need to check further
        }
        return totalCars >= cars;
    }
}