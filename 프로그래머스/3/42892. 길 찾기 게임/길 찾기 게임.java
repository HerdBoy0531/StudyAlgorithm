import java.util.*;

class Solution {
    
    static class Node {
        int value, x, y;
        Node left, right;

        Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        int N = nodeinfo.length;

        // 1. 노드 번호 추가
        for (int i = 0; i < N; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            nodeinfo[i] = new int[]{i + 1, x, y};
        }

        // 2. 정렬 (y 내림차순, x 오름차순)
        Arrays.sort(nodeinfo, (a, b) -> {
            if (a[2] == b[2]) {
                return a[1] - b[1];
            }
            return b[2] - a[2];
        });

        // 3. Node 객체 생성
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], nodeinfo[i][2]);
        }

        // 4. 트리 구성
        Node root = nodes[0];
        for (int i = 1; i < N; i++) {
            insert(root, nodes[i]);
        }

        // 5. 순회
        preorder(root);
        postorder(root);

        // 6. 결과 반환
        int[][] answer = new int[2][N];
        for (int i = 0; i < N; i++) {
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }

        return answer;
    }

    // 트리 삽입
    void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }

    // 전위 순회
    void preorder(Node node) {
        if (node == null) return;
        pre.add(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 후위 순회
    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        post.add(node.value);
    }
}