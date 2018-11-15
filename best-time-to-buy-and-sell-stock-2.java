class Solution {
    public int maxProfit(int[] prices) {
      int sum = 0;
      int keep = 0;
      boolean isKept = false;
      int length = prices.length;
      for (int i = 0; i < length - 1; i++) {
          if (i == length - 2) {
            if (prices[i] <= prices[i+1] && isKept) {
              sum += prices[i + 1] - keep;
            } else if (!isKept && prices[i] < prices[i+1]) {
              sum += prices[i + 1] - prices[i];
            } else if (isKept && prices[i] > prices[i+1]) {
              sum += prices[i] - keep;
            }
            break;
          }
        
          if (prices[i] < prices[i+1] && !isKept) {
            keep = prices[i];
            isKept = true;
          } else if (prices[i] > prices[i + 1] && isKept) {
            sum += prices[i] - keep;
            isKept = false;
          }
        
//System.out.println(sum);
      }
      return sum;
    }
}
