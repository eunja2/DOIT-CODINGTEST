import java.util.Scanner;

public class Q063_B1389_케빈베이컨의6단계법칙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] distance = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==j) distance[i][j]=0;
                else distance[i][j]=10000001; // 나중에 Min과 비교해야 하므로 Integer.MAX_VALUE 대입하면 안 됨
            }
        }

        for(int i=0;i<M;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            distance[start][end] = 1;
            distance[end][start] = 1;
        }

        // 플로이드-워셜 알고리즘
        for(int i=1;i<=N;i++)
            for(int j=1;j<=N;j++)
                for(int k=1;k<=N;k++)
                    if(distance[j][k] > distance[j][i] + distance[i][k])
                        distance[j][k] = distance[j][i] + distance[i][k];

        int Min = Integer.MAX_VALUE;
        int result = -1;
        for(int i=1;i<=N;i++){
            int temp = 0; // 각 행의 합
            for(int j=1;j<=N;j++)
                temp += distance[i][j];
            if(Min>temp){
                Min = temp;
                result = i;
            }
        }

        System.out.println(result);
    }
}
