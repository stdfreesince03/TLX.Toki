import java.io.*;
import java.util.*;

public class PasarRakyat {
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
        int T = in.nextInt();
        int KPKres = 1;

        for(int i = 0;i<T;i++){
            int input = in.nextInt();
            KPKres = KPK(KPKres,input);
        }

        System.out.println(KPKres);
    }

    private static int FPB(int a,int b){
        if(b == 0){
            return a;
        }else{
            return (FPB(b,a%b));
        }
    }

    private static int KPK(int a ,int b){
        return (a*b)/FPB(a,b);
    }

    private static void  ErasSieve(){
        boolean[] check = new boolean[1000000];
        Arrays.fill(check,true);


        int count = 0;
        int i =2;

        while(count<77778){
            if(check[i]){
                {
                    primeList[count] = i;
                    count++;
                    int j = i * 2;
                    while (j > 0 && j <= 999999) {
                        check[j] = false;
                        j = j + i;
                    }
                }


            }
            i++;
        }



    }
    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }


}














