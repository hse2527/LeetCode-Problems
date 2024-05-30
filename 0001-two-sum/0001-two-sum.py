class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        orig = copy.copy(nums)
        nums.sort()
        i, j = 0 , len(nums) - 1
        while i < j:
            current = nums[i] + nums[j]
            if current > target:
                j -= 1
            elif current == target:
                break
            else:
                i += 1
        a, b = -1, -1
        for ind, item in enumerate(orig):
            if item == nums[i] and a == -1:
                a = ind
            elif item == nums[j] and b == -1:
                b = ind
        return [a, b]