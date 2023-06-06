import java.util.Scanner;

public class Q080_B13251_조약돌꺼내기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // 색 종류
        int[] D = new int[51];
        int T = 0;
        for(int i=0;i<M;i++) {
            D[i] = sc.nextInt();
            T += D[i];
        }

        int K = sc.nextInt(); // 뽑는 횟수
        double[] poss = new double[51];
        double result = 0.0;
        for(int i=0;i<M;i++) {
            poss[i] = 1.0;
            for (int j = 0; j < K; j++)
                poss[i] *= (double) (D[i] - j) / (T - j);
            result += poss[i];
        }

        System.out.println(result);
    }
}
