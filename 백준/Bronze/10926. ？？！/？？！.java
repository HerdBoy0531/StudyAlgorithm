import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arr = br.readLine();
		StringBuilder sb = new StringBuilder(arr + "??!");
		System.out.println(sb.toString());
		
		br.close();
	}

}
