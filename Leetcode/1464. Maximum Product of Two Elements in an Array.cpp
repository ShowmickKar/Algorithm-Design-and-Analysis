// Problem link: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
// Problem Difficulty: Easy
// Runtime: 8 ms, faster than 95.87% of C++ online submissions for Maximum Product of Two Elements in an Array.
// Memory Usage: 10 MB, less than 49.44% of C++ online submissions for Maximum Product of Two Elements in an Array.

class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int product = 1, m = -1, index;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] > m) {
                index = i;
                m = nums[i];
            }
        }
        product *= m - 1;
        m = -1;
        for (int i = 0; i < nums.size(); ++i) {
            if (i == index) continue;
            m = max(m, nums[i]);
        }
        product *= m - 1;
        return product;
    }
};
