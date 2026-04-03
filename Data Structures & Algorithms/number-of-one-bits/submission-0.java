class Solution {
    public int hammingWeight(int n) {
        int res=0;
        for(int i=0;i<32;i++)
        {
            //1<<i- means left shift 1 by i position and 
            //perform operation on that and n
            //if its 1, then increment it and return count
            if((1<<i & n)!=0)
            {
                res++;
            }
        }
        return res;
    }
}
