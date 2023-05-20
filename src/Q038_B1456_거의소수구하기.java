import java.util.Scanner;

public class Q038_B1456_거의소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        long[] A = new long[10000000+1];
        for(int i=2;i<A.length;i++)
            A[i] = i;

        // 소수 구하기
        for(int i=2;i<=Math.sqrt(A.length);i++) {
            if (A[i] == 0) continue;
            for(int j=i+i;j<A.length;j+=i) // 배수 지우기
                A[j] = 0;
        }

        // 거의 소수 구하기
        int count = 0;
        for(int i=2;i<A.length;i++){
            if(A[i]!=0){
                long temp = A[i];
                while((double)A[i]<=(double)max/(double)temp){ // A[i]^k <= max
                    if((double)A[i]>=(double)min/(double)temp) // A[i]^k >= min
                        count++;
                    temp = temp * A[i];
                }
            }
        }
        System.out.println(count);
    }
}
