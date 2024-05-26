class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] available = new int[26];
        for (char c : letters) {
            available[c - 'a']++;
        }
        int n = words.length;
        int[] wordScores = new int[n];
        int[][] wordCounts = new int[n][26];
        for (int i = 0; i < n; i++) {
            int wordScore = 0;
            for (char ch : words[i].toCharArray()) {
                wordCounts[i][ch - 'a']++;
                wordScore += score[ch - 'a'];
            }
            wordScores[i] = wordScore;
        }
        int maxScore = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int[] totalAvailable = available.clone();
            int currentScore = 0;
            boolean valid = true;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j < 26; j++) {
                        totalAvailable[j] -= wordCounts[i][j];
                        currentScore += wordCounts[i][j] * score[j];
                    }
                }
            }
            for (int count : totalAvailable) {
                if (count < 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                maxScore = Math.max(maxScore, currentScore);
            }
        }
        return maxScore;
    }
}