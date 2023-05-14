import java.io.*;

public class Q022_B10989_수정렬3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(br.readLine());
        br.close();

        radixSort(arr, 5); // 문제에서 주어진 숫자 <= 10,000

        for(int i=0;i<N;i++)
            bw.write(arr[i]+"\n");
        bw.flush();
        bw.close();
    }

    public static void radixSort(int[] arr, int max_size){
        int[] output = new int[arr.length];
        int figure = 1;
        int count = 0;
        while(count != max_size){
            int[] bucket = new int[10]; // 자릿수 기준(0~9)으로 한 배열
            for(int i=0;i<arr.length;i++)
                bucket[(arr[i]/figure) % 10]++;
            for(int i=1;i<10;i++)
                bucket[i] += bucket[i-1];
            for(int i=arr.length-1;i>=0;i--) {
                output[bucket[(arr[i] / figure % 10)] - 1] = arr[i];
                bucket[(arr[i]/figure) % 10]--;
            }
            for(int i=0;i<arr.length;i++)
                arr[i] = output[i];

            figure = figure*10;
            count++;
        }
    }
}
