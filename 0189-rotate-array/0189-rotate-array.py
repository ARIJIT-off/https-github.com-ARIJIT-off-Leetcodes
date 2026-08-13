class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
      n = len(nums)
      if k>n:
         k= k % n
      nums[:] = nums[(n-k):]+nums[:(n-k)]
      return nums