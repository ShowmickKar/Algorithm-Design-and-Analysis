# Problem Link: https://leetcode.com/problems/trapping-rain-water/


# Solution Using Dynamic Programming

class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) < 3:
            return 0
        left_tracker = [0] * len(height)
        right_tracker = [0] * len(height)
        m = 0
        for i in range(1, len(height)):
            m = max(m, height[i - 1])
            left_tracker[i] = m
        m = 0
        for i in range(len(height) - 2, 0, -1):
            m = max(m, height[i + 1])
            right_tracker[i] = m
        ans = 0
        for i in range(len(height)):
            if min(left_tracker[i], right_tracker[i]) > height[i]:
                ans += min(left_tracker[i], right_tracker[i]) - height[i]
        return ans
