import java.util.*;

public class Q028_B1167_트리의지름 {
    static int N;
    static ArrayList<Edge>[] A;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new ArrayList[N+1]; // 에지 1로 시작
        for(int i=1;i<N+1;i++)
            A[i] = new ArrayList<>();

        for(int i=0;i<N;i++){
            int s = sc.nextInt();
            while(true){
                int e = sc.nextInt();
                if(e==-1) break;
                int v = sc.nextInt();
                A[s].add(new Edge(e,v));
            }
        }
        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(1);

        int Max = 1;
        for(int i=2;i<N+1;i++)
            if(distance[Max]<distance[i])
                Max = i;

        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(Max);

        Arrays.sort(distance); // 오름차순
        System.out.println(distance[N]); // 가장 큰 수 출력
    }

    static void BFS(int idx){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        visited[idx] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(Edge i : A[now]){
                int e = i.e;
                int v = i.value;
                if(!visited[e]){ // 방문하지 않은 에지의 경우
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now]+v;
                }
            }
        }
    }
}

class Edge {
    int e;
    int value;

    public Edge(int e, int value){
        this.e = e;
        this.value = value;
    }
}
