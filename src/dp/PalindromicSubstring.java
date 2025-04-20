package dp;

public class PalindromicSubstring {

    // private int isPalindrome(String s, int i, int j, int[][] dp) {
    //     if(i>=j) return 1;
    //     if(dp[i][j] != -1) return dp[i][j];
    //     dp[i][j] =  s.charAt(i)==s.charAt(j) ? isPalindrome(s, i+1, j-1, dp) : 0;
    //     return dp[i][j];
    // }

    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = n-1; i>=0; i--) {
            for(int j = i; j<n; j++) {
                if(i==j){
                    dp[i][j] = 1;
                }  else if(i+1==j) {
                    dp[i][j] = s.charAt(i)==s.charAt(j)?1:0;
                } else {
                    dp[i][j] = s.charAt(i)==s.charAt(j)?dp[i+1][j-1]:0;
                }
                res+=dp[i][j];
            }
        }
        

        // for(int i = 0; i< n; i++) {
        //     for(int j = 0; j<n; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        
        // for(int i = 0; i< n; i++) {
        //     for(int j = i; j< n; j++) {
        //         res += isPalindrome(s, i, j, dp);
        //     }
        // }
        return res;
    }


    public static void main(String[] args) {
        String s = "eababaf";
        PalindromicSubstring ps = new PalindromicSubstring();
        int result = ps.countSubstrings(s);
        System.out.println("Number of PS: " + result);
    }
    
}
