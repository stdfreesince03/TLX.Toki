import java.io.*;
import java.util.*;

public class New {
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
    static int ultTot = 0;
   
   
    static{
        M = in.nextInt();
        N = in.nextInt();

    }

    private static boolean[][] pernah = new boolean[M][N];
    public static void main(String[] args) {
        int[][] array = changeToIntArr(readArray2D());
        int[][] temp = new int[M][N];
        int sum1,biggest2;
  

        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                if(array[i][j] == 0){
                    continue;
                }
                temp = copyOf2Dim(array);
                sum1 = jawBreaker(i, j, array[i][j],temp);
                if(sum1 > 1){
                    fillFalse();

                     biggest2 = step2(dropDown(temp));
                    
                    sum1 = (sum1*(sum1-1)) + (biggest2*(biggest2-1));
                    
                    if(ultTot < sum1){
                        ultTot = sum1;
                    }
                }else{
                    continue;
                }
               

            }
        }

      
   
        out.println(ultTot);
        out.close();
       
    }



    private static  int[][] copyOf2Dim(int[][] array) {

        return Arrays.stream(array).
                  map(el -> el.clone()).toArray(a -> array.clone());
    }

    private static int step2(int[][] array){

        int step2Biggest = 0;

        for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array[i].length;j++){

                if(array[i][j] == 0){
                    continue;
                }
              
                int sum2= jawBreaker(i,j,array[i][j],array);
                if(sum2 > step2Biggest){
                    step2Biggest = sum2;
                }
                fillFalse(); 
               
            }
        }

        return step2Biggest;

    }
    private static char[][] readArray2D(){
        char[][] locArray = new char[M][N];

        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                locArray[i][j] = in.next().charAt(0);
            }
        }
        return locArray;
    }

    private static <T> void  printArray2D(T[][]  array){
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                out.print(array[i][j] + " ");
            }
            out.println();
        }
    }
    
    private static int[][] changeToIntArr(char[][] array ){
        int[][] returned = new int[M][N];
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                if(array[i][j] == '.'){
                    returned[i][j] = 0;
                }else{
                    returned[i][j] = (int) array[i][j];
                }
            }
        }
        return returned;
    }

    private static int jawBreaker(int row,int col,int Number,int[][] array){
        int numOfNum = 0;
        if(row <0 || row >= M || col <0 || col >= N){
          
            return 0;
        }
        if(array[row][col] == 0){
            return 0;
        }
        if(array[row][col] != Number ){
        
            return 0;
        }
        if(pernah[row][col] == true){
           
            return 0;
        }

        pernah[row][col] = true;
        array[row][col] = 0;
        
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

    private static int[][] copyArray(int[][] array){
        int[][] returned = new int[M][N];
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
               returned[i][j] = array[i][j];
            }
        }
        return returned;
    }

    private static void swap(int i1,int i2,int j,int[][] array){
        int temp = array[i1][j];
        array[i1][j] = array[i2][j];
        array[i2][j] = temp;
    }

    private static int[][] dropDown(int[][] array){
        for(int j = 0;j<N;j++){
            for(int i = M-1;i>=0;i--){
                if( array[i][j] != 0 ){
                    int temp = i;
                    while( temp+1 < M ){
                        if(array[temp + 1][j] != 0) break;
                        swap(temp, temp+1, j,array);
                        temp+=1;       
                    }
                }else{
                    continue;
                }
            }
        }
        return array;
    }
}
