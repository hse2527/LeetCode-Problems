public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int prev = 1;

        if((n & prev) != 0) count++;
        for(int i = 1; i <= 31; i++){
            prev = prev * 2;
            if((n & prev) != 0) count++;
        }
        return count;
    }
}