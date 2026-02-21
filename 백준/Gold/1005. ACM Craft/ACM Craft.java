import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] dp = new int[n+1];
			int[] delay = new int[n+1];
			int[] indegree = new int[n+1]; // indegree[i] => i 건물을 짓기 직전에 필요한 건물 수
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= n; i++) {
				delay[i] = Integer.parseInt(st.nextToken());
				dp[i] = delay[i];
			}
			
			ArrayList<Integer>[] graph = new ArrayList[n+1];
			for(int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				graph[start].add(end);
				indegree[end] += 1;
			}
			
			int w = Integer.parseInt(br.readLine());
			
			Queue<Integer> q = new LinkedList<>();
			
			for(int i = 1;i <= n; i++) {
				if(indegree[i] == 0) {
					q.add(i);
				}
			}
			
			while(!q.isEmpty()) {
				int now = q.poll();
				
				for(int next : graph[now]) {
					dp[next] = Math.max(dp[next], dp[now] + delay[next]);
					
					indegree[next] -= 1;
					
					if(indegree[next] == 0) {
						q.add(next);
					}
				}
			}
			sb.append(dp[w]+"\n");
		}
		System.out.println(sb);
	}

}
