import java.util.Scanner;

public class Q051_B1976_여행계획짜기 {
    static int[] represent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] city = new int[N+1][N+1];
        for(int i=1;i<=N;i++)
            for(int j=1;j<=N;j++)
                city[i][j] = sc.nextInt();

        int[] route = new int[M+1];
        for(int i=1;i<=M;i++)
            route[i] = sc.nextInt();

        represent = new int[N+1];
        for(int i=1;i<=N;i++)
            represent[i] = i;

        for(int i=1;i<=N;i++)
            for(int j=1;j<=N;j++)
                if(city[i][j]==1) union(i, j);

        int idx = find(route[1]); // 첫번째 도시의 대표노트 저장
        for(int i=2;i<route.length;i++){
            if(idx!=find(route[i])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static void union(int i, int j){
        if(find(i)!=find(j)) represent[j] = i;
    }

    static int find(int a){
        if(a==represent[a]) return a;
        else return represent[a] = find(represent[a]);
    }
}
