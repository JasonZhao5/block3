
import java.math.BigInteger;

public class MatchNumbersEasy {
    public String maxNumber(int[] matches, int n)
    {
        dp = new BigInteger[51];
        for (int i = 0; i < 51; i++)
        {
            dp[i] = BigInteger.valueOf(0);
        }
        BigInteger val = Solve(matches, n);
        return val.toString();
    }

    BigInteger[] dp;
    BigInteger Solve(int[] mat, int n)
    {
        BigInteger ret = BigInteger.valueOf(0);
        if (dp[n].compareTo(ret) != 0)
            return dp[n];
        BigInteger ten = BigInteger.valueOf(10);
        for (int i = 0; i < mat.length; i++) {

            if (mat[i] <= n) {
                BigInteger tmp = ten.multiply(Solve(mat, n- mat[i])).add(BigInteger.valueOf(i));
                ret = ret.max(tmp);
            }
        }
        dp[n] = ret;
        return ret;
    }


    public static void main(String[] args) {
        MatchNumbersEasy easy = new MatchNumbersEasy();
        System.out.println(easy.maxNumber(new int[]{6,7,8}
                , 21));
    }
}
