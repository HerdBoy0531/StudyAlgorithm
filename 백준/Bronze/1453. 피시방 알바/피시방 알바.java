import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[100];
		int man = Integer.parseInt(br.readLine());
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < man; i++) {
			int seat = Integer.parseInt(st.nextToken()) - 1;
			if(arr[seat] == 0) {
				arr[seat] = 1;
			}
			else cnt++;
		}
		
		System.out.println(cnt);
		br.close();
	}

}