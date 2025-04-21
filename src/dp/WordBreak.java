package dp;
import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>();
        int n = s.length();
        for(String str:wordDict) {
            wordSet.add(str);
        }
        Boolean[] dp = new Boolean[n];
        
        return memoization(s, wordSet, n-1, dp);
    }

    public boolean memoization(String s, HashSet<String> wordSet, int idx, Boolean[] dp) {
        if(idx<0) return true;
        if(dp[idx] != null) return dp[idx];
        Boolean res = false; 
        for(int i =idx; i>=0; i--) {
            if(wordSet.contains(s.substring(i, idx+1)) && memoization(s, wordSet, i - 1, dp)) {
                res = true;
                break;
            }
        }
        dp[idx] = res;
        return res;
    }

    public boolean recursion(String s, HashSet<String> wordSet, int idx) {
        if(idx<0) return true;
        for(int i =idx; i>=0; i--) {
            if(wordSet.contains(s.substring(i, idx+1)) && recursion(s, wordSet, i - 1)) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("neeta");
        wordDict.add("code");
        String s = "neetcode";
        boolean res = wb.wordBreak(s, wordDict);
        System.out.println("Response: " + res);
    }
    
}
