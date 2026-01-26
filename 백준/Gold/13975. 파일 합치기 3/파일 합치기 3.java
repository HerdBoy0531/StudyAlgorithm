import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Long> pq;
		
		
		int Test = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < Test; tc++) {
			pq = new PriorityQueue<>();
			int k = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < k; i++) {
				pq.offer(Long.parseLong(st.nextToken()));
			}
			
			long res = 0;
			
			while (pq.size() > 1) {
				long a = pq.poll();
				long b = pq.poll();
				long sum = a + b;
				
				res += sum;
				pq.offer(sum);
			}
		
			System.out.println(res);
		}

	}

}