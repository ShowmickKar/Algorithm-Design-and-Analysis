Problem link: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
Problem Difficulty: Medium

class Solution {
    bool check_vowel(char x) {
        return (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u');
    }
    
public:
    int maxVowels(string s, int k) {
        int m = 0, p = 0, n;
        n = s.length();
        for (int i = 0; i < n; ++i) {
            if (check_vowel(s[i])) {
                s[i] = '1';
                if (i < k) ++p;
            }
            else s[i] = '0';
        }
        int i = 0, j = k - 1;
        while(j < n) {
            if (i == 0) {
                m = p;
                ++i;
                ++j;
            }
            else {
                if (s[i - 1] == '1') --p;
                if (s[j] == '1') ++p;
                m = max(m, p);
                ++i;
                ++j;
            }
        }
        return m;
    }
};
