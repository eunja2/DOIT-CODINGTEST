import java.util.Arrays;
import java.util.Scanner;

public class Q059_B11657_타임머신 {
    static int N, M;
    static Edge3[] A;
    static long[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new Edge3[M+1];
        distance = new long[N+1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i=0;i<M;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int time = sc.nextInt();
            A[i] = new Edge3(start, end, time);
        }

        distance[1] = 0;
        for(int i=1;i<N;i++){
            for(int j=0;j<M;j++){
                Edge3 e = A[j];
                if(distance[e.start] != Integer.MAX_VALUE
                        && distance[e.end] > distance[e.start] + e.time){
                    distance[e.end] = distance[e.start] + e.time;
                }
            }
        }
        boolean cycle = false; // 음수 사이클 확인
        for(int i=0;i<M;i++){
            Edge3 e = A[i];
            if(distance[e.start] != Integer.MAX_VALUE
                    && distance[e.end] > distance[e.start] + e.time){
                cycle = true;
            }
        }

        if(!cycle){
            for(int i=2;i<=N;i++){
                if(distance[i] == Integer.MAX_VALUE)
                    System.out.println("-1");
                else
                    System.out.println(distance[i]);
            }
        } else
            System.out.println("-1");
    }
}

class Edge3 {
    int start, end, time;
    public Edge3(int start, int end, int time){
        this.start = start;
        this.end = end;
        this.time = time;
    }
}
