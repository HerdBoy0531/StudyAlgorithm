import java.io.*;

public class Main {
	static int p, w;
	static int past, cur, idx;
	static char[][] tell;
	
	public static void findNumber(char word) {
		for(int i = 0; i < tell.length; i++) {
			for(int j = 0; j < tell[i].length; j++) {
				if(tell[i][j] == word) {
					cur = i;
					idx = j;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		
		p = Integer.parseInt(arr[0]);
		w = Integer.parseInt(arr[1]);
		cur = 0;
		idx = 0;
		past = -1;
		
		tell = new char[][] {{'A', 'B', 'C'},
							{'D', 'E', 'F'},
							{'G', 'H', 'I'},
							{'J', 'K', 'L'},
							{'M', 'N', 'O'},
							{'P', 'Q', 'R', 'S'},
							{'T', 'U', 'V'},
							{'W', 'X', 'Y', 'Z'}};
		
		int res = 0;
	
		String send = br.readLine();
		
		for(int i = 0; i < send.length(); i++) {
			char word = send.charAt(i);
			if(word == ' ') {
				res += p;
				past = -1;
				continue;
						}
			else {
				findNumber(word);
				if(cur == past) {
					res += w;
				}
				res += (idx + 1) * p;
			}
			past = cur;
		}
		
		System.out.println(res);
		

	}

}