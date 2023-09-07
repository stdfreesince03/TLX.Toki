import java.io.*;
import java.util.*;

public class PertemuanPakDengklek {
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


    private static String[] array = new String[N];
    private static final Comparator<String> tamuSort = new Comparator<String>()
    {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() < o2.length()){
                return -1;
            }else if(o1.length() > o2.length()){
                return 1;
            }else{
                return o1.compareTo(o2);
            }
        }
    };

    public static void main(String[] args) {
        for(int i = 0;i<N;i++){
            String nama = in.next();
            array[i] = nama;
        }
        Arrays.sort(array,tamuSort);
        for(int i = 0;i<N;i++){
            System.out.println(array[i]);
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














