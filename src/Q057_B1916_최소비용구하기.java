import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q057_B1916_최소비용구하기 {
    static int N, M;
    static ArrayList<Node>[] A;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        A = new ArrayList[N+1];
        distance = new int[N+1];
        visited = new boolean[N+1];

        /*for(int i=0;i<=N;i++)
            distance[i] = Integer.MAX_VALUE;*/
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i=0;i<=N;i++)
            A[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            A[start].add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int startIdx = Integer.parseInt(st.nextToken());
        int endIdx = Integer.parseInt(st.nextToken());

        bw.write(dijksta(startIdx, endIdx)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int dijksta(int s, int e){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        distance[s] = 0;

        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            int now = nowNode.targetNode;
            if(!visited[now]){
                visited[now] = true;
                for(Node i : A[now]){
                    if(!visited[i.targetNode] && distance[i.targetNode] > distance[now] + i.value){
                        distance[i.targetNode] = distance[now] + i.value;
                        pq.add(new Node(i.targetNode, distance[i.targetNode]));
                    }
                }
            }
        }
        return distance[e];
    }
}

class Node implements Comparable<Node>{
    int targetNode;
    int value;
    Node(int targetNode, int value){
        this.targetNode = targetNode;
        this.value = value;
    }
    @Override
    public int compareTo(Node o){
        return value-o.value;
    }
}
