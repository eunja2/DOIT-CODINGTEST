import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q047_B1325_효율적으로해킹하기 {
    static int N, M;
    static ArrayList<Integer>[] A;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new ArrayList[N+1];
        result = new int[N+1];

        for(int i=1;i<=N;i++)
            A[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            A[start].add(end);
        }

        for(int i=1;i<=N;i++){
            visited = new boolean[N+1];
            BFS(i);
        }

        int max = 0;
        for(int i=1;i<=N;i++)
            if(max<result[i]) max = result[i];
        for(int i=1;i<=N;i++)
            if(result[i]==max) System.out.print(i+ " ");
    }

    static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i : A[now]){
                if(visited[i]==false){
                    visited[i] = true;
                    result[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
