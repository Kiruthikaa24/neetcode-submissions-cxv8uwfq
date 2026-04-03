class Solution {
    public String minWindow(String s, String t) {
      
        //edge case
        if(s==null || t==null || s.length()==0 || t.length()==0 || s.length()<t.length())
        {
            return "";
        }
        //map[c] keeps track of how many times each character in t is needed.

//count keeps track of how many characters are still needed in the current window.
        int[] map=new int[128];
        int count=t.length();
        int left=0;
        int right=0;
        int minlen=Integer.MAX_VALUE;
        int startindex=0;
    //For each character in t, increase its count in map.
//Example: if t = "AABC", then map['A'] = 2, map['B'] = 1, map['C'] = 1.
        for(char c:t.toCharArray())
        {
            map[c]++;
        }
//Converts s to a character array for faster access.
        char[] chs=s.toCharArray();
//Expand the right end of the window: right++.
//If the current character chs[right] is in t (its count in map > 0), decrease count because we found one required character.
//map[chs[right]]-- always decreases the count in the map (even if it’s negative).
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
    


