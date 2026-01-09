import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		int cnt = 0;
		
		for(int i = 0; i < st.length(); i++) {
			char ch = st.charAt(i);
			if(ch == 'a' || ch == 'e'|| ch == 'i'|| ch == 'o'|| ch == 'u') {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		br.close();
	}

}
