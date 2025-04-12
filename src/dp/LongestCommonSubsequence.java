package dp;

public class LongestCommonSubsequence {

    // Function to find the length of LCS using bottom-up DP
    public static int lcs(String text1, String text2) {
        return text1.length();
    }

    // Main method for testing
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";

        int result = lcs(str1, str2);
        System.out.println("Length of LCS: " + result);
    }
}