import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Q012_B17298_오큰수 {
    public static void main(String[] args) throws IOException {
        /*Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] nums = new int[num];
        for(int i=0;i<num;i++)
            nums[i] = sc.nextInt();

        int[] result = new int[num];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<num; i++){
            while(!st.empty() && nums[st.peek()]<nums[i]){
                result[st.pop()] = nums[i];
            }
            st.push(i);
        }
        // 반복문 돌았는데 스택 비어 있지 않으면
        while(!st.empty()){
            result[st.pop()] = -1;
        }

        for(int i=0;i<num;i++)
            System.out.print(result[i]+ " ");*/

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int[] nums = new int[num];
        String[] str = bf.readLine().split(" ");

        for(int i=0;i<num;i++)
            nums[i] = Integer.parseInt(str[i]);

        int[] result = new int[num];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<num; i++){
            while(!st.empty() && nums[st.peek()]<nums[i]){
                result[st.pop()] = nums[i];
            }
            st.push(i);
        }
        // 반복문 돌았는데 스택 비어 있지 않으면
        while(!st.empty()){
            result[st.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<num;i++)
            bw.write(result[i]+ " ");

        bw.flush();
    }
}
