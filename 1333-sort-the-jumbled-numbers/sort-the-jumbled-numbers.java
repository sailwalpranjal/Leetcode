class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedNums, (a, b) -> {
            long mappedA = mapNumber(a, mapping);
            long mappedB = mapNumber(b, mapping);
            return Long.compare(mappedA, mappedB);
        });
        return Arrays.stream(boxedNums).mapToInt(Integer::intValue).toArray();
    }
    private long mapNumber(int num, int[] mapping) {
        StringBuilder mapped = new StringBuilder();
        for (char digit : Integer.toString(num).toCharArray()) {
            mapped.append(mapping[digit - '0']);
        }
        return Long.parseLong(mapped.toString());
    }
}