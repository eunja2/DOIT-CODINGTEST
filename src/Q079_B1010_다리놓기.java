import java.util.Scanner;

public class Q079_B1010_다리놓기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] com = new int[30+1][30+1];
        for(int i=0;i<=30;i++){
            com[i][1] = i;
            com[i][0] = 1;
            com[i][i] = 1;
        }
        for(int i=2;i<=30;i++)
            for(int j=1;j<i;j++)
                com[i][j] = com[i-1][j] + com[i-1][j-1];

        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(com[M][N]);
        }
    }
}
