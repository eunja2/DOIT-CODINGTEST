import java.util.Scanner;

public class Q030_B2343_블루레이만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];

        int start = 0, end = 0;
        for(int i=0;i<N;i++) {
            A[i] = sc.nextInt();
            if(start<A[i]) start = A[i];
            end += A[i];
        }
        while(start<=end){
            int midi = (start+end)/2;
            int sum = 0;
            int count = 0; // 블루레이 개수
            for(int i=0;i<N;i++){
                if(sum+A[i] > midi){ // middle 값으로 모든 레슨 저장 불가
                    count++;
                    sum = 0;
                }
                sum += A[i];
            }
            if(sum!=0) count++; // 탐색 후 sum이 0이 아니면 블루레이 1개 더 필요
            if(count > M) start = midi + 1;
            else end = midi - 1;
        }
        System.out.println(start);
    }
}
