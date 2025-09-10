import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int[] lst;
	static boolean[] used;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		lst = new int[M];
		used = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순 정렬
		Arrays.sort(arr);
		
		dfs(0);
		System.out.println(sb.toString());
		
		br.close();
	}
	
	public static void dfs(int lev) {
		if(lev == M) {
            for (int i = 0; i < M; i++) {
                sb.append(lst[i]).append(' ');
            }
            sb.append('\n');
            return;
		}
		
		for(int i = 0; i < N; i++) {
			if(used[i]) continue;
			used[i] = true;
			lst[lev] = arr[i];
			dfs(lev+1);
			used[i] = false;
		}
	}

}