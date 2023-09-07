

/*
    Input :
    Reader viliya = new Reader();
    int x = viliya.nextInt();
    string y = viliya.nextLine();
*/

import java.io.*;
import java.util.*;

public class Runtuh {
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
    private static int[][] board = new int[20][8];


    public static void main(String[] args) throws IOException {
        int R = in.nextInt();
        int C  = in.nextInt();

        inputArray(R,C);

        boolean start = true;



        while(start){
            int index = emptyRow(R,C);
            if(index >= 0){
                runtuh(R,C,index);
            }else{
                start = false;
            }
        }

        printArray(R,C);
        out.close();
    }



    private static void printArray(int R, int C) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                out.print(board[i][j]);
            }
            out.println();
        }

    }


    private static void inputArray(int R, int C) {
        for (int i = 0; i < R; i++) {
            String input = in.next();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j)-'0' ;
            }
        }
    }

    private static int emptyRow(int R ,int C){
        int last = -1;
        for(int i = 0;i<R;i++){
            int[] temp = Arrays.copyOf(board[i],C);
            if(all1(temp)){
                last = i;
                Arrays.fill(temp,0);
                board[i] = temp;
            }
        }
        return last;

    }

    private static boolean all1(int[] array){
        return Arrays.stream(array).allMatch(n->n==1);
    }

    private static void runtuh(int R,int C,int lastIndex){

        for(int i = 0;i<C;i++){
            int fallIndex = lastIndex;
            while((fallIndex+1) < R && board[fallIndex + 1][i] == 0      ){
                fallIndex +=1;
            }
            for(int j=fallIndex;j>=0;j--){
               if(board[j][i] ==1){
                   board[j][i] = 0;
                   board[fallIndex][i] = 1;
                   fallIndex-=1;
               }
            }
        }

    }

}



    
    



  

