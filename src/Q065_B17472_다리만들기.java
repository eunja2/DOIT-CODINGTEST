import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q065_B17472_다리만들기 {
    static int N, M;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited; // BFS에서 사용할 방문 여부
    static int sNum; // 1개의 섬 정보(섬의 개수)
    static ArrayList<ArrayList<int[]>> sumlist; // 모든 섬 정보
    static ArrayList<int[]> mlist; // 1개의 섬 정보
    static PriorityQueue<bEdge> queue; // 다리 정보 저장할 우선순위큐
    static int[] parent; // 유니온 파인드 위한 대표 노드 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행렬 가로 크기
        M = Integer.parseInt(st.nextToken()); // 행렬 세로 크기
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        sNum = 1;
        sumlist = new ArrayList<>();
        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++)
                if(map[i][j] != 0 && visited[i][j] != true){
                    BFS(i, j);
                    sNum++;
                    sumlist.add(mlist); // 각 섬들을 저장
                }

        queue = new PriorityQueue<>();
        for(int i=0;i<sumlist.size();i++){
            ArrayList<int[]> now = sumlist.get(i);
            for(int j=0;j<now.size();j++){
                int r = now.get(j)[0];
                int c = now.get(j)[1];
                int now_S = map[r][c];
                for(int d=0;d<4;d++){ // 4 방향
                    int tempR = dr[d];
                    int tempC = dc[d];

                    int blength = 0; // 다리 길이
                    while(r+tempR >= 0 && r+tempR < N &&  c+tempC >= 0 && c+tempC < M){
                        if(map[r+tempR][c+tempC] == now_S) break; // 같은 섬이면 에지 만들 수 없음
                        else if(map[r+tempR][c+tempC] != 0){ // 같은 섬, 바다 아니면
                            if(blength>1)
                                queue.add(new bEdge(now_S,map[r+tempR][c+tempC],blength)); // 다리의 길이 1 이상이면 에지로 더하기
                            break;
                        } else blength++;

                        if(tempR < 0) tempR--; // 탐색 범위 넓히기
                        else if(tempR > 0) tempR++;
                        else if(tempC < 0) tempC--;
                        else if(tempC > 0) tempC++;
                    }
                }
            }
        }

        parent  = new int[sNum]; // 섬의 수
        for(int i=0;i<parent.length;i++)
            parent[i] = i; // 초기화
        int useEdge = 0; // 에지의 개수
        int result = 0;
        while(!queue.isEmpty()){
            bEdge now = queue.poll();
            if(find(now.s) != find(now.e)){ // 같은 부모가 아니면 연결
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
        }

        if(useEdge == sNum-2) // 에지의 개수 = 노드의 개수 -1
            System.out.println(result);
        else
            System.out.println(-1);
    }

    private static void BFS(int i, int j){ // 섬 영역 지정
        Queue<int[]> queue = new LinkedList<>();
        mlist = new ArrayList<>();
        int[] start = {i, j};
        queue.add(start);
        mlist.add(start);
        visited[i][j] = true;
        map[i][j] = sNum; // 하나의 섬 -> 하나의 숫자로 (1부터 시작)
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int r = now[0]; // i
            int c = now[1]; // j
            for(int d=0;d<4;d++){ // 4 방향
                int tempR = dr[d];
                int tempC = dc[d];
                while(r+tempR >= 0 && r+tempR < N && c+tempC >= 0 && c+tempC < M){ // 행렬 벗어나지 않는 범위에서
                    if(!visited[r+tempR][c+tempC] && map[r+tempR][c+tempC] != 0) { // 방문한 적 없고 바다 아니면 같은 섬
                        addNode(r + tempR, c + tempC, queue); // 위치를 섬으로 등록
                    } else break;

                    if(tempR < 0) tempR--; // 탐색 범위 넓히기
                    else if(tempR > 0) tempR++;
                    else if(tempC < 0) tempC--;
                    else if(tempC > 0) tempC++;
                }
            }
        }
    }

    private static void addNode(int i, int j, Queue<int[]> queue){
        map[i][j] = sNum;
        visited[i][j] = true;
        int[] temp = {i, j};
        mlist.add(temp);
        queue.add(temp);
    }

    private static int find(int a){
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }

    private static void union(int s, int e){
        if(find(s) != find(e))
            parent[e] = s;
    }
}

class bEdge implements Comparable<bEdge>{
    int s,e,v;
    bEdge(int s, int e, int v){
        this.s = s; // start
        this.e = e; // end
        this.v = v; // 길이
    }

    @Override
    public int compareTo(bEdge o){
        return this.v - o.v;
    }
}