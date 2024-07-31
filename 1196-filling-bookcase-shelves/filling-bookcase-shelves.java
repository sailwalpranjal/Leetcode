class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        
        // Initialize dp array where dp[i] is the minimum height needed for the first i books
        // Initial condition: no books need no height
        for (int i = 1; i <= n; ++i) {
            int width = 0, maxHeight = 0;
            // Update dp[i] considering placing books from index j to i on the current shelf
            dp[i] = Integer.MAX_VALUE; // Initialize to a large number

            for (int j = i; j > 0; --j) {
                width += books[j - 1][0];
                if (width > shelfWidth) {
                    break; // Stop if the width exceeds shelfWidth
                }
                maxHeight = Math.max(maxHeight, books[j - 1][1]); // Update max height of the shelf
                dp[i] = Math.min(dp[i], dp[j - 1] + maxHeight); // Update minimum height needed
            }
        }
        
        return dp[n]; // Return the minimum height needed for all books
    }
}
