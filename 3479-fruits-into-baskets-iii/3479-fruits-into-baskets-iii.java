class Solution {
    int[] tree;
    int n;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = baskets.length;
        tree = new int[n * 4];

        build(baskets, 1, 0, n-1);

        int unplaced = 0;

        for(int fruit : fruits) {
            if(tree[1] < fruit) {
                unplaced++;
            } else {
                int idx = findLeftmost(1, 0, n - 1, fruit);
                update(1, 0, n - 1, idx, 0);
            }
        }

        return unplaced;
    }

    void build(int[] baskets, int node, int start, int end) {
        if(start == end) {
            tree[node] = baskets[start];
            return;
        }

        int mid = (start + end) / 2;

        build(baskets, node * 2, start, mid);
        build(baskets, node * 2 + 1, mid + 1, end);

        tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
    }

    int findLeftmost(int node, int start, int end, int fruit) {
        if(start == end) {
            return start;
        }
        
        int mid = (start + end) / 2;

        if(tree[node * 2] >= fruit) {
            return findLeftmost(node * 2, start, mid, fruit);
        } else {
            return findLeftmost(node * 2 + 1, mid + 1, end, fruit);
        }
    }

    void update(int node, int start, int end, int idx, int value) {
        if(start == end) {
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        if(idx <= mid) {
            update(node * 2, start, mid, idx, value);
        } else {
            update(node * 2 + 1, mid + 1, end, idx, value);
        }

        tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
    }
}