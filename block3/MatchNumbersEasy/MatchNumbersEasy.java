
public class MatchNumbersEasy {
    public String maxNumber(int[] matches, int n) {
        String[] dp = new String[n + 1];
        dp[0] = "";
        for (int i = 0; i <= n; i++) {
            if (dp[i] != null) {
                for (int j = 0; j < matches.length; j++) {
                    if (i + matches[j] <= n) {
                        dp[i + matches[j]] = max(dp[i + matches[j]], j + dp[i]);
                    }
                }
            }
        }
        return dp[n] == null ? "0" : dp[n];
    }

    private String max(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.length() != b.length()) return a.length() > b.length() ? a : b;
        return a.compareTo(b) > 0 ? a : b;
    }


    public static void main(String[] args) {
        MatchNumbersEasy easy = new MatchNumbersEasy();
        System.out.println(easy.maxNumber(new int[]{1,1,1,1,1,1,1,1,1,1}
                , 50));
    }
}
