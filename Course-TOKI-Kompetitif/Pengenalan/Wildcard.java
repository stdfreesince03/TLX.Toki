import java.io.*;
import java.util.StringTokenizer;

public class Wildcard {
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
        String input = in.next();
        int num = in.nextInt();

        
        if(input.equals("*")){
            for(int i = 0;i<num;i++){
                String test = in.next();
                System.out.println(test);
            }

        }
        else if(input.charAt(0) =='*'){
            String compare = input.substring(1);
            for(int i = 0;i<num;i++){
                String test = in.next();
                if(test.length()  >= input.substring(1).length()) {
                    if (test.substring(test.length() - input.substring(1).length()).equals(compare)) {
                        System.out.println(test);
                    }
                }
            }

        }else if(input.charAt(input.length()-1) =='*'){
            String compare = input.substring(0,input.length()-1);
            for(int i = 0;i<num;i++){
                String test = in.next();
                int testIndex = test.indexOf(compare);
                if(testIndex == 0){
                    System.out.println(test);
                }

            }

        }else{

            int star = input.indexOf("*");
            String front = input.substring(0,star);
            String back = input.substring(star+1);

            for(int i = 0;i<num;i++){
                String test = in.next();
                if(test.length() >= back.length() && star<test.length()){
                    String testFront = test.substring(0,star);

                    if(test.length()-back.length() > star-1){
                        String testBack = test.substring(test.length()-back.length());
                        if(testFront.equals(front) &&
                                testBack.equals(back)){
                            System.out.println(test);
                        }
                    }

                }

            }
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

