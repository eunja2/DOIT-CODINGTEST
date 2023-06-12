import java.util.Scanner;

public class Q087_B11726_2N타일채우기   {
    public static void main(String[] args) {
        int MOD = 10007;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] D = new long[10007];
        D[1] = 1;
        D[2] = 2;
        for(int i=3;i<=N;i++)
            D[i] = (D[i-1] + D[i-2]) % MOD;

        System.out.println(D[N]);
    }
}
