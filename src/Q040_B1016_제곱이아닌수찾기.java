import java.util.Scanner;

public class Q040_B1016_제곱이아닌수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        boolean[] check = new boolean[(int)(max-min+1)];
        for(long i=2;i<=Math.sqrt(max);i++){
            long sqr = i*i;
            long start = min/sqr; // start 인덱스는 최솟값/제곱값으로 구하되 나머지 있을 경우 1을 더해줌
            if(min%sqr!=0) start++;
            for(long j=start;j*sqr<=max;j++)
                check[(int)((j*sqr)-min)] = true;
        }

        int count = 0;
        for(int i=0;i<max-min+1;i++)
            if(!check[i]) count++;
        System.out.println(count);

    }
}
