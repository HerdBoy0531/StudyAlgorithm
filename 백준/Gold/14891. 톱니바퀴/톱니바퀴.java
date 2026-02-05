import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static char[][] gear;
	static int[] dir;
	
	public static void rotate() {
        for (int i = 0; i < 4; i++) {
            if (dir[i] == 0) continue;

            if (dir[i] == 1) {
                char temp = gear[i][7];
                for (int j = 7; j > 0; j--) {
                    gear[i][j] = gear[i][j - 1];
                }
                gear[i][0] = temp;
            } else {
                char temp = gear[i][0];
                for (int j = 0; j < 7; j++) {
                    gear[i][j] = gear[i][j + 1];
                }
                gear[i][7] = temp;
            }
        }
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		gear = new char[4][8];
		
		for(int i = 0; i < 4; i++) {
			String str = br.readLine();
			for(int j = 0; j < 8; j++) {
				gear[i][j] = str.charAt(j);
			}
		}
		
		
		
		int k = Integer.parseInt(br.readLine());
		while(k-- > 0) {
			dir = new int[4];
			
			st = new StringTokenizer(br.readLine());
			int n =Integer.parseInt(st.nextToken()) - 1;
			int m =Integer.parseInt(st.nextToken());
			
			dir[n] = m;
			
			for(int i = n; i > 0; i--) {
				if(gear[i][6] != gear[i-1][2]) {
					dir[i-1] = -dir[i];
				} else break;
			}
			
			for(int i = n; i < 3; i++) {
				if(gear[i+1][6] != gear[i][2]) {
					dir[i+1] = -dir[i];
				} else break;
			}
			
			rotate();
			
		}
		
		int res = 0;
		for(int i = 0; i < 4; i++) {
			if(gear[i][0] == '1') {
				res += Math.pow(2, i);
			}
		}
		System.out.println(res);
		
	}

}