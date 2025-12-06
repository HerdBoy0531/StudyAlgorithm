import java.io.*;
import java.util.*;

public class Main {
	static boolean check[];
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		check = new boolean[N+1];
		
		int count = 0;
		
		Queue<int[]> q =new LinkedList<>();
		
		q.add(new int[] {1 , 0});
		check[1] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int node = cur[0];
			int dist = cur[1];
			
			if(dist == 2) continue;
			
			for(int next : graph.get(node)) {
				if (!check[next]) {
					check[next] = true;
					q.add(new int[] {next, dist+1});
					count++;
				}
			}
		}
		
		System.out.print(count);
		
		
		br.close();
	}

}
