import java.util.Scanner;

public class Q083_B1947_선물전달하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long MOD = 1000000000;
        long[] D = new long[1000001];

        D[1] = 0;
        D[2] = 1;
        for(int i=3;i<=N;i++)
            D[i] = (i-1)*(D[i-1]+D[i-2]) % MOD;
        System.out.println(D[N]);
    }
}
