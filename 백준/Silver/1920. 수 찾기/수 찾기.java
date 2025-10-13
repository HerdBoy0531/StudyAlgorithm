import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		Map<Long, Integer> tm = new TreeMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			long num = Long.parseLong(st.nextToken());
			tm.put(num, tm.getOrDefault(num, 0) + 1);
		}
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			Long num = Long.parseLong(st.nextToken());
			int res = 0;
			if(tm.get(num) != null) {
				res = 1;
			}
			sb.append(res+"\n");
		}
		System.out.print(sb);
		
		br.close();
	}

}