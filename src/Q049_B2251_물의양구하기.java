import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q049_B2251_물의양구하기 {
    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1}; // 0->1, 0->2, 1->0 ... 등 여섯가지 이동 케이스 표현
    static boolean[][] visited;
    static boolean[] result;
    static int[] now;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        now = new int[3];
        for(int i=0;i<3;i++)
            now[i] = sc.nextInt();
        visited = new boolean[201][201];
        result = new boolean[201];

        BFS();

        for(int i=0;i<result.length;i++)
            if(result[i]) System.out.print(i+" ");
    }

    static void BFS(){
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        result[now[2]] = true;

        while(!queue.isEmpty()){
            AB tmp = queue.poll();
            int A = tmp.A;
            int B = tmp.B;
            int C = now[2] - A - B;

            for(int k=0;k<6;k++){
                int[] next = {A,B,C};
                next[receiver[k]] += next[sender[k]]; // 다음 단계는 0->1
                next[sender[k]] = 0; // 물 보냈으므로 0으로 만듦
                if(next[receiver[k]] > now[receiver[k]]){ //물이 넘치면
                    next[sender[k]] = next[receiver[k]] - now[receiver[k]]; // 주는 물통은 초과한 만큼 채우기
                    next[receiver[k]] = now[receiver[k]]; // 받는 물통은 최대
                }
                if(!visited[next[0]][next[1]]){ // 물의 양으로 방문했는지 체크
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if(next[0]==0) result[next[2]] = true; // A가 0일 때 C 저장
                }
            }
        }
    }
}

class AB {
    int A, B;
    public AB(int A, int B){
        this.A = A;
        this.B = B;
    }
}
