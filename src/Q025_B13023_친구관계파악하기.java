import java.util.ArrayList;
import java.util.Scanner;

public class Q025_B13023_친구관계파악하기 {
    static boolean arrive;
    static boolean[] visited;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arrive = false;
        visited = new boolean[N];

        arr = new ArrayList[N];
        for(int i=0;i<N;i++)
            arr[i] = new ArrayList<Integer>();

        for(int i=0;i<M;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[s].add(e);
            arr[e].add(s);
        }

        for(int i=0;i<N;i++){
            DFS(i,1);
            if(arrive) break;
        }
        if(arrive)
            System.out.println("1");
        else
            System.out.println("0");

    }

    static void DFS(int num, int depth){
        if(depth==5 || arrive){
            arrive = true;
            return;
        }
        visited[num] = true;
        for(int i : arr[num])
            if(!visited[i])
                DFS(i,depth+1);

        visited[num] = false; // 반복해서 방문하여 depth가 5가 아닌 경우
    }
}
