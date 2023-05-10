import java.util.Arrays;
import java.util.Scanner;

public class Q007_B1940_주몽의명령 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 재료의 개수
        int M = sc.nextInt(); // 갑옷이 완성되는 번호의 합

        long[] ingredients = new long[N];
        for(int i=0; i<N; i++)
            ingredients[i] = sc.nextInt();

        Arrays.sort(ingredients);

        int count = 0;
        int start_index = 0;
        int end_index = N-1;
        while(start_index < end_index){
            if(ingredients[start_index]+ingredients[end_index]==M){
                count++;
                start_index++;
                end_index--;
            } else if(ingredients[start_index]+ingredients[end_index]<M){
                start_index++;
            } else {
                end_index--;
            }
        }
        System.out.println(count);
    }
}
