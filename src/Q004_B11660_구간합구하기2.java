import java.util.Scanner;

public class Q004_B11660_구간합구하기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] nums = new int[N+1][N+1];

        for(int i=1;i<=N;i++)
            for(int j=1;j<=N;j++)
                nums[i][j] = sc.nextInt();

        int[][] sums = new int[N+1][N+1];
        for(int i=1;i<=N;i++)
            for(int j=1;j<=N;j++)
                    sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + nums[i][j];

        while(M>0){
            int X1 = sc.nextInt();
            int Y1 = sc.nextInt();
            int X2 = sc.nextInt();
            int Y2 = sc.nextInt();

            int result = sums[X2][Y2] - sums[X1-1][Y2] - sums[X2][Y1-1] + sums[X1-1][Y1-1];
            System.out.println(result);
            M--;
        }
    }
}
