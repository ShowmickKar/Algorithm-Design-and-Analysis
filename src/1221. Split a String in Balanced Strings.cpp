Problem link: https://leetcode.com/problems/split-a-string-in-balanced-strings/

class Solution {
public:
    int balancedStringSplit(string s) {
        int count = 0, l = 0, r = 0;
        for(int i = 0; i < s.length(); i++){
            if(s[i] == 'R') r++;
            else l++;
            if(r == l){
                count++;
                l = 0;
                r = 0;
            }
        }
        return count;
    }
};
