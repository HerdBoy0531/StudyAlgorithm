import java.util.*;

class Solution {
    
    static class Node {
        int value, sheep;
        Node left, right;

        Node(int value, int info) {
            this.value = value;
            this.sheep = (info == 0) ? 1 : -1;
        }
    }

    int answer = 0;
    Node[] nodes;

    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, info[i]);
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            if (nodes[from].left == null) {
                nodes[from].left = nodes[to];
            } else {
                nodes[from].right = nodes[to];
            }
        }

        List<Integer> next = new ArrayList<>();
        next.add(0);

        dfs(0, 0, next);

        return answer;
    }

    void dfs(int sheepCnt, int wolfCnt, List<Integer> nextList) {

        answer = Math.max(answer, sheepCnt);

        for (int i = 0; i < nextList.size(); i++) {
            int cur = nextList.get(i);

            int newSheep = sheepCnt;
            int newWolf = wolfCnt;

            if (nodes[cur].sheep == 1) newSheep++;
            else newWolf++;

            if (newWolf >= newSheep) continue;

            List<Integer> next = new ArrayList<>(nextList);
            next.remove(i);

            if (nodes[cur].left != null) next.add(nodes[cur].left.value);
            if (nodes[cur].right != null) next.add(nodes[cur].right.value);

            dfs(newSheep, newWolf, next);
        }
    }
}