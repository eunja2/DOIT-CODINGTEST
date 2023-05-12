import java.util.Scanner;

public class Q017_B1427_내림차순자릿수정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int[] arr = new int[num.length()];
        for(int i=0;i<arr.length;i++)
            arr[i] = Integer.parseInt(num.substring(i,i+1));

        for(int i=0;i<arr.length;i++){
            int max = i;
            for(int j=i+1;j<arr.length;j++)
                if(arr[j]>arr[max]) max = j;

            if(arr[max]>arr[i]){
                int tmp = arr[i];
                arr[i] = arr[max];
                arr[max] = tmp;
            }
        }

        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]);
    }
}
