import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];

        for(int i = 0; i < m; i++){

            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            int prev = Integer.parseInt(st.nextToken());

            for(int j = 1; j < k; j++){

                int next = Integer.parseInt(st.nextToken());

                graph[prev].add(next);
                indegree[next]++;

                prev = next;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        while(!q.isEmpty()){

            int cur = q.poll();
            sb.append(cur).append("\n");
            count++;

            for(int next : graph[cur]){

                indegree[next]--;

                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        if(count != n){
            System.out.println(0);
        }else{
            System.out.println(sb);
        }
    }
}