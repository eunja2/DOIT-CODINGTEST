import java.util.Scanner;

public class Q069_B14425_문자열찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        tNode root = new tNode();

        while(N>0){
            String text = sc.next(); // 공백없는 단어 1개
            tNode now = root;
            for(int i=0;i<text.length();i++){
                char c = text.charAt(i);
                if(now.next[c-'a']==null)
                    now.next[c-'a'] = new tNode();
                now = now.next[c-'a'];
                if(i==text.length()-1) now.leaf = true;
            }
            N--;
        }

        int count = 0;
        while(M>0){
            String text = sc.next();
            tNode now = root;
            for(int i=0;i<text.length();i++){
                char c = text.charAt(i);
                if(now.next[c-'a'] == null) break; // 공백 노드 포함 x
                now = now.next[c-'a'];
                if(i==text.length()-1 && now.leaf) count++;
            }
            M--;
        }
        System.out.println(count);
    }
}

class tNode {
    tNode[] next = new tNode[26];
    boolean leaf;
}
