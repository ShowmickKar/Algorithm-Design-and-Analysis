problem link: https://leetcode.com/problems/destination-city/

/* Solution 1 using unordered set *********
 * faster than 44.34% of C++ online submissions */

class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        string destinationCity;
        unordered_set<string> x, y;
        for (auto &u : paths) {
            x.insert(u[0]);
            y.insert(u[1]);
        }
        for (auto &u : y) {
            if (!count (x.begin(), x.end(), u)) {
                destinationCity = u;
                break;
            }
        }
        return destinationCity;
    }
};

/* Solution 2 using unordered map ************
 * Faster than 99.01% C++ submissions */
 
class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        string destinationCity;
        unordered_map<string, int> m;
        for (auto &u : paths) {
            m[u[0]]--;
            m[u[1]]++;
        }
        for (auto &u: m) {
            if (u.second > 0) {
                destinationCity = u.first;
                break;
            }
        }
        return destinationCity;
    }
};
