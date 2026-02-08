import java.io.*;

public class Main {
	
	static char mix(char a, char b, char c) {
		char one = 0, two = 0;
		if(a == c) {
			one = b;
			two = a;
		} else if(b == c) {
			one = a;
			two = b;
		} else if(a == b) {
			one = c;
			two = a;
		}
		
		if((two == 'R' && one == 'G') || (two == 'G' && one == 'B') || (two == 'B' && one =='R')) {
			return 'R';
		} else {
			return 'G';
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		
		int n = Integer.parseInt(arr[0]);
		int k = Integer.parseInt(arr[1]);
		
		String str = br.readLine();
		char[] origin = new char[n];
		
		
		for(int i = 0; i < n; i++) {
			origin[i] = str.charAt(i);
		}
		
		while(k != 0) {
			char[] change = new char[n];
			for(int i = 0; i < n; i++) {
				char x = 0, y = 0;
				if(i == 0) {
					x = origin[n-1];
					y = origin[1];
				} else if (i == n-1) {
					x = origin[n-2];
					y = origin[0];
				} else {
					x = origin[i-1];
					y = origin[i+1];
				}
//				System.out.printf("whilexy"+x+" "+y+" "+origin[i]+"// ");
				if(x == origin[i] && y == origin[i] && x == y) {
					change[i] = 'B';
				} else if(x != origin[i] && y != origin[i] && x != y) {
					change[i] = 'B';
				} else {
					change[i] = mix(x, y, origin[i]);
//					System.out.printf("check// ");
				}
			}
			
			origin = change;
			k-=1;
			
//			System.out.println(k);
			for(int i = 0; i < n; i++) {
//				System.out.printf(origin[i] + " ");
			}
		}
		int r = 0;
		int g = 0; 
		int b = 0;
		
		for(int i = 0; i < n; i++) {
			if(origin[i] == 'R') {
				r++;
			} else if(origin[i] == 'G') {
				g++;
			} else if(origin[i] == 'B') {
				b++;
			}
		}
		
		System.out.println(r+" "+g+" "+b);
		
	}

}