import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb1, sb2;
		int n = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < n; tc++) {
			String str = br.readLine();
			sb1 = new StringBuilder();
			sb2 = new StringBuilder();
			for(int i = 0 ; i < str.length(); i++) {
				if(i%2 == 0) {
					sb1.append(str.charAt(i));
				} else {
					sb2.append(str.charAt(i));
				}
			}
			if(str.length()%2 != 0) {
				for(int i = 0 ; i < str.length(); i++) {
					if(i%2 == 0) {
						sb2.append(str.charAt(i));
					} else {
						sb1.append(str.charAt(i));
					}
				}
			}
			
			System.out.println(sb1);
			System.out.println(sb2);
		}
		
		
	}

}