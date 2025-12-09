import java.io.*;
import java.util.*;

public class Main {
	public static int[][] arr;
	public static int N ;
	
	public static int findHome(int y, int x) {
		int count = 1;
		Deque<int[]> q = new ArrayDeque<>();
		q.offerLast(new int[] {y,x});
		int[] directY = {0, 0, 1, -1};
		int[] directX = {-1, 1, 0, 0};
		while(!q.isEmpty()) {
			int[] cur = q.pollFirst();
			for(int i = 0 ; i < 4; i++) {
				int dy = directY[i] + cur[0];
				int dx = directX[i] + cur[1];
				if(dy < 0 || dx < 0 || dy >= N || dx >= N) continue;
				if(arr[dy][dx] == 0) continue;
				q.offerLast(new int[] {dy, dx});
				arr[dy][dx] = 0;
				count++;
			}
			
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			String st = br.readLine();
			for(int ii = 0; ii < N; ii++) {
				arr[i][ii] = st.charAt(ii) - '0';
			}
		}
		
		ArrayList<Integer> home = new ArrayList<>();
		int homeCount = 0;
		
		for(int i = 0 ; i < N; i++) {
			for(int ii = 0; ii < N; ii++) {
				if(arr[i][ii] == 1) {
					arr[i][ii] = 0;
					home.add(findHome(i, ii));
					homeCount++;
				}
			}
		}

		System.out.println(homeCount);
		Collections.sort(home);
		for(int h : home) {
			System.out.println(h);
		}
		
		br.close();
	}

}
