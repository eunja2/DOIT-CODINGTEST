import java.util.*;

public class Q046_B18352_특정거리의도시찾기 {
    static int N, M, K, X;
    static List<Integer>[] A;
    static List<Integer> result;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        A = new ArrayList[N+1];
        result = new ArrayList<>();

        for(int i=1;i<=N;i++)
            A[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            A[start].add(end);
        }

        visited = new int[N+1];
        for(int i=0;i<=N;i++)
            visited[i] = -1;

        BFS(X);

        for(int i=0;i<=N;i++)
            if(visited[i]==K) result.add(i);

        if(result.isEmpty()) System.out.println("-1");
        else {
            Collections.sort(result);
            for(int i : result)
                System.out.println(i);
        }
    }

    private static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]++;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i : A[now]){
                if(visited[i] == -1){
                    visited[i] = visited[now]+1;
                    queue.add(i);
                }
            }
        }
    }
}
