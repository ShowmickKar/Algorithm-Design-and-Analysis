class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        compliment = {}
        
        for i in range(len(nums)):
            if target - nums[i] in compliment:
                return [compliment[target - nums[i]], i]
            else:
                compliment[nums[i]] = i
        print(compliment)
