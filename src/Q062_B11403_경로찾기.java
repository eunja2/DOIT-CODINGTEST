import java.io.*;
import java.util.StringTokenizer;

public class Q062_B11403_경로찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] distance = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
                distance[i][j] = Integer.parseInt(st.nextToken());;
        }

        for(int i=0;i<N;i++) // 중간 경로
            for(int j=0;j<N;j++)
                for(int k=0;k<N;k++)
                    if(distance[j][i]==1 && distance[i][k]==1) distance[j][k] = 1;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                System.out.print(distance[i][j]+" ");
            System.out.println();
        }
    }
}
