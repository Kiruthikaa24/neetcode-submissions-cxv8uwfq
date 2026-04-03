class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash=new int[26];
        int left=0,right=0;
        int maxfreq=0;
        int maxlen=0;
        while(right<s.length())
        {
            hash[s.charAt(right)-'A']++;
            maxfreq=Math.max(maxfreq,hash[s.charAt(right)-'A']);
            int windowsize=right-left+1;
            int charstochange=windowsize-maxfreq;
            if(charstochange>k)
            {
                hash[s.charAt(left)-'A']--;
                left++;
            }
            maxlen=Math.max(maxlen,right-left+1);
            right++;
        }
        return maxlen;
    }
}
