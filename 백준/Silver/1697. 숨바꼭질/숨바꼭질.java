import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[100001];
		Queue<int[]> q = new ArrayDeque<>();
		arr[N] = 1;
		q.offer(new int[] {N, 1});
		int res = 0;
		while(!q.isEmpty()) {
			int[] lst = q.poll();
			int cur = lst[0];
			int cnt = lst[1];
			if(cur == K) {
				res = cnt;
				break;
			}
			if(cur + 1 <= 100000 && arr[cur+1] == 0) {
				arr[cur+1] = cnt+1;
				q.offer(new int[] {cur+1, cnt+1});
			}
			if(cur - 1 >= 0 && arr[cur-1] == 0) {
				arr[cur-1] = cnt+1;
				q.offer(new int[] {cur-1, cnt+1});
			}
			if(cur * 2 <= 100000 && arr[cur*2]== 0) {
				arr[cur*2] = cnt+1;
				q.offer(new int[] {cur*2, cnt+1});
			}
		}
		
		System.out.print(res-1);
		
		
		br.close();
	}

}
