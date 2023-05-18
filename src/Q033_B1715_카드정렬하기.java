import java.util.PriorityQueue;
import java.util.Scanner;

public class Q033_B1715_카드정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++)
            pq.add(sc.nextInt());

        int sum = 0;
        while(pq.size()>1){
            int data1 = pq.remove();
            int data2 = pq.remove();
            sum += data1 + data2;
            pq.add(data1 + data2);
        }
        System.out.println(sum);
    }
}
