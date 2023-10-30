class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] orig = s1.toCharArray();
        Arrays.sort(orig);
        s1 = new String(orig);
        int a = 0;
        int b = s1.length();
        while(b <= s2.length()) {
            if(checkParts(s1, s2.substring(a, b).toCharArray())) return true;
            a++;
            b++;
        }
        return false;
    }

    public boolean checkParts(String orig, char[] comp) {
        Arrays.sort(comp);
        if(new String(orig).equals(new String(comp))) return true;
        return false;
    }
}