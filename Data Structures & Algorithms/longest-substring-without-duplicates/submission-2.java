class Solution {
    public int lengthOfLongestSubstring(String s) {
        //https://chatgpt.com/s/t_6906f2e8900c8191a61f780714726b4d
        HashSet<Character> set=new HashSet<>();
        int left=0;
        int maxlen=0;
        for(int right=0;right<s.length();right++)
        {
            while(set.contains(s.charAt(right)))
            {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxlen=Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}
