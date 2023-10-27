public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i <= 31; i++){
            if((n & (long)Math.pow(2,i)) != 0) count++;
        }
        return count;
    }
}