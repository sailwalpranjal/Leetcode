class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Create an array of indices
        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }

        // Sort indices based on the mapped values of nums
        Arrays.sort(indices, (i1, i2) -> {
            long mappedI1 = getMappedValue(nums[i1], mapping);
            long mappedI2 = getMappedValue(nums[i2], mapping);
            return Long.compare(mappedI1, mappedI2);
        });

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
