Problem link: https://leetcode.com/problems/product-of-array-except-self/

class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> left_product(n), right_product(n), final_product(n);
        right_product[0] = 1;
        left_product[n - 1] = 1;
        for (int i = 0; i < n - 1; i++) {
            right_product[i + 1] = right_product[i] * nums[i];
            left_product[n - i - 2] = left_product[n - i - 1] * nums[n - i - 1];
        }
        for (int i = 0; i < n; i++) {
            final_product[i] = left_product[i] * right_product[i];
        }
        return final_product;
    }
};
