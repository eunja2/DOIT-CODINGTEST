import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.Scanner;

public class Q020_B2751_수정렬2 {
    public static int[] arr, tmp;
    public static long result;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        arr = new int[N+1];
        for(int i=1;i<=N;i++)
            arr[i] = sc.nextInt();

        tmp = new int[N+1];
        mergeSort(1,N);

        for(int i=1;i<=N;i++)
            bw.write(arr[i]+"\n");
        bw.flush();
        bw.close();
    }

    public static void mergeSort(int s, int e){
        if(e-s<=0) return;

        int m = s + (e-s) / 2; // 중앙값
        mergeSort(s,m);
        mergeSort(m+1,e);

        for(int i=s;i<=e;i++)
            tmp[i] = arr[i];

        int k = s;
        int index1 = s;
        int index2 = m+1;
        while(index1<=m && index2<=e){
            if(tmp[index1] > tmp[index2]){
                arr[k] = tmp[index2];
                k++; index2++;
            } else {
                arr[k] = tmp[index1];
                k++; index1++;
            }
        }

        // 한 쪽 그룹 모두 선택된 후 남아 있는 값 정리
        while(index1<=m){
            arr[k] = tmp[index1];
            k++; index1++;
        }
        while(index2<=e){
            arr[k] = tmp[index2];
            k++; index2++;
        }

    }
}
