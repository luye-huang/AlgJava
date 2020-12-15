public class q887 {
    /**
     * https://leetcode.com/problems/super-egg-drop/discuss/159055/Java-DP-solution-from-O(KN2)-to-O(KNlogN)
     */
    public int superEggDrop(int K, int N) {
        int[][] memo = new int[K + 1][N + 1];
        return helper(K, N, memo);
    }

    public int helper(int k, int n, int[][] memo) {
        if (n <= 1) {
            return n;
        }
        if (k == 1) return n;
        if (memo[k][n] > 0) {
            return memo[k][n];
        }
        int res = n;
//        for (int i = 1; i <= n; i++) {
//            int broken = helper(k - 1, i - 1, memo);
//            int unbroken = helper(k, n - i, memo);
//            res = Math.min(res, Math.max(broken, unbroken) + 1);
//        }

        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int broken = helper(k - 1, mid - 1, memo); //递增
            int unbroken = helper(k, n - mid, memo);  //递减
            res = Math.min(res, Math.max(broken, unbroken) + 1);
            if (broken == unbroken) break;
            else if (broken < unbroken) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        memo[k][n] = res;
        return res;
    }
}
