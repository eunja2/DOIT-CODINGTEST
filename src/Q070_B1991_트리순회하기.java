import java.util.Scanner;

public class Q070_B1991_트리순회하기 {
    static int[][] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        // nextInt()는 숫자만 읽어내고 whitespace(enter)는 입력스트림에 남겨둠. 이 상태에서 숫자를 받는 nextInt()는 상관 없지만
        // nextLine()을 호출하면 빈줄을 반환하기에 미리 nextLine() 함수를 한 번 더 사용해 개행문자를 제거한다.
        tree = new int[26][2];
        for(int i=0;i<N;i++){
            String[] temp = sc.nextLine().split(" ");
            int node = temp[0].charAt(0) - 'A'; // 인덱스로 변환
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);

            if(left == '.') tree[node][0] = -1;
            else tree[node][0] = left-'A';

            if(right == '.') tree[node][1] = -1;
            else tree[node][1] = right-'A';
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    static void preOrder(int now){
        if(now == -1) return;
        System.out.print((char)(now+'A'));
        preOrder(tree[now][0]); // 왼쪽 노드
        preOrder(tree[now][1]); // 오른쪽 노드
    }
    static void inOrder(int now){
        if(now == -1) return;
        inOrder(tree[now][0]); // 왼쪽 노드
        System.out.print((char)(now+'A'));
        inOrder(tree[now][1]); // 오른쪽 노드
    }
    static void postOrder(int now){
        if(now == -1) return;
        postOrder(tree[now][0]); // 왼쪽 노드
        postOrder(tree[now][1]); // 오른쪽 노드
        System.out.print((char)(now+'A'));
    }
}
