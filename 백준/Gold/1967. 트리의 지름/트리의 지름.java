import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static ArrayList<int[]>[] tree;
	static boolean[] visited;
	static int maxDist = 0;
	static int farNode = 0;
	
	static void bfs(int start) {
		Queue<int[]> q = new ArrayDeque<>();
		visited = new boolean[n+1];
		
		q.offer(new int[] {start, 0});
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int node = cur[0];
			int dist = cur[1];
			
			if(dist > maxDist) {
				maxDist = dist;
				farNode = node;
			}
			
			for(int[] next : tree[node]) {
				int nextNode = next[0];
				int cost = next[1];
				
				if(!visited[nextNode]) {
					visited[nextNode] = true;
					q.offer(new int[] {nextNode, dist+cost});
				}
			}
		}
		
	}
	
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			tree[a].add(new int[] {b, cost});
			tree[b].add(new int[] {a, cost});
		}
		
		bfs(1);
		
		maxDist = 0;
		bfs(farNode);
		
		System.out.println(maxDist);
		
		
		
		br.close();
	}

	
	
}