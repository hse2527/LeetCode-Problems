class Solution {
    int[] possRoute;
    public int climbStairs(int n) {
        possRoute = new int[n + 1];
        possRoute[1] = 1;
        if(n >= 2) possRoute[2] = 2;
        return recurrence(n);
    }

    private int recurrence(int index) {
        if(possRoute[index] != 0) return possRoute[index];
        possRoute[index] = recurrence(index - 2) + recurrence(index - 1);
        return possRoute[index];
    }
}