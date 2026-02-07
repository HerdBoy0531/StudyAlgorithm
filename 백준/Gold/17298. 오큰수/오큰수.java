import java.io.*;
import java.util.*;

public class Main {

	static class NGE{
		int num;
		int index;
		
		NGE(int num, int index){
			this.num = num;
			this.index = index;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] res = new int[n];
		Arrays.fill(res, -1);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<NGE> stack = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			int k = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek().num < k) {
				NGE prev = stack.pop();
				res[prev.index] = k;
			}
			
			stack.push(new NGE(k, i));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(res[i]).append(" ");
		}
		
		System.out.println(sb);
	}

}