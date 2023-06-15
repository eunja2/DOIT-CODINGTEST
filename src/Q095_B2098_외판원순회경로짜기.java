import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q095_B2098_외판원순회경로짜기 {
    static final int INF = 1000000*16+1; // ?
    static int N;
    static int[][] D;
    static int[][] W;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine().trim());
        W = new int[16][16];
        D = new int[16][1<<16];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0;j<N;j++)
                W[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(tsp(0,1));
    }

    private static int tsp(int c, int v){
        if(v == (1<<N)-1)
            return W[c][0] == 0 ? INF : W[c][0]; // 모든 도시 순회했는데 출발도시로 돌아올 수 없으면 무한대 -> 정답 X
        if(D[c][v] != 0)
            return D[c][v]; // 방문한 노드일 때 바로 리턴
        int min_val = INF;
        for(int i=0;i<N;i++)
            if((v & (1<<i)) == 0 && W[c][i] != 0) // 방문한 적 없고, 갈 수 있는 도시일 때
                min_val = Math.min(min_val, tsp(i,(v|(1<<i))) + W[c][i]); // 방문 도시로 저장하고 현재 도시가 i일 때 남은 모든 도시 경유하는데 드는 최소 비용 + c에서 i로 가기 위한 비용
        D[c][v] = min_val;
        return D[c][v];
    }
}
