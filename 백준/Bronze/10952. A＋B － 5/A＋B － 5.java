import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean res = true;
		StringBuilder sb = new StringBuilder();
		
		while(res) {
			String[] arr = br.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			if(a == 0 && b == 0) {
				res = false;
				break;
			}
			sb.append((a+b)+"\n");
		}
		
		System.out.print(sb);
		
		
		
		
		br.close();
	}

}