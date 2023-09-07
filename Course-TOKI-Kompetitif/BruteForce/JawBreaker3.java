import java.io.*;
import java.util.*;

public class App {
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


    static int M;
    static int N;
    static int T = 0;
    static int bigRow = 0;
    static int bigCol = 0;
    static{
        M = in.nextInt();
        N = in.nextInt();
    }

 
    private static boolean[][] pernah = new boolean[M][N];
    private static char[][] resultArray = new char[M][N];
    private static char[][] tempArray = new char[M][N];
    public static void main(String[] args) {
        char[][] array = new char[M][N];
        

        array = readArray2D(M, N);


        for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array[i].length;j++){

                int Number = array[i][j];
                fillFalse();
                
                tempArray = copyArray(array);

                int sum = jawBreaker(i, j, Number, tempArray);

                if(sum > T){
                    T = sum;
                    resultArray = tempArray;
                }
            }
        }



        
        dropDown();
     
        printArray2D();
        

        out.close();
    }

    private static char[][] readArray2D(int M,int N){
        char[][] locArray = new char[M][N];

        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                locArray[i][j] = in.next().charAt(0);
            }
        }
        return locArray;
    }

    private static void printArray2D(){
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                out.print(resultArray[i][j] + " ");
            }
            out.println();
        }
    }

    private static int jawBreaker(int row,int col,int Number,char[][] array){
        int numOfNum = 0;
        if(row <0 || row >= M || col <0 || col >= N){
          
            return 0;
        }
        if((int)array[row][col] != Number){
        
            return 0;
        }
        if(pernah[row][col] == true){
           
            return 0;
        }

        pernah[row][col] = true;
        array[row][col] = '.';
        
        numOfNum +=1;
        numOfNum += jawBreaker(row + 1, col, Number, array);
        numOfNum += jawBreaker(row , col + 1, Number, array);
        numOfNum += jawBreaker(row - 1, col, Number, array);
        numOfNum += jawBreaker(row , col - 1, Number, array);
       
        
        return numOfNum;
    }

    private static void fillFalse(){
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
               pernah[i][j] =false;
            }
        }
    }

    private static char[][] copyArray(char[][] array){
        char[][] returned = new char[M][N];
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
               returned[i][j] = array[i][j];
            }
        }
        return returned;
    }

    private static void swap(int i1,int i2,int j){
        char temp = resultArray[i1][j];
        resultArray[i1][j] = resultArray[i2][j];
        resultArray[i2][j] = temp;
    }

    private static void dropDown(){
        for(int j = 0;j<N;j++){
            for(int i = M-1;i>=0;i--){
                // int temp = i;
                // if(temp + 1 < M && resultArray[temp+1][j] == '.'  ){
                //     System.out.println("i=" + i + " j=" + j);
                // }
                if(i+1 < M && resultArray[i][j] != '.' ){
                    int temp = i;
                    while( temp+1 < M && resultArray[temp+1][j] == '.'){
                        
                        swap(temp, temp+1, j);
                        temp+=1;
                        
                    }
                }
            }
        }
    }

    


    

}





















