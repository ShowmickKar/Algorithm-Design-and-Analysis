# Problem Link: https://leetcode.com/problems/partition-labels/

# Time Complexity: O(N)
# Space Complexity O(1) // A dictionary of maximum size 26 is used
# Runtime: 28 ms, faster than 98.83% of Python3 online submissions for Partition Labels.

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        arr = []
        position = {}
        for i in range(len(s)):
            if s[i] in position:
                position[s[i]][1] = i
            else:
                position[s[i]] = [i, i]
        l = 0
        u = position[s[0]][1]
        for i in range(len(s)):
            if i == u:
                arr.append(u - l + 1)
                l = i + 1
                u = position[s[i + 1]][1] if i + 1 < len(s) else None
            elif position[s[i]][1] > u:
                u = position[s[i]][1]
        return arr
