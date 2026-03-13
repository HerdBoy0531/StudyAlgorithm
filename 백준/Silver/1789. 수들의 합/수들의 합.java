import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long s = Long.parseLong(br.readLine());
		
		long sum = 0;
		long i = 1;
		
		while(true) {
			sum += i;
			
			if(sum > s) {
				System.out.println(i - 1);
				break;
			}
			
			i++;
		}
	}
}