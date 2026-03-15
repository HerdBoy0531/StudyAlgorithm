import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[2*n+1][n+1][2];
        boolean[][] teacher = new boolean[2*n+1][n+1];

        for(int i=0;i<=2*n;i++){
            for(int j=0;j<=n;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            teacher[x][y] = true;
        }

        dp[0][0][0] = 0;

        for(int x=0;x<2*n;x++){

            for(int y=0;y<=n;y++){

                for(int s=0;s<2;s++){

                    if(dp[x][y][s] == -1) continue;

                    int nx = x+1;

                    for(int dy : new int[]{1,-1}){

                        int ny = y + dy;

                        if(ny < 0 || ny > n) continue;
                        if(ny > Math.min(nx,2*n-nx)) continue;
                        if(teacher[nx][ny]) continue;

                        if(s==0){

                            dp[nx][ny][0] = Math.max(dp[nx][ny][0], dp[x][y][0]);
                            dp[nx][ny][1] = Math.max(dp[nx][ny][1], dp[x][y][0] + ny);

                        }else{

                            dp[nx][ny][1] = Math.max(dp[nx][ny][1], dp[x][y][1]);

                        }
                    }
                }
            }
        }

        int ans = Math.max(dp[2*n][0][0], dp[2*n][0][1]);

        System.out.println(ans);
    }
}