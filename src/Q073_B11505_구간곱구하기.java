import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q073_B11505_구간곱구하기 {
    static long[] tree;
    static int MOD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 변경 횟수
        int K = Integer.parseInt(st.nextToken()); // 구간곱 횟수
        int treeHeight = 0;
        int length = N;
        while(length != 0){
            length /= 2;
            treeHeight++;
        }
        int treeSize = (int)Math.pow(2, treeHeight+1);
        int treeStart = (int)Math.pow(2, treeHeight);
        MOD = 1000000007;
        tree = new long[treeSize+1];
        for(int i=0;i<tree.length;i++)
            tree[i] = 1; // 곱셈이므로 1로 초기화
        for(int i=treeStart;i<treeStart+N;i++)
            tree[i] = Long.parseLong(br.readLine());
        setTree(treeSize-1);

        for(int i=0;i<M+K;i++){
            st =  new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if(a==1){ // s번째 수를 e로 변경
                changeVal(treeStart+s-1, e);
            } else if(a==2){
                s += treeStart-1;
                e += treeStart-1;
                System.out.println(getMul(s,(int)e));
            } else
                return;
        }
        br.close();
    }

    private static long getMul(int s, int e){
        long partMul = 1;
        while(s<=e){
            if(s%2==1){
                partMul = partMul * tree[s] % MOD;
                s++;
            }
            if(e%2==0){
                partMul = partMul * tree[e] % MOD;
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return partMul;
    }
    private static void changeVal(int idx, long val){
        tree[idx] = val;
        while(idx>1){ // 현재 노드의 양쪽 자식 노드 찾아 곱함
            idx /= 2;
            tree[idx] = tree[idx*2] % MOD * tree[idx*2+1] % MOD;
        }
    }
    private static void setTree(int i){
        while (i!=1){
            tree[i/2] = tree[i/2]*tree[i] % MOD;
            i--;
        }
    }
}
