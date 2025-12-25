import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int hongYear = Integer.parseInt(br.readLine());
		int var = hongYear - 1946;
		System.out.print(var);

	}

}
