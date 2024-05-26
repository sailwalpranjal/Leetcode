class Solution {
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][] dpState = new int[2][3];
        dpState[0][0] = 1;
        for (int len = 0; len < n; len++) {
            int[][] dpNextState = new int[2][3];
            for (int totalAbsences = 0; totalAbsences < 2; totalAbsences++) {
                for (int consecutiveLates = 0; consecutiveLates < 3; consecutiveLates++) {
                    dpNextState[totalAbsences][0] = (dpNextState[totalAbsences][0] + dpState[totalAbsences][consecutiveLates]) % MOD;
                    if (totalAbsences < 1) {
                        dpNextState[totalAbsences + 1][0] = (dpNextState[totalAbsences + 1][0] + dpState[totalAbsences][consecutiveLates]) % MOD;
                    }       
                    if (consecutiveLates < 2) {
                        dpNextState[totalAbsences][consecutiveLates + 1] = (dpNextState[totalAbsences][consecutiveLates + 1] + dpState[totalAbsences][consecutiveLates]) % MOD;
                    }
                }
            }   
            dpState = dpNextState;
        }
        int totalCount = 0;
        for (int totalAbsences = 0; totalAbsences < 2; totalAbsences++) {
            for (int consecutiveLates = 0; consecutiveLates < 3; consecutiveLates++) {
                totalCount = (totalCount + dpState[totalAbsences][consecutiveLates]) % MOD;
            }
        }       
        return totalCount;
    }
}