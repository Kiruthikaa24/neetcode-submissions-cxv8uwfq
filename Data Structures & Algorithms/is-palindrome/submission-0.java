class Solution {
    public boolean isPalindrome(String s) {
        s= s.replaceAll("[^a-zA-Z0-9]", "");
        s=s.toLowerCase();
        String reverse="";
        for(int i=0;i<s.length();i++)
        {
            reverse=s.charAt(i)+reverse;
        }
        if(s.equals(reverse))
        {
            return true;
        }
        return false;
        

    }
}
