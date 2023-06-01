import java.util.PriorityQueue;
import java.util.Scanner;

public class Q064_B1197_최소신장트리구하기 {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 노드 수
        int M = sc.nextInt(); // 에지 수
        PriorityQueue<sEdge> queue = new PriorityQueue<>(); // 자동정렬 위한 우선순위 큐
        parent = new int[N+1];
        for(int i=0;i<N;i++)
            parent[i] = i; // 유니온 파인드용 부모노드 초기화
        for(int i=0;i<M;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            queue.add(new sEdge(s,e,v));
        }

        int useEdge = 0; // 사용 에지 수
        int result = 0; // 가중치 합
        while(useEdge < N-1){
            sEdge now = queue.poll();
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                useEdge++;
                result += now.v;
            }
        }
        System.out.println(result);
    }

    static int find(int a){
        if(a==parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }

    static void union(int a, int b){
        if(find(a) != find(b)) parent[b] = a;
    }
}

class sEdge implements Comparable<sEdge>{
    int s, e, v;
    sEdge(int s, int e, int v){
        this.s = s;
        this.e = e;
        this.v = v;
    }
    @Override
    public int compareTo(sEdge o){ // 가중치를 기준으로 오름차순 정렬
        return this.v - o.v;
    }
}
