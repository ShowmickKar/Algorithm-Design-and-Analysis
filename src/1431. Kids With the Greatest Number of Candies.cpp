class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        int m = -1;
        for (int i = 0; i < candies.size(); i++) {
            m = max(m, candies[i]);
        }
        vector<bool> flag(candies.size());
        for (int i = 0; i < candies.size(); i++) {
            if (candies[i] + extraCandies >= m) {
                flag[i] = true;
            }
            else flag[i] = false;
        }
        return flag;
    }
};
