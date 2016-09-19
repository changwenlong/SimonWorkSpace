package edu.zju.chwl.wangyi3;

/**
 * 有1，10，20，30，50，100元面值的钞票（每种钞票的数量没有限制），
 * 现在输入一个数：n，求有几种组合方式可以使着几种面值的钞票相加为n？（每种钞票可以用多次）
 * @author chwl
 * @Date 2016年9月11日 下午10:24:11
 */
public class Main {
	public static void main(String[] args) {
		System.out.println(getCom(5));
	}

	public static int getCom(int n) {
		if (n < 0)
			return 0;
		int coins[] = { 1, 5, 10, 20, 50, 100 };
		int dp[] = new int[n + 1];
		dp[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= n; j++) {
				dp[j] = (dp[j] + dp[j - coins[i]]);
			}
		}
		return dp[n];
	}
}
