import java.util.PriorityQueue;
import java.util.Scanner;

public class Q014_B11286_절댓값힙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> { // 정렬 기준 명시
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if (first ==  second)
                return o1 > o2 ? 1 : -1; // 절대값 같으면 음수 우선 정렬
            else
                return first - second; // 절대값 기준으로 정렬
        });

        for(int i=0;i<N;i++){
            int put = sc.nextInt();
            if(put == 0){
                if(!queue.isEmpty())
                    System.out.println(queue.poll());
                else
                    System.out.println("0");
            } else {
                queue.add(put);
            }
        }

    }
}
