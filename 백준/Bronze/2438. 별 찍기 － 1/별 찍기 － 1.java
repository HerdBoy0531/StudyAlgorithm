import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			for(int ii = 0; ii < i; ii++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
		
		br.close();
	}

}