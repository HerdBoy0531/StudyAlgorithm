import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr = br.readLine().split(" ");
		int H = Integer.parseInt(arr[0]);
		int W = Integer.parseInt(arr[1]);
		char[][] sky = new char[H][W];
		// 구름 좌표 입력	
		for(int i = 0; i < H; i++) {
			String[] lst = br.readLine().split("");
			for(int j = 0; j < W; j++) {
				sky[i][j] = lst[j].charAt(0);
			}
		}
		// 구름 위치 확인 및 거리 입력
		int[][] cloud_w = new int[H][W];
		for(int i = 0; i < H; i++) {
			int loc = -1;
			for(int j = 0; j < W; j++) {
				if(sky[i][j] == 'c') {
					loc = j;
					cloud_w[i][j] = 0;
					continue;
				}
				if(sky[i][j] == '.' && loc >= 0) {
					cloud_w[i][j] = j - loc;
				}
				else {
					cloud_w[i][j] = loc;
					continue;
				}
			}
		}
		
		// 출력
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				bw.write(cloud_w[i][j]+" ");
			}
			bw.write("\n");
		}
		
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}