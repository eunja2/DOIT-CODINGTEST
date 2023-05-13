import java.util.Scanner;

public class Q019_B11004_K번째수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();

        quickSort(arr, 0, N-1, K-1); // K번째 수의 인덱스 = K-1
        System.out.println(arr[K-1]);
    }

    public static void quickSort(int[] A, int s, int e, int K){
        if(s < e) {
            int pivot = partition(A, s, e);
            if (pivot == K) return;
            else if (pivot > K) quickSort(A, s, pivot - 1, K);
            else quickSort(A, pivot + 1, e, K);
        }
    }

    public static int partition(int[] A, int s, int e){ // 피벗 기준으로 두 그룹으로 나누어 피벗 인덱스 반환
        if(s+1==e){ // 데이터가 2개인 경우 바로 비교
            if(A[s]>A[e]) swap(A, s, e);
            return e;
        }
        int M = (s+e) / 2;
        swap(A,s,M); // 중앙값 index 0으로
        int pivot = A[s];
        int i = s+1;
        int j = e;

        while(i<=j){
            while(j>s && pivot<A[j]) j--;
            while(i<=e && pivot>A[i]) i++;
            if(i<=j) swap(A, i++, j--); // 피벗보다 작은 j, 큰 i 나올 때까지 이동후 swap, 후 i++, j--
        }
        // 피벗을 피벗보다 작은/큰 그룹 사이에 삽입
        A[s] = A[j];
        A[j] = pivot;
        return j;
    }

    public static void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
