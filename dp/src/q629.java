class q629 {

    // 很好的解法 https://leetcode.com/problems/k-inverse-pairs-array/discuss/104815/Java-DP-O(nk)-solution
    // 当对已知的一行数插入一个比他们都大的数时，遍历所有可以插入的位置。dp[n][k]状态为n个数k个pair的数列可能个数
    // 放在第一位则产生n-1个pair，则所求组合数就为未放入的数列的k-(n-1)个pair的情况dp[n-1][k-(n-1)]
    // 放在第二位就是dp[n-1][k-(n-2)]....
    // 所以dp[n][k] = dp[n-1][k-(n-1)] + dp[n-1][k-(n-2)] + ... dp[n-1][k]
    // dp[n][k-1] = dp[n-1][k-1 -(n-1)] +...+ dp[n-1][k-1]
    // 上式减下式 dp[n][k] =  dp[n][k-1] + dp[n-1][k] - dp[n-1][k-n]
    public int kInversePairs(int n, int k) {
        if (k == 0) return 1;
        if (k > n * (n - 1) / 2 || k < 0 || n <= 1) return 0;
        long[][] dp = new long[n + 1][k + 1];
        dp[2][1] = 1;
        dp[2][0] = 1;
        int mod = 1000000007;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(k, n * (n - 1) / 2); j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (j - i >= 0) dp[i][j] -= dp[i - 1][j - i];
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        return (int) dp[n][k];
    }


}