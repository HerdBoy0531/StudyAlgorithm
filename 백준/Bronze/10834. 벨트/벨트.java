import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int cnt = 1;
		int LR_rotate = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int rotate = Integer.parseInt(st.nextToken());
			
			cnt = cnt * R / L;
			LR_rotate = Math.abs(LR_rotate-rotate);
		}
		System.out.println(LR_rotate+" "+cnt);
		
		br.close();
	}

}