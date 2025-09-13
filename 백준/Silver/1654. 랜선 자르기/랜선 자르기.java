import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
        long sta = 1; // 최소 길이
        long ed = Arrays.stream(arr).max().getAsInt(); // 최대 길이
        long ans = 0;
		
		while(sta <= ed) {
			long md = (sta + ed) / 2;
			long cnt = 0;
			
			for(int i = 0; i < N; i++) {
				cnt += arr[i] / md;
			}
			
			if(cnt >= M) {
				ans = md;
				sta = md + 1;
			} else {
				ed = md - 1;
			}
		}
		
		System.out.print(ans);
		
		br.close();
	}

}