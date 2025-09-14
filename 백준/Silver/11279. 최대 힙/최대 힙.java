import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a == 0) {
				if(pq.isEmpty()) {
					sb.append(0+"\n");
				}
				else {
					sb.append(pq.poll() + "\n");
				}
			}
			else {
				pq.offer(a);
			}
		}
		
		System.out.print(sb.toString());
		
		br.close();
	}

}
