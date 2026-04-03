class Solution {
    public boolean isAnagram(String s, String t) {
/*We do two operations in one single loop:

Increment the count for character in s

Decrement the count for character in t

🎯 Why this works

If both strings have the same characters in the same quantity:

Every increment (+1 from s) will be cancelled by a decrement (-1 from t)

Final count for every letter will be 0 */
    if(s.length()!=t.length())
    {
        return false;
    }
    int[] count= new int[26];
    for(int i=0;i<s.length();i++)
    {
        count[s.charAt(i)-'a']++;
        count[t.charAt(i)-'a']--;
    }
    for(int val:count)
    {
        if(val!=0)
        {
            return false;
        }
    }
    return true;
    }
}
