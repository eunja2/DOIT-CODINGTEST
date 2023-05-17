import java.util.*;

public class Q026_B1260_DFS와BFS {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();

        arr = new ArrayList[N+1];
        for(int i=1;i<=N;i++)
            arr[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[s].add(e);
            arr[e].add(s);
        }

        for(int i=1;i<=N;i++)
            Collections.sort(arr[i]);

        visited = new boolean[N+1];
        DFS(start);
        System.out.println();
        visited = new boolean[N+1];
        BFS(start);
        System.out.println();
    }

    public static void DFS(int start){
        System.out.print(start + " ");
        visited[start] = true;
        for(int i : arr[start])
            if(!visited[i])
                DFS(i);
    }

    public static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now + " ");
            for(int i : arr[now])
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }

        }
    }
}
