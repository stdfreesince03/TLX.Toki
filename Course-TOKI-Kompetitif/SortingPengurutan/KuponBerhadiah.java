import java.io.*;
import java.util.*;

public class KuponBerhadiah {
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

    private static long[] primeList  = new long[77778];
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int N = in.nextInt();
        int Comp = in.nextInt();

        int min = Integer.MAX_VALUE;

        int print = 0;
        for(int i = 0;i<N;i++){
            int compared = in.nextInt();
            int result = Math.abs(Comp-compared);

            if( result < min){
                min = result;
                print = compared;
            }else if( result == min){
                if(compared < print){
                    print = compared;
                }
            }
        }
        System.out.println(print);
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














