class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int count;
        boolean isEnd;
    }

    TrieNode root = new TrieNode();

    public int solution(String[] words) {

        for(String word : words) {
            insert(word);
        }

        int answer = 0;

        for(String word : words) {
            answer += find(word);
        }

        return answer;
    }

    private void insert(String word) {
        TrieNode node = root;

        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if(node.child[idx] == null) {
                node.child[idx] = new TrieNode();
            }

            node = node.child[idx];
            node.count++;
        }

        node.isEnd = true;
    }

    private int find(String word) {
        TrieNode node = root;
        int cnt = 0;

        for(char ch : word.toCharArray()) {
            node = node.child[ch - 'a'];
            cnt++;

            if(node.count == 1) {
                return cnt;
            }
        }

        return cnt;
    }
}