
public class MatchNumbersEasy {
    public String maxNumber(int[] matches, int n) {
        String[] dp = new String[n + 1];
        dp[0] = "";
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < matches.length; j++) {
                if (i >= matches[j] && dp[i - matches[j]] != null && (!dp[i - matches[j]].isEmpty() || j > 0)) {
                    dp[i] = max(dp[i], j + dp[i - matches[j]]);
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
