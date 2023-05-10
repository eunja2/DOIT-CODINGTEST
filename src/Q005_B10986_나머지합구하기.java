import java.util.Scanner;

public class Q005_B10986_나머지합구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] nums = new long[N];
        for(int i=0;i<N;i++)
            nums[i] = sc.nextInt();

        long[] sums = new long[N];
        sums[0] = nums[0];
        for(int i=1;i<N;i++)
            sums[i] = sums[i-1] + nums[i];

        long[] count = new long[M]; // 가능한 나머지 0,1,2(3개)
        long answer = 0;
        for(int i=0;i<N;i++) {
            int remainder = (int) sums[i]%M;
            if(remainder==0) answer++;
            count[remainder]++;
        }
        for(int i=0;i<M;i++){
            if(count[i]>1){ // 나머지가 같은 인덱스 중 2개 뽑는 경우의 수 더하기
                answer += count[i]*(count[i]-1)/2;
            }
        }
        System.out.println(answer);
    }
}
