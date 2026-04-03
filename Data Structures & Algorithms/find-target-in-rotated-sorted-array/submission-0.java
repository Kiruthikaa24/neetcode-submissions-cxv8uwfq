class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;

        while(l<=r)
        {
            int mid=(l+r)/2;
//If the middle element equals the target → return its index.
            if(nums[mid]==target)
            {
                return mid;
            }
            //If the left half (nums[l] to nums[mid]) is sorted…then check there
            if(nums[l]<=nums[mid])
            {
                //f the target is greater than mid OR smaller than the leftmost value, then the target must be in the right half → move l to mid + 1.
//Else, search in the left half → move r to mid - 1.
                if(target>nums[mid] || target<nums[l])
                {
                    l=mid+1;
                }
                else
                {
                    r=mid-1;
                }
            }
            //If the left side is not sorted, then the right half (nums[mid] to nums[r]) must be sorted.
            else
            {
                //If the target is less than mid OR greater than rightmost value, it’s not in the sorted right half → move r left.

//Otherwise, search in the right half → move l right.
                if(target<nums[mid] || target>nums[r])
                {
                    r=mid-1;
                }
                else
                {
                    l=mid+1;
                }
            }
        }
        return -1;
    }
}
