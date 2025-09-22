import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char res = str.charAt(0);
		if(res == 'M') System.out.printf("MatKor");
		else if(res == 'W') System.out.printf("WiCys");
		else if(res == 'C') System.out.printf("CyKor");
		else if(res == 'A') System.out.printf("AlKor");
		else if(res == '$') System.out.printf("$clear");
		
		br.close();
	}

}