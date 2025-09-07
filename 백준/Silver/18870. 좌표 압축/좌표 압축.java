import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		TreeMap<Integer, Integer> t = new TreeMap<>();
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr[i] = a;
			t.put(a, t.getOrDefault(a, 0)+1);
		}
		
		Map<Integer, Integer> rank = new HashMap<>();
		int ranking =0;
		for(int key : t.keySet()) {
			rank.put(key, ranking);
			ranking++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			sb.append(rank.get(arr[i])+" ");
		}
		
		
		System.out.print(sb.toString());
		br.close();
	}

}
