import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q034_B1744_수묶기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder()); // 양수는 큰 수부터 곱 -> 내림차순
        PriorityQueue<Integer> minus = new PriorityQueue<>(); // 음수는 오름차순

        int one = 0; // 1의 개수
        int zero = 0; // 0의 개수

        for(int i=0;i<N;i++) {
            int data = sc.nextInt();
            if(data>1) plus.add(data);
            else if(data==1) one++;
            else if(data==0) zero++;
            else minus.add(data);
        }

        int sum = 0;
        while(plus.size()>1){
            int a = plus.remove();
            int b = plus.remove();
            sum += a*b;
        }
        if(!plus.isEmpty()) sum += plus.remove();

        while(minus.size()>1){
            int a = minus.remove();
            int b = minus.remove();
            sum += a*b;
        }
        if(!minus.isEmpty())
            if(zero==0) sum += minus.remove();

        sum += one;
        System.out.println(sum);
    }
}
