import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q056_B1753_최단경로구하기 {
    static int V, E, K;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Edge2>[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt(); // 노드의 개수
        E = sc.nextInt(); // 에지의 개수
        K = sc.nextInt(); // 출발 노드의 번호
        distance = new int[V+1];
        visited = new boolean[V+1];
        A = new ArrayList[V+1];
        for(int i=1;i<=V;i++)
            A[i] = new ArrayList<>();
        for(int i=0;i<=V;i++)
            distance[i] = Integer.MAX_VALUE; // 큰 값

        for(int i=0;i<E;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            A[u].add(new Edge2(v,w));
        }

        PriorityQueue<Edge2> queue = new PriorityQueue<>();
        queue.add(new Edge2(K,0)); // K는 시작점
        distance[K] = 0;
        while(!queue.isEmpty()){
            Edge2 current = queue.poll();
            int currentNode = current.node;
            if(visited[currentNode]) continue;
            visited[currentNode] = true;
            for(int i=0;i<A[currentNode].size();i++){
                Edge2 tmp = A[currentNode].get(i);
                int next = tmp.node;
                int value = tmp.value;
                if(distance[next] > distance[currentNode]+value){
                    distance[next] = distance[currentNode]+value; // 최대값으로 설정해둔 값 보다 작으면 값 변경
                    queue.add(new Edge2(next, distance[next]));
                }
            }
        }

        for(int i=1;i<=V;i++){
            if(visited[i]) System.out.println(distance[i]);
            else System.out.println("INF");
        }
    }
}

class Edge2 implements Comparable<Edge2>{
    int node, value;
    Edge2(int node, int value){
        this.node = node;
        this.value = value;
    }
    public int compareTo(Edge2 e){
        if(this.value > e.value) return 1;
        else return -1;
    }
}
