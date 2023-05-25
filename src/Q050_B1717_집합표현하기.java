import java.util.Scanner;

public class Q050_B1717_집합표현하기 {
    static int[] represent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        represent = new int[N+1];
        for(int i=1;i<=N;i++)
            represent[i] = i;

        for(int i=0;i<M;i++){
            int mark = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(mark==0){
                union(a,b);
            } else {
                if(chk(a,b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b) represent[b] = a;
    }

    static int find(int a){
        if(a==represent[a]) return a;
        else return represent[a] = find(represent[a]);
    }

    static boolean chk(int a, int b){
        if(find(a)==find(b)) return true;
        else return false;
    }
}
