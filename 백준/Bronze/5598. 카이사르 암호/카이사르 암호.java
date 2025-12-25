import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String Caesar = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < Caesar.length(); i++) {
			char word;
			if(Caesar.charAt(i) - 'A' == 0) word = 'X';
			else if(Caesar.charAt(i) - 'A' == 1) word = 'Y';
			else if(Caesar.charAt(i) - 'A' == 2) word = 'Z';
			else word = (char)(Caesar.charAt(i) - 3);
			sb.append(word);
		}
		System.out.printf(sb.toString());

	}

}