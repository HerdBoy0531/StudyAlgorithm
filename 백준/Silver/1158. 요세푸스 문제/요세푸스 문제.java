import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int K = Integer.parseInt(arr[1]);
				
		Queue<Integer> rotate = new LinkedList<>();
		for(int i = 1; i <= N ; i++) {
			rotate.add(i);
		}
				
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while(!rotate.isEmpty()) {
			
			for(int i = 0; i < K-1; i++) {
				rotate.add(rotate.poll());
			}
			
			sb.append(rotate.poll());
			if(!rotate.isEmpty()) {
				sb.append(", ");
			}
			
		}
		sb.append(">");
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
}