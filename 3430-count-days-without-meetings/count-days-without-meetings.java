class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int nonMeetingDays = 0;
        int lastEnd = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            // Count the gap before the current meeting starts
            if (start > lastEnd + 1) {
                nonMeetingDays += start - lastEnd - 1;
            }

            // Update the end of the last merged interval
            lastEnd = Math.max(lastEnd, end);
        }

        // Check for non-meeting days after the last meeting
        if (lastEnd < days) {
            nonMeetingDays += days - lastEnd;
        }

        return nonMeetingDays;
    }
}