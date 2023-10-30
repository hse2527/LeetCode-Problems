class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        for(int i = 0; i < 26; i++) count[i] = -1;
        for(char c : s1.toCharArray()) {
            if(count[c - 'a'] == -1) count[c - 'a'] = 0;
            count[c-'a']++;
        }
        int a = 0;
        int b = 0;
        while(b < s2.length()) {
            if(b - a == s1.length()) return true;
            if(count[s2.charAt(b) - 'a'] == 0) {
                while(count[s2.charAt(b) - 'a'] == 0) {
                    count[s2.charAt(a) - 'a']++;
                    a++;
                }
                count[s2.charAt(b) - 'a']--;
                b++;
            } else if (count[s2.charAt(b) - 'a'] == -1) {
                if(count[s2.charAt(a) - 'a'] != -1) {
                    while(a != b) {
                        count[s2.charAt(a) - 'a']++;
                        a++;
                    }
                    a++;
                } else {
                    a++;
                }
                b++;
            } else {
                count[s2.charAt(b) - 'a']--;
                b++;
            }
        }
        return (b - a == s1.length()) ? true : false;
    }
}