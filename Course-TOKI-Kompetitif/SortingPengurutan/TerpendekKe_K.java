import java.io.*;
import java.util.*;

public class TerpendekKe_K {
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
    static int K ;

    static{
        N = in.nextInt();
        K = in.nextInt();
    }

    private static int[] array = new int[N];


    public static void main(String[] args) {

        for(int i = 0;i<N;i++){
            array[i] = in.nextInt();
        }
        bubbleSort();
        out.println(array[K-1]);
        out.close();
    }


    private static void swap(int i ,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
    private static void bubbleSort(){
        for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array.length-i-1;j++){
                if(array[j] > array[j+1]){
                    swap(j,j+1);
                }
            }

        }
    }
    private static void printArray(){
        for(int element : array){
            System.out.print(element + " ");
        }
    }

}









