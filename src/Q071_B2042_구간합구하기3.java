import java.util.Scanner;

public class Q071_B2042_구간합구하기3 {
    static long[] tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 노드 개수
        int M = sc.nextInt(); // 변경이 일어나는 횟수
        int K = sc.nextInt(); // 구간의 합 구하는 횟수, 즉 a가 2인 횟수

        int treeHeight = 0; // 2^k>=N을 만족하는 k의 최솟값
        int length = N;
        while(length!=0){
            length /= 2;
            treeHeight++;
        }

        int treeSize = (int)Math.pow(2,treeHeight+1);
        int treeStart = (int)Math.pow(2,treeHeight);
        tree = new long[treeSize+1];

        for(int i=treeStart;i<treeStart+N;i++)
            tree[i] = sc.nextLong();
        setTree(treeSize-1); // tree 초기화

        for(int i=0;i<M+K;i++){
            long a = sc.nextInt();
            int s = sc.nextInt();
            long e = sc.nextLong();
            if(a==1){ // s번째 수를 e로 변경
                changeVal(treeStart+s-1, e);
            } else if(a==2){ // s번째 수 ~ e번째 수의 합 출력
                s += treeStart-1;
                e += treeStart-1;
                System.out.println(getSum(s,(int)e));
            } else
                return;
        }
    }

    private static long getSum(int s, int e){
        long partSum = 0;
        while(s<=e){
            if(s%2==1){
                partSum += tree[s];
                s++;
            }
            if(e%2==0){
                partSum += tree[e];
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return partSum;
    }
    private static void changeVal(int idx, long val){
        long diff = val - tree[idx];
        while(idx>0){
            tree[idx] += diff;
            idx /= 2;
        }
    }
    private static void setTree(int i){
        while(i!=1){
            tree[i/2] += tree[i];
            i--;
        }
    }
}
