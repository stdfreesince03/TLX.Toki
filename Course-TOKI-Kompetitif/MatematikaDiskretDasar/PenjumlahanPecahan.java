import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PenjumlahanPecahan {
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
    private static String[] jawaban = new String[100];

    public static void main(String[] args) {
       int M1 = in.nextInt();
       int M2 = in.nextInt();
       int N1 = in.nextInt();
       int N2 = in.nextInt();

        long bawah = KPK(M2,N2);
        long atas = ((bawah/M2) * M1) + ((bawah/N2)*N1);

        long  atasRes =  atas/FPB(atas,bawah);
        long bawahRes = bawah/FPB(atas,bawah);

        System.out.println(atasRes + " " + bawahRes);


    }

    private static long FPB(long a,long b){
        if(b == 0){
            return a;
        }else{
            return (FPB(b,a%b));
        }
    }

    private static long KPK(long a ,long b){
        return (a*b)/FPB(a,b);
    }

//    private static int[] ErasSieve(int K){
//        boolean[] temp = new boolean[K];
//        Arrays.fill(temp,false);
//
//        int[]
//    }


}



        //test.substring(input.length()-back.length()).equals(back)

    //int asLoc = 0;
//        int mid = 0;
//        if(input.indexOf("*") == input.lastIndexOf(input)){
//            asLoc = 2;
//        }else if(input.indexOf("*") > 0 ){
//            asLoc = 1;
//            mid = input.indexOf("*");
//        }
//        String inWithout = input.replace("*","");
//
//
//        int num = in.nextInt();
//        int index = 0;
//        for(int i = 0;i<num;i++){
//            String test = in.next();
//            if(inWithout.equals("")){
//                jawaban[index] = test;
//                index++;
//            }else if(asLoc == 1){
//                if(test.contains(input.substring(0,mid)) && test.contains(input.substring(mid+1))){
//                    jawaban[index] = test;
//                    index++;
//                }
//            }
//            else if(test.contains(inWithout)){
//                int subIndex = test.indexOf(inWithout);
//                if(subIndex > 0 && asLoc == 0){
//                    jawaban[index] = test;
//                    index++;
//                }
//                else if(subIndex == 0 && asLoc == 2){
//                    jawaban[index] = test;
//                    index++;
//                }
//            }
//        }
//        int print = 0;
//        while(jawaban[print] != null){
//            System.out.println(jawaban[print]);
//            print++;
//        }
//    }
//

