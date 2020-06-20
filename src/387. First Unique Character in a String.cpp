Problem link: https://leetcode.com/problems/first-unique-character-in-a-string/

class Solution {
public:
    int firstUniqChar(string s) {
        int ans = s.length();
        unordered_map<char, pair<int, int>> m;
        for (int i = 0; i < s.length(); ++i) {
            m[s[i]].first = i;
            m[s[i]].second++;
        }
        for (auto &u : m) {
            if (u.second.second == 1) {
                if (u.second.first < ans) {
                    ans = u.second.first;
                }
             }
        }
        return (ans == s.length() ? -1 : ans);
    }
};
    
    
