import java.io.*;
import java.util.*;

public class Wartel {
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
    static int Q ;

    static{
        N = in.nextInt();
        Q = in.nextInt();

    }

    private static Map<String,String> wartel = new TreeMap<>();
    public static void main(String[] args) {
        mapInput(N);

        for(int i = 0;i<Q;i++){
            String name = in.next();
            if(wartel.containsKey(name)){
//                String formatted = String.format("%6s",wartel.get(name));
                out.println(wartel.get(name));
            }else{
                out.println("NIHIL");
            }
        }
        out.close();
    }
    private static void mapInput(int N ){
        for(int i = 0;i<N;i++){
            wartel.put(in.next(),in.next());
        }
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














