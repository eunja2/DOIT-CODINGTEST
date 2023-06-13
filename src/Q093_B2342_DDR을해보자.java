import java.util.Scanner;

public class Q093_B2342_DDR을해보자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int DP[][][] = new int[100001][5][5];
        int mp[][] = {  {0, 2, 2, 2, 2}, // [0][0] : 0->0, [0][1] : 0->1
                        {2, 1, 3, 4, 3},
                        {2, 3, 1, 3, 4},
                        {2, 4, 3, 1, 3},
                        {2, 3, 4, 3, 1} };

        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++)
                for(int k=0;k<100001;k++)
                    DP[k][i][j] = 100001*4; // 충분히 큰 수로 초기화

        DP[0][0][0] = 0;
        int S = 1; // 수행한 인풋의 개수
        while(true){
            int N = sc.nextInt();
            if(N==0) break;
            for(int i=0;i<5;i++){ // 오른발이동
                if(N==i) continue;
                for(int j=0;j<5;j++)
                    DP[S][i][N] = Math.min(DP[S-1][i][j] + mp[j][N], DP[S][i][N]);
            }
            for(int i=0;i<5;i++){ // 왼발이동
                if(N==i) continue;
                for(int j=0;j<5;j++)
                    DP[S][N][i] = Math.min(DP[S-1][j][i] + mp[j][N], DP[S][N][i]);
            }
            S++;
        }
        S--;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++)
                min = Math.min(min, DP[S][i][j]);
        System.out.println(min);
    }
}
