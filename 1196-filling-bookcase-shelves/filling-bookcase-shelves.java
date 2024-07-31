public class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        // Initialize dp array to store minimum height for arranging the first i books
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case: no books means height is 0
        // Iterate over each book to compute minimum height for the arrangement
        for (int i = 1; i <= n; i++) {
            int width = 0;
            int maxHeight = 0;
            // Try placing books from the end of the current shelf to the start
            for (int j = i; j > 0; j--) {
                width += books[j - 1][0]; // Add thickness of the current book
                if (width > shelfWidth) {
                    break; // Stop if width exceeds shelfWidth
                }
                maxHeight = Math.max(maxHeight, books[j - 1][1]); // Update max height of the shelf
                dp[i] = Math.min(dp[i], dp[j - 1] + maxHeight); // Update minimum height needed
            }
        }
        return dp[n]; // Minimum height needed for all books
    }
}