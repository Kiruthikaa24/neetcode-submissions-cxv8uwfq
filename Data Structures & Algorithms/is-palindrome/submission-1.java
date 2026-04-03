class Solution {
    public boolean isPalindrome(String s) {
        s=s.replaceAll("[^a-zA-Z0-9]", "");
        s=s.toLowerCase();
        String rev="";
        for(int i=0;i<s.length();i++)
        {
            rev=s.charAt(i)+rev;
        }
        if(s.equals(rev))
        {
            return true;
        }
        return false;
    }
}
