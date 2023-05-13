import java.util.Scanner;

public class Q018_B11399_ATM인출시간 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();

        for(int i=1;i<N;i++){
            int index = i; // 삽입 인덱스
            int index_val = arr[i]; // 삽입 인덱스 값

            for(int j=i-1;j>=0;j--) {
                if (arr[i] > arr[j]) {
                    index = j + 1;
                    break;
                }
                if (j == 0) index = 0;
            }

            for(int j=i;j>index;j--)
                arr[j] = arr[j-1];
            arr[index] = index_val;
        }

        int[] sum = new int[N];
        sum[0] = arr[0];
        for(int i=1;i<N;i++)
            sum[i] = sum[i-1] + arr[i];

        int result = 0;
        for(int i=0;i<N;i++)
            result += sum[i];
        System.out.println(result);
    }
}
