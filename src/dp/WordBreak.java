package dp;
import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>();
        for(String str:wordDict) {
            wordSet.add(str);
        }
        // int[] dp = new int[];
        // for(int i = 0; i< )
        return helper(s, wordSet, s.length()-1);
    }

    public boolean helper(String s, HashSet<String> wordSet, int idx) {
        if(idx<0) return true;
        for(int i =idx; i>=0; i--) {
            if(wordSet.contains(s.substring(i, idx+1)) && helper(s, wordSet, i - 1)) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("neet");
        wordDict.add("code");
        String s = "neetcode";
        boolean res = wb.wordBreak(s, wordDict);
        System.out.println("Response: " + res);
    }
    
}
