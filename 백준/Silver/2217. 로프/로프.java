import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++ ) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		
		Arrays.sort(arr);
		
		int res = 0;
		
		for(int i = 0; i < N; i++) {
			res = Math.max(res, arr[i] * (N-i));
		}
		
		bw.write(res+" ");
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
