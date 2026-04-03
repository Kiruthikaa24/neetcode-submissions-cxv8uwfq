class Solution {
    public int uniquePaths(int m, int n) {
        //https://chatgpt.com/share/68ebc7af-ca08-8009-be09-88d141890e52
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[j] += dp[j + 1];
            }
        }

        return dp[0];
    }
}
