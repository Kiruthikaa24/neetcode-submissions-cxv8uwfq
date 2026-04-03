/*
https://chatgpt.com/c/68fbc93c-d774-8321-8584-de5a2e612077 */
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int xor=n;
        for(int i=0;i<n;i++)
        {
            xor^=i^nums[i];
        }
        return xor;
    }
}
