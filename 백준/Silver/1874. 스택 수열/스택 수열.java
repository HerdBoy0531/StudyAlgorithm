import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		ArrayList<Character> res = new ArrayList<>();
		Stack<Integer> problem = new Stack<>();
		
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			problem.push(i);
			res.add('+');
			while(problem.peek() == arr[cnt]) {
				problem.pop();
				res.add('-');
				cnt++;
				if(problem.isEmpty()) {
					break;
				}
			}
		}
		if(cnt == N) {
			for(char i : res) {
				System.out.println(i);
			}
		}
		else {
			System.out.println("NO");
		}
		
		
		
		br.close();
	}

}