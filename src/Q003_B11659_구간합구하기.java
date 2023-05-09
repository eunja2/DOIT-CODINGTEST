import java.util.Scanner;

public class Q003_B11659_구간합구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] nums = new int[N];
        for(int i=0;i<N;i++)
            nums[i] = sc.nextInt();

        int[] sums = new int[N];
        sums[0] = nums[0];
        for(int i=1;i<N;i++)
            sums[i] += sums[i-1] + nums[i];

        while(M>0){
            int start = sc.nextInt()-1;
            int end = sc.nextInt()-1;

            if(start == 0)
                System.out.println(sums[end]);
            else
                System.out.println(sums[end]-sums[start-1]);
            M--;
        }
    }
}
