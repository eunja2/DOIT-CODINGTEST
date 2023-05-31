import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q066_B1414_불우이웃돕기 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int sum = 0;
        PriorityQueue<lEdge> queue = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
//            char[] temp = sc.nextLine().toCharArray();
            char[] temp = st.nextToken().toCharArray();
            for(int j=0;j<N;j++){
                int tempInt = 0;
                if(temp[j]>='a' && temp[j]<='z') tempInt = temp[j] - 'a' + 1;
                else if(temp[j]>='A' && temp[j]<='Z') tempInt = temp[j] -'A' + 27;
                sum += tempInt;
                if(i!=j && tempInt!=0) queue.add(new lEdge(i, j, tempInt));
            }
        }

        parent = new int[N]; // 대표 노드 저장
        for(int i=0;i<parent.length;i++)
            parent[i] = i;
        int useEdge = 0; // 에지의 개수 -> N-1개 체크
        int result = 0; // 랜선의 길이
        while(!queue.isEmpty()){
            lEdge now = queue.poll();
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
        }

        if(useEdge == N-1) System.out.println(sum-result);
        else System.out.println(-1);
    }

    private static int find(int i){
        if(i==parent[i]) return i;
        else return parent[i] = find(parent[i]);
    }

    private static void union(int i, int j){
        if(find(i) != find(j)) parent[j] = i;
    }
}

class lEdge implements Comparable<lEdge>{
    int s, e, v;
    lEdge(int s, int e, int v){
        this.s = s;
        this.e = e;
        this.v = v;
    }
    @Override
    public int compareTo(lEdge o){
        return this.v-o.v;
    }
}
