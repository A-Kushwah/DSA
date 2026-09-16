class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGain = 0;
        int tank = 0;
        int start = 0;

        for(int i = 0; i < gas.length; i++){
            int diff = gas[i] - cost[i];
            totalGain += diff;
            tank += diff;

            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
             
        }
        return totalGain >= 0 ? start : -1;
    }
}