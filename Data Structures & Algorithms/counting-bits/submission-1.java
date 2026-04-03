class Solution {
    public int[] countBits(int n) {
        /*If (i & 1) is 1, the last bit of i is set (binary ends with 1 → odd number).

If (i & 1) is 0, the last bit of i is not set (binary ends with 0 → even number).
*/
        /*the (i & 1) part tells us whether the last bit of i is 1.

If it’s 1 → add 1 to the count.

If it’s 0 → add 0.

That’s how it helps count the number of 1s efficiently. */
        int[] dp = new int[n + 1]; 
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
