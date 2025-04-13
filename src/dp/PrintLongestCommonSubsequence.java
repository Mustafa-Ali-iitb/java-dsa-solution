package dp;

public class PrintLongestCommonSubsequence {
    
    public String printLongestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        String res = "";
        // Tabulation
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=m; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i = n, j = m;
        while(i>0 && j>0) {
            if(text1.charAt(i-1) == text2.charAt(j-1)) {
               res =  text1.charAt(i-1) + res;
               i--;
               j--; 
            } else if(dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
    
        return res;
    }

    // Main method for testing
    public static void main(String[] args) {
        String str1 = "abfkdlsfcde";
        String str2 = "afakmce";
        PrintLongestCommonSubsequence lcs = new PrintLongestCommonSubsequence();
        String result = lcs.printLongestCommonSubsequence(str1, str2);
        System.out.println("Length of LCS: " + result);
    }
}
