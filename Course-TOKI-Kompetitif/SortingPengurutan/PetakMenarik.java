import java.io.*;
import java.util.*;

public class PetakMenarik {
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
    static int M ;

    static{
        N = in.nextInt();
        M = in.nextInt();

    }

    private static int[][] array = new int[N][M];

    public static void main(String[] args) {
        int K = in.nextInt();
        arrayInput(N,M);
        System.out.println(checkAndMultiply(K));

    }
    private static void arrayInput(int N ,int M ){
        for(int i = 0;i<N;i++){
            for (int j = 0;j<M;j++){
                array[i][j] = in.nextInt();
            }
        }
    }

    private static String checkAndMultiply(int K ){
        String note = "";
        for(int i = 0;i<M;i++){
            for (int j = 0;j<N;j++){
                int returned = 1;
                if(j+1 < N){
                    returned *= array[j+1][i];
                }
                if(j-1 >=0 ){
                    returned *= array[j-1][i];
                }
                if(i+1 < M ){
                    returned *= array[j][i+1];
                }
                if(i-1 >= 0 ){
                    returned *= array[j][i-1];
                }
                if(returned == K){
                    note = (j+1) + " " + (i+1);
                    return note;
                }
            }

        }
        return 0 + " " + 0;
    }

    private static int binSer(int[] h,int X) {
        int hasil = 0;
        int kiri = 0;
        int kanan = h.length-1;

        while(kiri <= kanan && hasil == 0) {
            int tengah = (kiri + kanan)/2;
            if(h[tengah] < X){
                kiri = tengah +1;
            }else if(h[tengah] > X){
                kanan = tengah-1;
            }else{
                hasil = h[tengah];
            }
        }

       return hasil;

    }
}














