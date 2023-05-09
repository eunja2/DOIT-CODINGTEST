import java.util.Scanner;

public class Q002_B1546_평균구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 과목 수
        int[] score = new int[N];
        for(int i=0;i<N;i++)
            score[i] = sc.nextInt();

        int M = score[0];
        for(int i=0;i<N;i++)
            if(score[i]>M)
                M = score[i];

        float sum = 0;
        float avg = 0;
        for(int i=0;i<N;i++)
            sum += score[i]/M*100;

        avg = sum/N;
        System.out.printf("%f", avg);
    }
}
