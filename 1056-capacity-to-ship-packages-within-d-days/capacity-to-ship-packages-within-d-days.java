class Solution { 
    static int dayCheck(int[] weights, int days, int mid){
        int sum = 0;
        int day = 0;
        for(int i = 0; i < weights.length; i++){
            sum += weights[i];
            if (sum > mid){
                day++;
                sum = weights[i];
            }
        }
        return day + 1;
    }
    public int shipWithinDays(int[] weights, int days) {
        
        int low = 0;
        int high = 0;
        for(int weight : weights){
            low = Math.max(low, weight);
            high += weight;
        }
        int ans = low;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(dayCheck(weights, days, mid) <= days){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
            
        }
        return ans;

    }
}