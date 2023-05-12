import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q016_B1377_버블소트1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        mData[] arr = new mData[N];
        for(int i=0;i<N;i++)
            arr[i] = new mData(Integer.parseInt(bf.readLine()), i); // data와 index 같이 저장할 수 있는 클래스 mData 사용

        Arrays.sort(arr);
        int Max=0;
        for(int i=0;i<N;i++){
            if(Max < arr[i].index - i)
                Max = arr[i].index - i;
        }
        System.out.println(Max + 1);
    }
}

class mData implements Comparable<mData> {
    int value;
    int index;

    public mData(int value, int index){
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o){
        return this.value - o.value;
    }
}
