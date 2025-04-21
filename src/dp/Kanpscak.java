package dp;
public class Kanpscak {

    private int max_stolen_volume(int[] weight, int[] volume, int maxWeight) {
        if(weight.length==0) return 0;
        int[][] dp = new int[weight.length][maxWeight+1];
        for(int i = 0; i<=maxWeight; i++) {
            if(weight[0]<=i) dp[0][i] = volume[0];
        }

        for (int i = 1; i < weight.length; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                int notPick = dp[i - 1][w];
                int pick = 0;
                if (weight[i] <= w) {
                    pick = volume[i] + dp[i - 1][w - weight[i]];
                }
                dp[i][w] = Math.max(notPick, pick);
            }
        }

        return dp[weight.length-1][maxWeight];

        // Memoization
        // for(int i = 0; i< weight.length; i++) {
        //     for(int j = 0; j< maxWeight+1; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        // return memoization(weight, volume, weight.length-1, maxWeight, dp);
    }

    

    // private int memoization(int[] weight, int[] volume, int idx, int maxWeight, int[][] dp){
    //     if(idx==0) {
    //         if(weight[0]<=maxWeight) {
    //             return volume[0];
    //         } else {
    //             return 0;
    //         }
    //     }
    //     if(dp[idx][maxWeight] != -1) return dp[idx][maxWeight];

    //     int nPick = memoization(weight, volume, idx-1, maxWeight, dp);
    //     int pick =  -999999;
    //     if(weight[idx]<maxWeight) {
    //         pick = volume[idx] + memoization(weight, volume, idx-1, maxWeight - weight[idx], dp);
    //     }
    //     dp[idx][maxWeight] = Math.max(nPick, pick);
    //     return dp[idx][maxWeight];
    // }

    // private int recursion(int[] weight, int[] volume, int idx, int maxWeight){
    //     if(idx==0) {
    //         if(weight[0]<=maxWeight) {
    //             return volume[0];
    //         } else {
    //             return 0;
    //         }
    //     }
    //     int nPick = recursion(weight, volume, idx-1, maxWeight);
    //     int pick = -1;
    //     if(weight[idx]<maxWeight) {
    //         pick = volume[idx] + recursion(weight, volume, idx-1, maxWeight - weight[idx]);
    //     }

    //     return Math.max(nPick, pick);
    // }

    public static void main(String[] args) {
        Kanpscak ks = new Kanpscak();
        int[] weight = new int[]{3,2,5};
        int[] vol = new int[]{50,60,70};
        int maxVol = ks.max_stolen_volume(weight, vol, 11);
        System.out.println("Max Volume is: " + maxVol);
    }
    
}
