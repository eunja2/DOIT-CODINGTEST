import java.util.Scanner;

public class Q009_B12891_DNA비밀번호 {
    static int[] check; // 체크할 문자 개수
    static int[] status; // 현재 상태의 문자열 개수
    static int checkSecret; // 체크 만족한 문자 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt(); // 임의로 만들 DNA 문자열 길이
        int P = sc.nextInt(); // 비밀번호로 사용할 부분문자열 길이
        char[] A = new char[S]; // 임의로 만든 DNA 문자열
        check = new int[4]; // 체크할 문자 개수
        status = new int[4]; // 현재 상태의 문자열 개수
        checkSecret = 0; // 체크 만족한 문자 개수
        int result = 0; // 조건 만족한 부분문자열 개수

        String st = sc.next();
        for(int i=0;i<S;i++) {
            A[i] = st.charAt(i); // char를 scanner로 받기 위해서는 String으로 받아 charAt(index)로 형변환 해주어야 함
        }

        for(int i=0;i<4;i++){
            check[i] = sc.nextInt();
            if(check[i]==0)
                checkSecret++; // 0일 경우 이미 만족했으므로
        }

        for(int i=0;i<P;i++) // 초기 P부분
            Add(A[i]);

        if(checkSecret==4) result++;

        for(int i=P;i<S;i++){ // 슬라이딩 윈도우
            int j=i-P; // i가 P(0)라면 j는 i-P(i)
            Add(A[i]); // 부분문자열 다음 문자 추가
            Remove(A[j]); // 부분문자열 처음 문자 제거
            if(checkSecret==4) result++;
        }
        System.out.println(result);
    }

    private static void Add(char c){
        switch(c){
            case 'A' :
                status[0]++;
                if(status[0]==check[0]) checkSecret++;
                break;
            case 'C' :
                status[1]++;
                if(status[1]==check[1]) checkSecret++;
                break;
            case 'G' :
                status[2]++;
                if(status[2]==check[2]) checkSecret++;
                break;
            case 'T' :
                status[3]++;
                if(status[3]==check[3]) checkSecret++;
                break;
        }
    }

    private static void Remove(char c){
        switch(c){
            case 'A' :
                if(status[0]==check[0]) checkSecret--;
                status[0]--;
                break;
            case 'C' :
                if(status[1]==check[1]) checkSecret--;
                status[1]--;
                break;
            case 'G' :
                if(status[2]==check[2]) checkSecret--;
                status[2]--;
                break;
            case 'T' :
                if(status[3]==check[3]) checkSecret--;
                status[3]--;
                break;
        }
    }
}
