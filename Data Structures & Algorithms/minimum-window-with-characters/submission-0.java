class Solution {
    public String minWindow(String s, String t) {
        //edge case
        if(s==null || t==null || s.length()==0 || t.length()==0 || s.length()<t.length())
        {
            return "";
        }
        int[] map=new int[128];
        int count=t.length();
        int left=0;
        int right=0;
        int minlen=Integer.MAX_VALUE;
        int startindex=0;

        for(char c:t.toCharArray())
        {
            map[c]++;
        }

        char[] chs=s.toCharArray();

        while(right<chs.length)
        {
            if(map[chs[right++]]-->0)
            {
                count--;
            }
            while(count==0)
            {
                if(right-left<minlen)
                {
                    startindex=left;
                    minlen=right-left;
                }

            if(map[chs[left++]]++==0)
            {
                count++;
            }
        }
    }
    return minlen==Integer.MAX_VALUE?"":new String(chs,startindex,minlen);

    }
}
    
