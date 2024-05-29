class Solution(object):
    def containsDuplicate(self, nums):
        m = set()
        for item in nums:
            if item in m:
                return True
            m.add(item)
        return False