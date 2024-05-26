class Solution {
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][] dpCurrState = new int[2][3];
        int[][] dpNextState = new int[2][3];
        dpCurrState[0][0] = 1;
        for (int len = 0; len < n; len++) {
            for (int i = 0; i < 2; i++) {
                Arrays.fill(dpNextState[i], 0);
            }
            for (int totalAbsences = 0; totalAbsences < 2; totalAbsences++) {
                for (int consecutiveLates = 0; consecutiveLates < 3; consecutiveLates++) {
                    dpNextState[totalAbsences][0] = (dpNextState[totalAbsences][0] + dpCurrState[totalAbsences][consecutiveLates]) % MOD;
                    if (totalAbsences < 1) {
                        dpNextState[totalAbsences + 1][0] = (dpNextState[totalAbsences + 1][0] + dpCurrState[totalAbsences][consecutiveLates]) % MOD;
                    }       
                    if (consecutiveLates < 2) {
                        dpNextState[totalAbsences][consecutiveLates + 1] = (dpNextState[totalAbsences][consecutiveLates + 1] + dpCurrState[totalAbsences][consecutiveLates]) % MOD;
                    }
                }
            }   
            for (int i = 0; i < 2; i++) {
                System.arraycopy(dpNextState[i], 0, dpCurrState[i], 0, 3);
            }
        }
        int totalCount = 0;
        for (int totalAbsences = 0; totalAbsences < 2; totalAbsences++) {
            for (int consecutiveLates = 0; consecutiveLates < 3; consecutiveLates++) {
                totalCount = (totalCount + dpCurrState[totalAbsences][consecutiveLates]) % MOD;
            }
        }       
        return totalCount;
    }
}