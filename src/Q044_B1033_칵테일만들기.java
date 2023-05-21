import java.util.ArrayList;
import java.util.Scanner;

public class Q044_B1033_칵테일만들기 {
    static ArrayList<myNode>[] A; // 인접 리스트
    static boolean[] visited;
    static long[] D; // 각 노드값
    static long lcm;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1; // 최소공배수

        for(int i=0;i<N;i++)
            A[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            A[a].add(new myNode(b, p, q));
            A[b].add(new myNode(a, q, p));
            lcm *= (p * q / gcd(p,q)); // 최소공배수 = 두 수의 곱 / 최대공약수
        }

        D[0] = lcm;
        DFS(0);
        // 각 노드의 값을 모든 노드의 최대공약수로 나누기
        long gcdNum = D[0];
        for(int i=1;i<N;i++)
            gcdNum = gcd(gcdNum,D[i]);

        for(int i=0;i<N;i++)
            System.out.print(D[i] / gcdNum + " ");

    }

    static long gcd(long p, long q){
        if(q==0) return p;
        else return gcd(q, p%q);
    }

    static void DFS(int node){
        visited[node] = true;
        for(myNode i : A[node]){
            int next = i.getB();
            if(!visited[next]){
                D[next] = D[node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }
}

class myNode {
    int b,p,q;
    public myNode(int b, int p, int q){
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }
    public int getB(){ return b; }
    public int getP(){ return p; }
    public int getQ(){ return q; }
}
