import java.util.Scanner;

public class Q081_B1722_순열의순서구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 자릿수
        int Q = sc.nextInt(); // 보기
        boolean[] visited = new boolean[N+1];
        int[] S = new int[N+1];

        long[] F = new long[N+1];
        F[0] = 1;
        for(int i=1;i<=N;i++)
            F[i] = F[i-1]*i; // 각 자릿수에서 만들 수 있는 경우의 수로 팩토리얼 초기화

        if(Q==1){ // K번째 수열 출력
            long K = sc.nextLong();
            for(int i=1;i<=N;i++){
                for(int j=1,cnt=1;j<=N;j++){
                    if(visited[j]) continue;
                    if(K<=cnt*F[N-i]){ // 현재 순서 < 해당 자리 순열 수 * cnt
                        K -= ((cnt-1)*F[N-i]); // K = 3 - ((1-1)*6)
                        S[i] = j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for(int i=1;i<=N;i++)
                System.out.print(S[i]+" ");
        } else if(Q==2){ // 입력된 순열의 순서 출력
            long K = 1;
            for(int i=1;i<=N;i++){
                S[i] = sc.nextInt();
                long cnt = 0;
                for(int j=1;j<S[i];j++)
                    if(visited[j]==false) cnt++;
                K += cnt * F[N-i];
                visited[S[i]] = true;
            }
            System.out.println(K);
        }
    }
}
