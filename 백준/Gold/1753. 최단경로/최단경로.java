import java.io.*;
import java.util.*;

public class Main {
	
	static class Node{
		int to;
		int weight;
		
		Node(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수 
		int E = Integer.parseInt(st.nextToken()); // 감선의 개수
		
		int K = Integer.parseInt(br.readLine()); // 시작 정점
		
		ArrayList<Node>[] graph = new ArrayList[V + 1]; // Node는 총 V+1개, Index 는 0 ~ V까지
		for(int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new Node(v, w));
		}
		
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(a, b) -> a[1] - b[1]
		);
		
		pq.offer(new int[] {K, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int now = cur[0];
			int cost = cur[1];
			
			if(cost > dist[now]) continue;
			
			for(Node next : graph[now]) {
				int nextNode = next.to;
				int nextCost = cost + next.weight;
				
				if(nextCost < dist[nextNode]) {
					dist[nextNode] = nextCost;
					pq.offer(new int[] {nextNode, nextCost});
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
			System.out.println(dist[i]);
			}
		}

	}

}