import java.util.Scanner;

public class Q036_B1541_최솟값만드는괄호배치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String formula = sc.nextLine();
        String[] form = formula.split("-");

//        System.out.println(form[1]);
        int result = 0;

        for(int i=0;i<form.length;i++){
            int temp = mySum(form[i]);
            if(i==0) result += temp;
            else result -= temp;
        }
        System.out.println(result);
    }

    static int mySum(String str){
        int sum = 0;
        String[] nums = str.split("\\+"); // 그냥 "+"를 넣으면 에러남 -> dangling meta character '+' near index 0

        for(int i=0;i<nums.length;i++)
            sum += Integer.parseInt(nums[i]);
        return sum;
    }
}
