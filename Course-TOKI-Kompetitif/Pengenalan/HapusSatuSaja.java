import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HapusSatuSaja {
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
        String A = in.next();
        String B = in.next();

        char[] Aarr = A.toCharArray();
//        System.out.println(String.valueOf(Aarr).trim());

        boolean TOF = false;

        for(int i = 0;i<A.length()-1;i++){
            char[] copy = Arrays.copyOf(Aarr,Aarr.length);
            copy[i] = ' ';
            if( String.valueOf(copy).trim().replace(" ","").equals(B)){
                TOF = true;
                break;
            }
        }

        if(TOF){
            System.out.println("Tentu saja bisa!");
        }else{
            System.out.println("Wah, tidak bisa :(");
        }
    }


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

