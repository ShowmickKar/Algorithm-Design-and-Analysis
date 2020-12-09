Problem Link: https://leetcode.com/problems/sort-array-by-increasing-frequency/

class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        frequency = {}
        HashTable = {}
        
        ans = []
        
        for i in nums:
            if i in frequency:
                frequency[i] += 1
            else:
                frequency[i] = 1
                
        for key in frequency:
            if frequency[key] in HashTable:
                HashTable[frequency[key]].append(key)
            else:
                HashTable[frequency[key]] = [key]
                
        for key in HashTable:
            HashTable[key] = sorted(HashTable[key], reverse= True)
            
        index_tracking = sorted(HashTable)
        
        for key in index_tracking:
            for num in HashTable[key]:
                for i in range(key):
                    ans.append(num)                    
        return ans
