import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q054_B1516_게임개발하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i=0;i<=N;i++)
            A.add(new ArrayList<>());

        int[] indegree = new int[N+1];
        int[] builtTime = new int[N+1];
        for(int i=1;i<=N;i++){
            builtTime[i] = sc.nextInt();
            while(true){
                int prev = sc.nextInt();
                if(prev==-1) break;
                A.get(prev).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++)
            if(indegree[i]==0) queue.offer(i);
        int[] result = new int[N+1];
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int next : A.get(now)) { // i=0도 반복하기 때문에 위쪽에서 A에 ArrayList를 i=0부터 생성
                indegree[next]--;
                result[next] = Math.max(result[next], result[now]+builtTime[now]);
                if(indegree[next]==0) queue.offer(next);
            }
        }

        for(int i=1;i<=N;i++)
            System.out.println(result[i]+builtTime[i]);
    }
}
