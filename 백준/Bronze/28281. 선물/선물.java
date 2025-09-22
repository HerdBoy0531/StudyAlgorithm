import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		long min_score = Long.MAX_VALUE;
		
		for(int i = 0; i < N-1; i++) {
			long res = 0;
			res = arr[i]*K + arr[i+1]*K;
			min_score = Math.min(min_score, res);
		}
		
		System.out.println(min_score);
		
		br.close();
	}

}
