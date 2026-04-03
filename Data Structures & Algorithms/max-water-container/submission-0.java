class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;
        int left=0;
        int right=n-1;
        int area=0;
        int result=0;
        while(left<right)
        {
            area=Math.min(heights[left],heights[right])*(right-left);
            result=Math.max(area,result);
            if(heights[left]<heights[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return result;
    }
}
