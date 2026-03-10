import java.io.*;

public class Main {

	static int n, k;
	static int count(int num) {
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			cnt += Math.min(num/i, n);
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		int left = 1;
		int right = k;
		int answer = 0;
		
		while(right >= left) {
			int mid = (right + left)/2;
			
			if(count(mid) >= k) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(answer);

	}

}