import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q035_B1931_회의실배정하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[N][2];
        for(int i=0;i<N;i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }

        Arrays.sort(A, new Comparator<int[]>() { // 종료 시간 같을 경우 시작 시간 기준으로 정렬하는 새로운 정렬기준 추가
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int end = -1; // 종료시간이 겹치지 않는 회의 검사할 때 사용
        for(int i=0;i<N;i++){
            if(A[i][0] >= end){
                end = A[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
