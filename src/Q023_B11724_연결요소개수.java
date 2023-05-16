import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q023_B11724_연결요소개수 {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1;i<N+1;i++)
            arr[i] = new ArrayList<>(); // 인접 리스트 초기화

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e); // ex) 1->2, 2->1
            arr[e].add(s);
        }
        int count = 0;
        for(int i=1;i<N+1;i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    static void DFS(int i){
        if (visited[i]) return;
        visited[i] = true;
        for(int j : arr[i])
            if(visited[j]==false)
                DFS(j);
    }
}
