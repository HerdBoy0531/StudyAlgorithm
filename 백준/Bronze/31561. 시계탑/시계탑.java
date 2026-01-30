import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double time = Double.parseDouble(br.readLine());
		double res = 0;
		
		if(time > 0 && time <= 30) {
			res = time / 2;
		} else if(time <= 59 && time > 30) {
			res = time / 2;
			res = res * 3 - 30;
		}
		System.out.println(res);
	}

}