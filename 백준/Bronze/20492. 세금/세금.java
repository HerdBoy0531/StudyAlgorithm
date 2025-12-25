import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(br.readLine());
		double first = money * 0.78;
		double second = money * 0.8 + money * 0.2 * 0.78;
		
		System.out.println((long)Math.floor(first) + " " + (long)Math.floor(second));
	}

}