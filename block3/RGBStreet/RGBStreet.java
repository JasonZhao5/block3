

public class RGBStreet {
    public int estimateCost(String[] houses) {
        int[][] dp = new int[houses.length][3];
        String[] split0 = houses[0].split(" ");
        dp[0][0] = Integer.parseInt(split0[0]);
        dp[0][1] = Integer.parseInt(split0[1]);
        dp[0][2] = Integer.parseInt(split0[2]);

        for (int i = 1; i < houses.length; i++) {
            String[] split = houses[i].split(" ");
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + Integer.parseInt(split[0]);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + Integer.parseInt(split[1]);
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + Integer.parseInt(split[2]);
        }
        int temp = Math.min(dp[houses.length - 1][0], dp[houses.length - 1][1]);
        return Math.min(temp, dp[houses.length - 1][2]);
    }

    public static void main(String[] args) {
        System.out.println(new RGBStreet().estimateCost(new String[]
                {"30 19 5", "64 77 64", "15 19 97", "4 71 57", "90 86 84", "93 32 91"}

        ));
    }
}
