
//Buy and Sell Stocks-1
class Solution {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}

//Buy and Sell Stocks-2

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        for(int i = 0 ; i < prices.length - 1; i++) {
            if(prices[i + 1] > prices[i]) {
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }
}


//Buy and Sell Stocks-4

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        
        Arrays.fill(buy, Integer.MAX_VALUE);
        
        for(int i = 0 ;i < prices.length; i++) {
            for(int j = 1; j <= k; j++) {
                buy[j] = Math.min(buy[j], prices[i] - sell[j-1]);
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }
        return sell[k];
    }
}