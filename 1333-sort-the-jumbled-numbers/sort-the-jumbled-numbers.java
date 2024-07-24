class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Map to store the mapped values of each number
        long[] mappedValues = new long[nums.length];
        
        // Compute the mapped values
        for (int i = 0; i < nums.length; i++) {
            mappedValues[i] = getMappedValue(nums[i], mapping);
        }
        
        // Create a list of indices for sorting
        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }

        // Sort indices based on the mapped values
        Arrays.sort(indices, Comparator.comparingLong(i -> mappedValues[i]));

        // Build the result array based on sorted indices
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[indices[i]];
        }

        return result;
    }

    private long getMappedValue(int num, int[] mapping) {
        if (num == 0) return mapping[0];

        long mappedValue = 0;
        long multiplier = 1;

        while (num > 0) {
            int digit = num % 10;
            mappedValue = mapping[digit] * multiplier + mappedValue;
            multiplier *= 10;
            num /= 10;
        }

        return mappedValue;
    }
}