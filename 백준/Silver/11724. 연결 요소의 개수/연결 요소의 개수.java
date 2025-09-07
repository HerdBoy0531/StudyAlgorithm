import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>(N+1);
		for(int i = 0 ; i <= N; i++) graph.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		visited = new boolean[N+1];
		
		int cnt = 0;
		
		for(int i = 0; i <= N; i++) {
			if(!visited[i]) {
				BFS(i);
				cnt++;
			}
		}
		
		System.out.print(cnt-1);
		br.close();
	}
	
	public static void BFS(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int nxt : graph.get(cur)) {
				if(!visited[nxt]) {
					visited[nxt] = true;
					q.offer(nxt);
				}
			}
		}
	}

}
