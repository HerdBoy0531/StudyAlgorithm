import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int joi = 0;
		int ioi = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(i > 0 && i < str.length()-1 && str.charAt(i) == 'O') {
				if(str.charAt(i-1) == 'J' && str.charAt(i+1) == 'I') {
					joi++;
				}
				else if(str.charAt(i-1) == 'I' && str.charAt(i+1) == 'I') {
					ioi++;
				}
			}
		}
		
		System.out.println(joi);
		System.out.println(ioi);

	}

}