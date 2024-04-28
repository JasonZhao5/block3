public class HandsShaking {
    long countPerfect(int n) {
        int[][] dp = new int[n / 2 + 1][n / 2 + 1];
        int[] count = new int[n / 2 + 1];
        dp[1][1] = 1;
        count[1] = 1;

        for (int i = 2; i <= n / 2; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i][j] = count[i - j];
                dp[i][i - j + 1] = count[i - j];
                if (i % 2 != 0 && j == i / 2) {
                    dp[i][j + 1] = dp[i - 2][1] * dp[i - 2][1];
                }
            }
            for (int j = 1; j <= n / 2; j++) {
                count[i] += dp[i][j];
            }
        }

        return count[n / 2];
    }

    public static void main(String[] args) {
        System.out.println(new HandsShaking().countPerfect(
                10
        ));
    }
}
