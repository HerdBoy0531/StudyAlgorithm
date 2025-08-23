import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] Input_num = br.readLine().split(" ");
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(Input_num[i]);
		}
		
		int res = 0;
		
		for(int i = 1; i < N; i++) {
			res = Euclide(arr[0], arr[i]);
			bw.write(arr[0]/res+"/"+arr[i]/res+"\n");
		}
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int Euclide(int a, int b) {
		int res = 1;
		int num = 0;
		while(res != 0) {
			if(a > b) {
				res = a % b;
				a %= b;
				num = b;
			}
			else {
				res = b % a;
				b %= a;
				num = a;
			}
		}
		return num;
		
	}
}
