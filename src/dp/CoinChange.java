package dp;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // int[][] dp = new int[coins.length][amount+1];
    
        // for(int a = 0; a <= amount; a++)  {
        //     if(a%coins[0] == 0) {
        //         dp[0][a] = a/coins[0];
        //     } else {
        //         dp[0][a] = 100000;
        //     }
        // }

        // for(int idx = 1; idx< coins.length; idx++) {
        //     for(int a = 0; a<amount+1; a++) {
        //         int nPick = dp[idx-1][a];
        //         int pick = 100000;
                
        //         if(coins[idx]<=a) {
        //             pick = 1 + dp[idx][a-coins[idx]];
        //         }
        //         dp[idx][a] = Math.min(nPick, pick);
        //     }
        // }
    
        // return dp[coins.length-1][amount];


        return recursion(coins, coins.length-1, amount)==100000?-1:recursion(coins, coins.length-1, amount); 
        // return memoization(coins, coins.length-1, amount, dp)==100000?-1:memoization(coins, coins.length-1, amount, dp); 
    }

    // Memoization
    private int memoization(int[] coins, int idx,  int amount, int[][] dp) {
        if(amount==0) return 0;
        if(idx == 0) {
            if(amount%coins[0] == 0) {
                return amount/coins[0];
            } else {
                return 100000;
            }
        }
        if(dp[idx][amount] !=-1) return dp[idx][amount];
        
        int nPick = memoization(coins, idx-1, amount, dp);
        int pick = 100000;
        
        if(coins[idx]<=amount) {
            pick = 1 + memoization(coins, idx, amount-coins[idx], dp);
        }
        dp[idx][amount] = Math.min(nPick, pick);
        return dp[idx][amount];
    }

    // Recursion
    private int recursion(int[] coins, int idx,  int amount) {
        if(amount==0) return 0;
        if(idx == 0) {
            if(amount%coins[0] == 0) {
                return amount/coins[0];
            } else {
                return 100000;
            }
        }
        int nPick = recursion(coins, idx-1, amount);
        int pick = 100000;
        if(coins[idx]<=amount) {
            pick = 1 + recursion(coins, idx, amount-coins[idx]);
        }
        return Math.min(nPick, pick);
    }


    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] weight = new int[]{4,2,5};
        int minCount = cc.coinChange(weight, 11);
        System.out.println("Min Coins is: " + minCount);
    }
    
}
