
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Testcase = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc < Testcase+1; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			int maxValue = 0;
			for(int i = 0 ; i < N; i++ ) {
				arr[i] = Integer.parseInt(st.nextToken());
				maxValue = maxValue+arr[i];
			}
			int[] visited = new int[maxValue + 1];
			visited[0] = 1;
			for(int point : arr) {
				int[] temp = visited.clone();
				for(int i = 1; i <= maxValue; i++) {
					if(visited[i] == 1 && i+point <= maxValue) {
						temp[point+i] = 1;
					}
				}
				visited = temp;
				visited[point] = 1;
			}
			
			int answer = 0;
			for(int selected : visited) {
				if(selected == 1) answer += 1;
					
			}
			
			System.out.println("#"+tc+" "+answer);

		}
		
		br.close();
	}
}