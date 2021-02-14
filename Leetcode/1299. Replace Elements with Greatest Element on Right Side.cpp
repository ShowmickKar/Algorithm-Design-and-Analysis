Problem link: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

class Solution {
public:
    vector<int> replaceElements(vector<int>& arr) {
        int m = arr[arr.size() - 1];
        vector <int> a;
        for(int i = arr.size() - 2; i >= 0; i--){
            m = max(m, arr[i + 1]);
            a.push_back(m);
        }
        reverse(a.begin(), a.end());
        a.push_back(-1);
        return a;
    }
};
