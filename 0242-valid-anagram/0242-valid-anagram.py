class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        dup = [0 for x in range(26)]
        if len(s) != len(t):
            return False
        for a in s:
            dup[ord(a) - ord('a')] += 1
        for a in t:
            if dup[ord(a) - ord('a')] == 0:
                return False
            dup[ord(a) - ord('a')] -= 1
        return True
        