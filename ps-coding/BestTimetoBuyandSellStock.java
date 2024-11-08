
/**
 * BestTimetoBuyandSellStock
 */
public class BestTimetoBuyandSellStock {

  public static int maxProfit(int[] prices) {
    int profit = 0;
    int buy = 0, sell = 1;

    while (sell < prices.length) {
      if (prices[buy] < prices[sell]) {
        profit = Math.max(profit, prices[sell] - prices[buy]);
        sell++;
      } else {
        buy = sell;
        sell++;
      }
    }

    return profit;
  }

  public static void main(String[] args) {
    int prices[] = { 7, 1, 5, 3, 6, 4 };
    int profit = maxProfit(prices);
    System.out.println("profit : " + profit);
  }
}
