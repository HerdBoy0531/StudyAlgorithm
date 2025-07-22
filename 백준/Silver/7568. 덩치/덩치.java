import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int man = Integer.parseInt(br.readLine());
		// 등수 등록
		int[] rank = new int[man];
		// 각 차례별 몸무게, 키 등록
		int[] weight = new int[man];
		int[] height = new int[man];
		for(int i = 0; i < man; i++) {
			String[] arr = br.readLine().split(" ");
			weight[i] = Integer.parseInt(arr[0]);
			height[i] = Integer.parseInt(arr[1]);
		}
		// 몸무게 키 비교
		for(int i = 0; i < man; i++) {
			int cnt = 1;
			for(int j = 0; j < man; j++) {
				if(weight[i] < weight[j] && height[i] < height[j]) {
					cnt++;
				}
			}
			rank[i] = cnt;
		}
		
		// 출력
		for(int i = 0; i < man; i++) {
			bw.write(rank[i]+" ");
		}
		
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}