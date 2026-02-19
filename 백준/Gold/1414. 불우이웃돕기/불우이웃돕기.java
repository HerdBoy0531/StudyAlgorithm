import java.io.*;
import java.util.*;

public class Main {
	
	static class Edge implements Comparable<Edge>{
		int from, to, cost;
		
		Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	static int[] parent;
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) return false;
		
		parent[b] = a;
		return true;
	}
	
	static int convert(char c) {
		if(c >= 'a' && c <= 'z') return c - 'a' + 1;
		if(c >= 'A' && c <= 'Z') return c - 'A' + 27;
		return 0;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Edge> edges = new ArrayList<>();
		
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < n; j++) {
				int cost = convert(str.charAt(j));
				
				sum += cost;
				
				if(i != j && cost > 0) {
					edges.add(new Edge(i, j, cost));
				}
			}
		}
		
		parent = new int[n];
		for(int i = 0; i < n; i++) parent[i] = i;
		
		Collections.sort(edges);
		
		int mstSum = 0;
		int edgeCount = 0;
		
		for(Edge e : edges) {
			if(union(e.from, e.to)) {
				mstSum += e.cost;
				edgeCount++;
				
				if(edgeCount == n - 1) break;
			}
		}
		
		if(edgeCount != n - 1) {
			System.out.println(-1);
		} else {
			System.out.println(sum - mstSum);
		}
	}

}