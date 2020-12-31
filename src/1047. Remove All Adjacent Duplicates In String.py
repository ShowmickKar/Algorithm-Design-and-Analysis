# Problem Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

class Solution:
    def removeDuplicates(self, S: str) -> str:
        ans = "*"
        flag = True
        while flag:
            for c in S:
                if ans[-1] != c:
                    ans += c
                else:
                    ans = ans[:-1]
                    flag = False
            c = ans[1:]
            ans = "*"
        return c
