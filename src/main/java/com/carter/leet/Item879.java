package com.carter.leet;

import java.util.Arrays;

/**
 * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * <p>
 * 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * <p>
 * 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * <p>
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 * 输出：2
 * 解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
 * 总的来说，有两种计划。
 * 示例 2：
 * <p>
 * 输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
 * 输出：7
 * 解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
 * 有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 0 <= minProfit <= 100
 * 1 <= group.length <= 100
 * 1 <= group[i] <= 100
 * profit.length == group.length
 * 0 <= profit[i] <= 100
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/profitable-schemes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Item879 {

    public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
        int mod = 100000007;
        //人数-次数
        long[][] arr = new long[minProfit + 1][n + 1];
        arr[0][0] = 1;
        for (int i = 0; i < group.length; i++) {
            for (int j = minProfit; j >= profit[i]; j--) {
                for (int k = n; k >= group[i]; k--) {
                    arr[j][k] = (arr[j][k] + arr[(j - profit[i]) % minProfit][k - group[i]]) % mod;
                }
            }
        }
        return (int) arr[minProfit][n];
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int sum = Arrays.stream(profit).sum();
        //人数-次数
        long[][] arr = new long[sum + 1][n + 1];
        arr[0][0] = 1;
        int mod = (int) Math.pow(10, 9) + 7;
        for (int i = 0; i < group.length; i++) {
            for (int j = sum; j >= profit[i]; j--) {
                for (int k = n; k >= group[i]; k--) {
                    arr[j][k] += arr[j - profit[i]][k - group[i]] % mod;
                }
            }
        }

        long rs = 0;
        for (int i = minProfit; i < sum + 1; i++) {
            for (long t : arr[i]) {
                rs += t;
                rs %= mod;
            }
        }
        return (int) (rs % mod);
    }

    int mod = (int)1e9+7;
    public int profitableSchemes3(int n, int min, int[] gs, int[] ps) {
        int m = gs.length;
        int[][] f = new int[n + 1][min + 1];
        for (int i = 0; i <= n; i++) f[i][0] = 1;
        for (int i = 1; i <= m; i++) {
            int a = gs[i - 1], b = ps[i - 1];
            for (int j = n; j >= a; j--) {
                for (int k = min; k >= 0; k--) {
                    int u = Math.max(k - b, 0);
                    f[j][k] += f[j - a][u];
                    if (f[j][k] >= mod) f[j][k] -= mod;
                }
            }
        }
        return f[n][min];
    }
}
