class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i1, i2) -> {
            long mappedI1 = mapNumber(nums[i1], mapping);
            long mappedI2 = mapNumber(nums[i2], mapping);
            return Long.compare(mappedI1, mappedI2);
        });
        int[] result = new int[nums.length];
        for (int i = 0; i < indices.length; i++) {
            result[i] = nums[indices[i]];
        }
        return result;
    }
    private long mapNumber(int num, int[] mapping) {
        StringBuilder mapped = new StringBuilder();
        for (char digit : Integer.toString(num).toCharArray()) {
            mapped.append(mapping[digit - '0']);
        }
        return Long.parseLong(mapped.toString());
    }
}