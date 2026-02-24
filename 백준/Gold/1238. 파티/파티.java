import java.io.*;
import java.util.*;

public class Main {
	static class Edge{
		int to;
		int weight;
		
		Edge(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
	}
	
	static class Node implements Comparable<Node>{
		int vertex;
		int distance;
		
		Node(int vertex, int distance){
			this.vertex = vertex;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.distance, o.distance);
		}
	}
	
	static final int INF = 1_000_000_000;
	
	static int[] dijkstra(int start, List<Edge>[] graph) {
		int n = graph.length - 1;
		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(cur.distance != dist[cur.vertex]) continue;
			
			for(Edge e : graph[cur.vertex]) {
				int nd = cur.distance + e.weight;
				if(nd < dist[e.to]) {
					dist[e.to] = nd;
					pq.add(new Node(e.to, nd));
				}
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		List<Edge>[] g = new ArrayList[n + 1];
		List<Edge>[] rg = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++) {
			g[i] = new ArrayList<>();
			rg[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			g[start].add(new Edge(end, cost));
			rg[end].add(new Edge(start, cost));
		}
		
		int[] distFromX = dijkstra(x, g);
		int[] distToX = dijkstra(x, rg);
		
		int ans = 0;
		for(int i = 1; i <= n; i++) {
			ans = Math.max(ans, distToX[i] + distFromX[i]);
		}
		
		System.out.println(ans);

	}

}
