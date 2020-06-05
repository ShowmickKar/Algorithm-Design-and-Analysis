// Problem link: https://leetcode.com/problems/n-repeated-element-in-size-2n-array/

class Solution {
public:
    int repeatedNTimes(vector<int>& A) {
        int element;
        unordered_map<int, int> m;
        for (int i = 0; i < A.size(); i++) {
            m[A[i]]++;
        }
        for (auto &u : m) {
            if (u.second == A.size()/2 + A.size() % 2) {
                element = u.first;
                break;
            }
        }
        return element;
    }
};
