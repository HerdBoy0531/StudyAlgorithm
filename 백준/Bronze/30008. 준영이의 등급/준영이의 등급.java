import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] D = new int[K];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			double G = Double.parseDouble(st.nextToken());
			G = (int)(G / N * 100);
			if(G >= 0 && G <= 4) D[i] = 1;
			else if(G > 4 && G <= 11) D[i] = 2;
			else if(G > 11 && G <= 23) D[i] = 3;
			else if(G > 23 && G <= 40) D[i] = 4;
			else if(G > 40 && G <= 60) D[i] = 5;
			else if(G > 60 && G <= 77) D[i] = 6;
			else if(G > 77 && G <= 89) D[i] = 7;
			else if(G > 89 && G <= 96) D[i] = 8;
			else if(G > 96 && G <= 100) D[i] = 9;
		}
		
		for(int i = 0; i < D.length; i++) {
			System.out.printf(D[i]+" ");
		}

	}

}