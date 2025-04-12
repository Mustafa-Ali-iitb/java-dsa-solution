package dp;

public class LongestCommonSubsequence {

    // Function to find the length of LCS using bottom-up DP
    public static int lcs(String text1, String text2) {
        return text1.length();
    }

    public int longestCommonSubsequence(String text1, String text2, String option) {
        int n = text1.length();
        int m = text2.length();
        
        if(option =="Reccursion") {
            //Reccursion
            return reccursion(text1, text2, n-1, m-1);    
        }
        else if(option =="Memoization") {
            //Memoization
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = -1;
                }
            }
            return memoization(text1, text2, n-1, m-1, dp);
        }
        else {
            // Tabulation
            int res = 0;
            int[][] dp = new int[n+1][m+1];
            for(int i = 1; i<=n; i++) {
                for(int j = 1; j<=m; j++) {
                    if(text1.charAt(i-1)==text2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                    res = dp[i][j]>res?dp[i][j]:res;
                }
            }
            return res;
        }
        
    }

    // Reccursion 
    public int reccursion(String text1, String text2, int i, int j) {
        if(i<0 ||j<0) return 0;
        if(text1.charAt(i) == text2.charAt(j)) {
            return 1 + reccursion(text1, text2, i-1, j-1);
        } else {
            return Math.max(reccursion(text1, text2, i, j-1), reccursion(text1, text2, i-1, j));
        }
    }

    // Memoization
    public int memoization(String text1, String text2, int i, int j, int[][] dp) { 
        if(i<0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + memoization(text1, text2, i-1, j-1, dp);
        } else {
            dp[i][j] = Math.max(memoization(text1, text2, i, j-1, dp), memoization(text1, text2, i-1, j, dp));
        }
        return dp[i][j];
    }

    // Main method for testing
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int result = lcs.longestCommonSubsequence(str1, str2, "Tabulation");
        System.out.println("Length of LCS: " + result);
    }
}