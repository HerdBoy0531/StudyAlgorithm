import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] arr = new String[10][10];

        for(int i = 0; i < 10; i++) {
            String[] lst = br.readLine().split(" ");
            for(int j = 0; j < 10; j++) {
                arr[i][j] = lst[j];
            }
        }

        for(int i = 0; i < 10; i++) {
            boolean same = true;
            for(int j = 1; j < 10; j++) {
                if(!arr[i][j].equals(arr[i][0])) {
                    same = false;
                    break;
                }
            }
            if(same) {
                System.out.println(1);
                return;
            }
        }

        for(int i = 0; i < 10; i++) {
            boolean same = true;
            for(int j = 1; j < 10; j++) {
                if(!arr[j][i].equals(arr[0][i])) {
                    same = false;
                    break;
                }
            }
            if(same) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}