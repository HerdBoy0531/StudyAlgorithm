class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder answer = new StringBuilder();

        for (String word : words) {
            int sum = 0;

            for (char c : word.toCharArray()) {
                sum += weights[c - 'a'];
            }

            int mod = sum % 26;

            // 0 -> z, 1 -> y, ..., 25 -> a
            answer.append((char)('z' - mod));
        }

        return answer.toString();
    }
}