import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<int[]> stack = new Stack<>();
		
		StringTokenizer st;
		int totalScore = 0;
		
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[st.countTokens()];
			
			if(arr.length > 1) {
				for(int i = 0; i < arr.length; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}
				stack.push(new int[] {arr[1], arr[2]});
			}
			
            if(stack.isEmpty()) continue;
			int[] homework = stack.pop();
			int score = homework[0];
			int time = homework[1];
			time -= 1;
			
			if(time == 0) {
				totalScore += score;
			} else {
				stack.push(new int[] {score, time});
			}
		}
		
		System.out.println(totalScore);

	}

}
