class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int try1 = tops[0];
        int flips1Top = 0;
        int flips1Bottom = 0;
        boolean possible1 = true;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != try1 && bottoms[i] != try1) {
                possible1 = false;
                break;
            } else {
                if (tops[i] != try1) flips1Top++;
                if (bottoms[i] != try1) flips1Bottom++;
            }
        }

        int try2 = bottoms[0];
        int flips2Top = 0;
        int flips2Bottom = 0;
        boolean possible2 = true;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != try2 && bottoms[i] != try2) {
                possible2 = false;
                break;
            } else {
                if (tops[i] != try2) flips2Top++;
                if (bottoms[i] != try2) flips2Bottom++;
            }
        }

        int result = -1;
        if (possible1 == true) result = Math.min(flips1Top, flips1Bottom);
        if (possible2 == true) {
            int flips = Math.min(flips2Top, flips2Bottom);
            if (result == -1 || flips < result) result = flips;
        }
        return result;
    }
}