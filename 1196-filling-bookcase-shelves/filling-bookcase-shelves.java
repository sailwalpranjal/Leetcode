public class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        // Initialize the dp array where dp[i] represents the minimum height needed for the first i books
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case: no books means height is 0

        // Iterate over each book
        for (int i = 1; i <= n; i++) {
            int width = 0;
            int maxHeight = 0;
            // Try placing books from the end of the current shelf to the start
            for (int j = i; j > 0; j--) {
                width += books[j - 1][0]; // thickness of the current book
                if (width > shelfWidth) {
                    break; // Stop if the total width exceeds shelfWidth
                }
                maxHeight = Math.max(maxHeight, books[j - 1][1]); // max height on the shelf
                dp[i] = Math.min(dp[i], dp[j - 1] + maxHeight);
            }
        }

        return dp[n]; // Minimum height needed for all books
    }
}
