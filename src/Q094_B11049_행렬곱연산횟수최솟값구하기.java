import java.util.Scanner;

public class Q094_B11049_행렬곱연산횟수최솟값구하기 {
    static Matrix[] M;
    static int[][] D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = new Matrix[N+1];
        D = new int[N+1][N+1];
        for(int i=0;i<D.length;i++)
            for(int j=0;j<D[i].length;j++)
                D[i][j] = -1;
        for(int i=1;i<=N;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            M[i] = new Matrix(x, y);
        }
        System.out.println(excute(1,N));
    }

    static int excute(int s, int e){
        int result = Integer.MAX_VALUE;
        if(D[s][e] != -1) return D[s][e];
        if(s==e) return 0;
        if(s+1==e) return M[s].x * M[s].y * M[e].y;
        for(int i=s;i<e;i++)
            result = Math.min(result, excute(s, i) + excute(i+1,e) + M[s].x * M[i].y * M[e].y);
        return D[s][e] = result;
    }


    static class Matrix {
        private int x;
        private int y;
        Matrix(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

