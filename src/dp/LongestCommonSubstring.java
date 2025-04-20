package dp;

public class LongestCommonSubstring {

    int maxLen;
    private int longestCommonSubstring(String s1, String s2, String type ) {
        int n = s1.length();
        int m = s2.length();
        // Memoization
        // int[][] dp = new int[n][m];
        // for(int i = 0; i< n; i++) {
        //     for(int j = 0; j< m; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        // memoization(s1, s2, n-1, m-1, dp);
        // return maxLen;

        // Recursion
        // return reccurssion(s1, s2, s1.length()-1, s2.length()-1,0);

        // Tabulation 
        int[][] dp = new int[n+1][m+1];
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } 
            }
        }
        return maxLen;
    }

    // //Memoization
    // private int memoization(String s1, String s2, int i, int j , int[][] dp) {
    //     if(i<0 || j< 0)  return 0;
    //     if(dp[i][j] != -1) return dp[i][j];
    //     if(s1.charAt(i) == s2.charAt(j)) {
    //         dp[i][j] = 1 + memoization(s1,s2,i-1,j-1, dp);
    //         maxLen =  Math.max(maxLen, dp[i][j]);
    //     } else {
    //         dp[i][j] = 0; 
    //     }

    //     memoization(s1, s2, i-1, j, dp);
    //     memoization(s1, s2, i-1, j-1, dp);
    //     return dp[i][j];
    // }

    

    //  Reccurssion
    // private int reccurssion(String s1, String s2, int i, int j , int currLen) {
    //     if(i<0 || j<0) return currLen;
    //     if(s1.charAt(i) == s2.charAt(j)) {
    //         return reccurssion(s1, s2, i-1,j-1, currLen+1);
    //     }
    //     return Math.max(currLen, Math.max(reccurssion(s1, s2, i,j-1,0), reccurssion(s1, s2, i-1, j, 0)));
    // }


    
    public static void main(String[] args) {
        String str1 = "abcdfe";
        String str2 = "acde";
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        int result = lcs.longestCommonSubstring(str1, str2, "Tabulation");
        System.out.println("Length of LCS: " + result);
    }

}