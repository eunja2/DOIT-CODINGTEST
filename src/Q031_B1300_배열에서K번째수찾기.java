import java.util.Scanner;

public class Q031_B1300_배열에서K번째수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long start = 1;
        long end = K;
        long answer = 0;

        while(start<=end){
            long middle = (start+end)/2;
            long count = 0; // 중앙값 보다 작은 수 세기
            for(int i=1;i<=N;i++)
                count += Math.min(middle/i,N);
            if(count<K)
                start = middle + 1;
            else {
                answer = middle;
                end = middle - 1;
            }
        }
        System.out.println(answer);
    }
}
