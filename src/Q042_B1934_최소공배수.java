import java.util.Scanner;

public class Q042_B1934_최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int result = a * b / gcd(a,b);
            System.out.println(result);
        }
    }

    private static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
}
