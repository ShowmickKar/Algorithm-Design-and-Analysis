Problem link: https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
Problem difficulty: Medium

/*** Solution Detail **/
 * Time Complexity: O(N) // Using Hashtable
 * Space Complexity: O(N) // In the worst case
 * Runtime: 20 ms, faster than 86.99% of C++ online submissions for Group the People Given the Group Size They Belong To.
 * Memory Usage: 13.1 MB, less than 74.21% of C++ online submissions for Group the People Given the Group Size They Belong To. 
 */

/*** Solution Idea **/
 * Use a hashtable to store the group sizes as keys and arrays of ID's of people having certain group sizes as values.
 * Iterate the hashtable and store the ID's of people in seperate arrays depending on their group sizes.
 * Finally push the arrays to the final array that you are going to return.
 */
 
class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        int temp;
        vector<vector<int>> ans;
        unordered_map<int, vector<int>> m;
        vector<int> assistant;
        for (int i = 0; i < groupSizes.size(); ++i) {
            m[groupSizes[i]].push_back(i);
        }
        for (auto &u : m) {
            for (int i = 0; i < u.second.size(); ++i) {
                for (int j = i; j < i + u.first; ++j) {
                    assistant.push_back(u.second[j]);
                    temp = j;
                }
                ans.push_back(assistant);
                assistant.clear();
                i = temp;
            }
        }
        return ans;
    }
};
