import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean flag = true;
		while(flag = true) {
		String st = br.readLine();
		if(st.charAt(0) == '#') {
			flag = false;
			break;
		}
		int res = 0; 
		for(int i = 0; i < st.length(); i++) {
			if(st.charAt(i) == 'a' || st.charAt(i) == 'o'||st.charAt(i) == 'u'||st.charAt(i) == 'i'||st.charAt(i) == 'e'||st.charAt(i) == 'A' || st.charAt(i) == 'O'||st.charAt(i) == 'U'||st.charAt(i) == 'I'||st.charAt(i) == 'E') {
				res++;
			}
		}
		System.out.println(res);
		
		}
	}

}
