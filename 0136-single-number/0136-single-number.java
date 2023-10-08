class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) if(!set.add(i)) set.remove(i);
        return (Integer)(set.toArray()[0]);
    }
}