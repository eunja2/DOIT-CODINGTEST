import java.util.ArrayList;
import java.util.Scanner;

public class Q068_B1068_리프노드개수구하기 {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int deleteNode;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 노드 개수
        tree = new ArrayList[N];
        visited = new boolean[N];

        int root = 0; // 받은 숫자 중 부모노드가 없는 루트 노드 판별 변수
        for(int i=0;i<N;i++)
            tree[i] = new ArrayList<>();

        for(int i=0;i<N;i++){
            int p = sc.nextInt();
            if(p != -1){
                tree[i].add(p);
                tree[p].add(i);
            } else
                root = i;
        }

        deleteNode = sc.nextInt();
        if(deleteNode == root)
            System.out.println(0);
        else {
            DFS(root);
            System.out.println(answer);
        }
    }

    static void DFS(int num){
        visited[num] = true;
        int count = 0;
        for(int i : tree[num]){
            if(visited[i] == false && i != deleteNode){
                count++;
                DFS(i);
            }
        }
        if(count==0) // for문 들어가지 않고 더 이상 연결된 노드가 없을 때 -> 리프 노트
            answer++;
    }
}
