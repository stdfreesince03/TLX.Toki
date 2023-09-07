import java.io.*;
import java.util.*;

public class PendataanBeratBebek {
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    private static InputStream inS = System.in;
    private static OutputStream outS = System.out;
    private static InputReader in = new InputReader(inS);
    private static PrintWriter out = new PrintWriter(outS);


    static int N ;

    static{
        N = in.nextInt();
    }


    private static int[] array = new int[N];
    public static void main(String[] args) {
        for (int i = 0;i<N;i++){
            array[i] = in.nextInt();
        }


        int Q = in.nextInt();
        for (int i = 0;i<Q;i++) {
            int left = in.nextInt();
            int right = in.nextInt();

            int leftIndex = binSer(array, left);
            int rightIndex = binSer(array, right);

            int answer = 0;
            answer = rightIndex - leftIndex;

            out.println(answer);
        }
        out.close();
    }


    private static int binSer(int[] h,int X) {

            int kiri = 0;
            int kanan = h.length-1;

            int index = -1;

            while(index == -1) {
                int tengah = (kiri + kanan)/2;
                if(h[tengah] > X){
                    if((tengah-1) < 0){
                        return tengah-1;
                    }
                    else if(h[tengah-1] < X){
                        index = tengah-1;
                    }
                    kanan = tengah-1;
                }else if(h[tengah] <= X){
                    if((tengah+1) > h.length-1 ){
                        return tengah;
                    }
                    else if(h[tengah+1]>X){
                        index = tengah;
                    }
                    kiri = tengah +1;
                }
                else{
                    index = tengah;
                }

            }

            return index;

        }


}














