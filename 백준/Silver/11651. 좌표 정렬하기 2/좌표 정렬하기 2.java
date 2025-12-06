import java.io.*;
import java.util.*;

public class Main {

		public static void main(String[] args)throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][2];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, new Comparator<int[]>(){
				@Override
				public int compare(int[] a1, int[] a2) {
					return a1[1] != a2[1] ? a1[1]-a2[1] : a1[0]-a2[0];
				}
			});
			
			for(int i = 0; i < N; i++) {
				System.out.println(arr[i][0]+" "+arr[i][1]);
			}
			
			br.close();
		}

}