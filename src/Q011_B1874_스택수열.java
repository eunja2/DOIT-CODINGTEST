import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q011_B1874_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
            nums[i] = sc.nextInt();

        Stack<Integer> st = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int sequence = 1;
        boolean result = true;

        for(int i=0;i<n;i++){
            if(nums[i]>=sequence){ //
                while(nums[i]>=sequence){
                    st.push(sequence++);
                    sb.append("+\n");
                }
                st.pop();
                sb.append("-\n");
            } else {
                int pop = st.pop();
                if(pop>nums[i]){
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if(result) System.out.println(sb);
    }
}
