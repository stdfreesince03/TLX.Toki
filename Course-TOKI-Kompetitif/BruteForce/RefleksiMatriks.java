import java.io.*;
import java.util.*;

public class RefleksiMatriks {
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

    static int N1;
    static int N2;

    public static void main(String[] args) {
        N1 = in.nextInt();
        N1 = in.nextInt();
        int[][] array1 = arrayInput(N1);

        N2 = in.nextInt();
        N2 = in.nextInt();
        int[][] array2 = arrayInput(N2);
        System.out.println(identik(array1,array2));
        out.close();
    }

    private static int[][] arrayInput(int N){
        int[][] returned = new int[N][N];
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                returned[i][j] = in.nextInt();
            }
        }
        return returned;
    }
    private static String identik(int[][] array1,int[][] array2) {
        if (regular(array1, array2)) {
            return "identik";
        } else if (vertikal(array1, array2)) {
            return "vertikal";
        } else if (horizontal(array1, array2)) {
            return "horisontal";
        } else if (kananBawah(array1, array2)) {
            return "diagonal kanan bawah";
        } else if (kiriBawah(array1, array2)) {
            return "diagonal kiri bawah";
        }else{
            return "tidak identik";
        }
    }

    private static boolean regular(int[][] array1,int[][] array2){
        for(int i = 0;i<N1;i++){
            for(int j = 0;j<N2;j++){
                if(array1[i][j] != array2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean vertikal(int[][] array1,int[][] array2){
        for(int i = 0;i<N1;i++){
            for(int j = 0;j<N2;j++){
                if(array1[i][j] != array2[i][N2-j-1]){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean horizontal(int[][] array1,int[][] array2){
        for(int i = 0;i<N1;i++){
            for(int j = 0;j<N2;j++){
                if(array1[i][j] != array2[N2-1-i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean kananBawah(int[][] array1,int[][] array2){
        for(int i = 0;i<N1;i++){
            for(int j = 0;j<N2;j++){
                if(array1[i][j] != array2[j][i]){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean kiriBawah(int[][] array1,int[][] array2){
        for(int i = 0;i<N1;i++){
            for(int j = 0;j<N2;j++){
                if(array1[i][j] != array2[N2-1-j][N2-1-i]){
                    return false;
                }
            }
        }
        return true;
    }


}









