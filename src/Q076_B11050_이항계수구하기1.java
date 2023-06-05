import java.util.Scanner;

public class Q076_B11050_이항계수구하기1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] com = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            com[i][1] = i;
            com[i][0] = 1;
            com[i][i] = 1;
        }
        for(int i=2;i<=n;i++)
            for(int j=1;j<i;j++)
                com[i][j] = com[i-1][j]+com[i-1][j-1];

        System.out.println(com[n][k]);
    }
}
