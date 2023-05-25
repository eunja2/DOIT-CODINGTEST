import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q053_B2252_줄세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i=0;i<=N;i++)
            A.add(new ArrayList<>());

        int[] indegree = new int[N+1];
        for(int i=0;i<M;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            A.get(start).add(end);
            indegree[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++)
            if(indegree[i]==0) queue.offer(i); // 차수 0인 노드 선택하여 위상정렬 배열에 저장
        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now+" ");
            for(int next : A.get(now)){
                indegree[next]--;
                if(indegree[next]==0) queue.offer(next); // 감소했을 때 진입 차수가 0이 되는 노드를 큐에 offer
            }
        }
    }
}
