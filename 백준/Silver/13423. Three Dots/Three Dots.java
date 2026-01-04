import java.io.*;
import java.util.*;


public class Main {
	public static int[] arr;
	public static TreeSet<Integer> tm;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i = 0; i < tc; i++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			tm = new TreeSet<>();
			arr = new int[N];
			int num = 0;
			
			for(int j = 0; j < N; j++) {
				num = Integer.parseInt(st.nextToken());
				tm.add(num);
				arr[j] = num;
			}
			Arrays.sort(arr);
			
			findNum(N);
		}
		br.close();
	}
	
	public static void findNum(int N) {
		int cnt = 0;
		for(int i = 0; i < N-2; i++) {
			for(int j = i+1; j < N-1; j++) {
				int value = arr[j] + (arr[j] - arr[i]);
				if(tm.contains(value)) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}