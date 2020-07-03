Problem Link: https://leetcode.com/problems/partition-labels/
Problem difficulty: Medium

/*** Solution Detail **
 * Runtime - 4ms
 * Time Comlexity O(N)
 * Space Complexity: O(1) // a hashtable of maximum size 26 is used
 */
 
class Solution {
public:
    vector<int> partitionLabels(string s) {
        vector<int> partition;
        unordered_map<char, int> m;
        for (int i = 0; i < s.length(); ++i) {
            m[s[i]] = max(m[s[i]], i);
        }
        int upperbound = 0, lowerbound = 0, length;
        for (int i = 0; i < s.length(); ++i) {
            upperbound = max(upperbound, m[s[i]]);
            length = upperbound - lowerbound + 1;            
            if (i == upperbound) {
                partition.push_back(length);
                lowerbound = i + 1;
            } 
        }
        return partition;
    }
};
