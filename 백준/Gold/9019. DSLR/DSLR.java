import java.io.*;
import java.util.*;


public class Main {
	
	static int D(int x) {
		return (x * 2) % 10000;
	}

	static int S(int x) {
		return x == 0 ? 9999 : x - 1;
	}
	
	static int L(int x) {
		return (x % 1000) * 10 + x / 1000;
	}
	
	static int R(int x) {
		return x / 10 + (x % 10) * 1000;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[10000];
			Queue<int[]> numQ = new ArrayDeque<>();
			Queue<String> cmdQ = new ArrayDeque<>();
			
			visited[A] = true;
			numQ.offer(new int[] {A});
			cmdQ.offer("");
			
			while(!numQ.isEmpty()) {
				int cur = numQ.poll()[0];
				String cmd = cmdQ.poll();
				
				if(cur == B) {
					sb.append(cmd+"\n");
					break;
				}
				
				int d = D(cur);
				if(!visited[d]) {
					visited[d] = true;
					numQ.offer(new int[] {d});
					cmdQ.offer(cmd+"D");
				}
				
				int s = S(cur);
				if(!visited[s]) {
					visited[s] = true;
					numQ.offer(new int[] {s});
					cmdQ.offer(cmd+"S");
				}
				
				int l = L(cur);
				if(!visited[l]) {
					visited[l] = true;
					numQ.offer(new int[] {l});
					cmdQ.offer(cmd+"L");
				}
				
				int r = R(cur);
				if(!visited[r]) {
					visited[r] = true;
					numQ.offer(new int[] {r});
					cmdQ.offer(cmd+"R");
				}
			}
			
		}
		
		System.out.println(sb);

	}

}