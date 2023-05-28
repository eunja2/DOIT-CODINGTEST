import java.util.Arrays;
import java.util.Scanner;

public class Q060_B1219_세일즈맨의고민 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sCity = sc.nextInt();
        int eCity = sc.nextInt();
        int M = sc.nextInt();
        Edge4[] edges = new Edge4[M];
        long[] distance = new long[N];
        long[] cityMoney = new long[N];

        Arrays.fill(distance, Long.MIN_VALUE);
        for(int i=0;i<M;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int price = sc.nextInt();
            edges[i] = new Edge4(start, end, price);
        }
        for(int i=0;i<N;i++)
            cityMoney[i] = sc.nextLong();

        distance[sCity] = cityMoney[sCity];
        for(int i=0;i<=N+100;i++){
            for(int j=0;j<M;j++){
                int start = edges[j].start;
                int end = edges[j].end;
                int price = edges[j].price;

                if(distance[start] == Long.MIN_VALUE) continue;
                else if(distance[start] == Long.MAX_VALUE) distance[end] = Long.MAX_VALUE;
                else if(distance[end] < distance[start] +cityMoney[end] - price){
                    distance[end] = distance[start] + cityMoney[end] - price;
                    if(i >= N-1) distance[end] = Long.MAX_VALUE;
                }
            }
        }

        if(distance[eCity] == Long.MIN_VALUE) System.out.println("gg");
        else if(distance[eCity] == Long.MAX_VALUE) System.out.println("Gee");
        else System.out.println(distance[eCity]);
    }
}

class Edge4 {
    int start, end, price;
    public Edge4(int start, int end, int price){
        this.start = start;
        this.end = end;
        this.price = price;
    }
}

