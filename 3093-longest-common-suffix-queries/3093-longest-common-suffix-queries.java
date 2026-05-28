import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];

        int idx;
        int len;

        TrieNode() {
            idx = -1;
            len = Integer.MAX_VALUE;
        }
    }

    TrieNode root = new TrieNode();

    void insert(String s, int index) {

        TrieNode node = root;

        // root 갱신
        if(s.length() < node.len) {
            node.len = s.length();
            node.idx = index;
        }

        for(int i = s.length() - 1; i >= 0; i--) {

            int c = s.charAt(i) - 'a';

            if(node.child[c] == null) {
                node.child[c] = new TrieNode();
            }

            node = node.child[c];

            // 더 짧은 문자열이면 갱신
            if(s.length() < node.len) {
                node.len = s.length();
                node.idx = index;
            }
        }
    }

    int search(String s) {

        TrieNode node = root;

        for(int i = s.length() - 1; i >= 0; i--) {

            int c = s.charAt(i) - 'a';

            if(node.child[c] == null) {
                break;
            }

            node = node.child[c];
        }

        return node.idx;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        int n = wordsContainer.length;

        for(int i = 0; i < n; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for(int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}