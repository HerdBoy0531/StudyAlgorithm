import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) parent[b] = a;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n];

        for(int i = 0; i < n; i++)
            parent[i] = i;

        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());

                if(v == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());

        int root = find(Integer.parseInt(st.nextToken()) - 1);

        for(int i = 1; i < m; i++) {
            int city = Integer.parseInt(st.nextToken()) - 1;

            if(root != find(city)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
