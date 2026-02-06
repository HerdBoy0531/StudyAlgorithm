import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		int len = num.length();
		int mod = len % 3;
		
		if(mod == 1) num = "00" + num;
		else if(mod == 2) num = "0"+num;
		
		for(int i = 0; i < num.length(); i+=3) {
			String part = num.substring(i, i + 3);
			
			int value = (part.charAt(0) - '0') * 4
						+ (part.charAt(1) - '0') * 2
						+ (part.charAt(2) - '0') * 1;
			
			sb.append(value);
		}
		
		while(sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		
		System.out.println(sb);

	}

}