import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String mobis = br.readLine();
		boolean[] check = new boolean[5];
		
		for(int i = 0; i < mobis.length(); i++) {
			if(mobis.charAt(i) == 'M') check[0] = true;
			if(mobis.charAt(i) == 'O') check[1] = true;
			if(mobis.charAt(i) == 'B') check[2] = true;
			if(mobis.charAt(i) == 'I') check[3] = true;
			if(mobis.charAt(i) == 'S') check[4] = true;
		}
		
		boolean res = true;
		for(int i = 0; i < 5; i++) {
			if(check[i] != true) res = false; 
		}
		
		if(res) System.out.printf("YES");
		else System.out.printf("NO");
		
		
		
		br.close();
	}

}