import java.util.Arrays;
import java.util.Scanner;

public class Q008_B1253_좋은수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0;i<N;i++)
            nums[i] = sc.nextInt();

        Arrays.sort(nums);

        int count = 0;
        for(int i=0;i<N;i++){
            int start = 0;
            int end = N-1;

            if(nums[start]==nums[i]) start++;
            if(nums[end]==nums[i]) end--;

            while(start<end){
                if(nums[start]+nums[end] > nums[i]) {
                    end--;
                    if(nums[end]==nums[i]) end--;
                }
                else if(nums[start]+nums[end] < nums[i]) {
                    start++;
                    if(nums[start]==nums[i]) start++;
                } else {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
