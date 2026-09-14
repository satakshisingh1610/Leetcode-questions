class Solution {
    public int maxProfit(int[] prices) {
        int sold =0;
        int hold=-prices[0];
        int cooldown =0;
        for(int i =1;i<prices.length;i++){
            int prevsold = sold;
            int prevhold= hold;
            int prevcooldown = cooldown;
            hold = Math.max(prevhold,prevcooldown-prices[i]);
            sold=prevhold + prices[i];
            cooldown= Math.max(prevcooldown,prevsold);
        }
        return Math.max(sold,cooldown);
    }
}