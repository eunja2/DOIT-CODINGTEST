import java.util.Scanner;

public class Q001_B11720_숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt(); // 숫자의 개수

        String num = sc.next();
        char[] cNum = num.toCharArray(); // string -> char 배열로 변환
        int sum = 0;
        for(int i=0;i<count;i++)
            sum += cNum[i]-'0'; // char -> 정수로 변환

        System.out.println(sum);
    }
}
