

/*
    Input :
    Reader viliya = new Reader();
    int x = viliya.nextInt();
    string y = viliya.nextLine();
*/

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;
 
public class TemanDekat

{
    static class Reader 
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader() 
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) 
            {
                if (c == '\n') 
                {
                    if (cnt != 0) 
                    {
                        break;
                    }
                    else 
                    {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    //START FUNCTION
    static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static int partition(int[] array, int low, int high){
        int pivot = array[high];

        int i = low-1;
        for(int j = low; j < high; ++j){
            if(array[j] < pivot){
                ++i;
                swap(array, i, j);
            }  
        }
        swap(array, i + 1, high);
        return (i+1);
    }

    static void QuickSort(int[] array, int low, int high){
        if(low < high){
            int pi = partition(array, low, high);

            QuickSort(array, low, pi - 1);
            QuickSort(array,pi + 1, high);
        }
    }

    static void printSorted(int[] array, int n){
        for(int i = 0; i < n; ++i){
            System.out.print(array[i] + " ");
        }
    }
    //MAIN CODE
    private static Scanner scan = new  Scanner(System.in);
    public static void main(String[] args) throws IOException{
       int N = scan.nextInt();
       int D = scan.nextInt();

      
       int[] arrayX = new int[N];
       int[] arrayY = new int[N];

       for(int i = 0;i<N;i++ ){
         int x = scan.nextInt();
         int y = scan.nextInt();
         
         arrayX[i] = x;
         arrayY[i] = y;
       }
       int biggest = Integer.MIN_VALUE;
       int smallest = Integer.MAX_VALUE;

       for(int i = 0;i<N;i++ ){
         for(int j = 0;j<i;j++){
            double temp = Math.pow(Math.abs(arrayX[i] - arrayX[j]), D) + Math.pow(Math.abs(arrayY[i] - arrayY[j]), D) ;
            if(temp < smallest){
                smallest = (int)temp;
            }
            if(temp> biggest){
                biggest = (int)temp;
            }
         }
      }
      System.out.println(smallest + " " + biggest);

       
       
    }




    private static String looprekurs(int num,int num2,int arrayX[],int arrayY[],double biggest,double smallest,int D){
       Double sum = Math.pow(Math.abs(arrayX[num2]- arrayX[num]) , D)+ Math.pow(Math.abs(arrayY[num2]- arrayY[num] ), D);
       if(sum > biggest ){
         biggest = sum;
       }
       if(sum < smallest && sum != 0 ){
          smallest = sum;
       }
       if(num <= 0 && num2 == arrayX.length-1){
         return (smallest + " " + biggest);
       }
       return looprekurs(num-1, num2 + 1, arrayX, arrayY, biggest, smallest,D);
       

    }
    private static int KomposisiFungsiRekurs(int A , int B , int K ,int x){
;      int returned = Math.abs((x *A) + B );
       if(K == 1){
        return returned; 
       }
       return KomposisiFungsiRekurs( A, B,K-1,returned);
    }

    private static int KomposisiFungsi(int A,int B,int K,int x){
        int returned = Math.abs((x *A) + B );
        for(int i = 0;i<K-1;i++){
            returned = Math.abs(returned*A + B);
        }
        return returned;
    }


    // private static int KomposisiFungsi(num,int A,int B,int int count){
    //     int temp = A*num + B;
    //     // int returned = Math.abs( ) ;
    //     // // for(int i = 0;i<count-1;i++ ){
    //     // //     returned = Math.abs((A*returned) + B);
    //     // // }
    //     return temp;


   

      
    


    
          
     

    //  int n = scan.nextInt();
    //  int div;
    //  int sum = 1;

    //  for(int i = 2; i <= n; ++i){
    //      if(n%i == 0){
    //          div = i;
    //          n/= div;
    //          while(n%i == 0){
    //              n/= i;
    //              ++sum;
    //          }
    //          if(sum == 1){
    //              System.out.print((i < n) ? div + " x " : div);
    //          }else{
    //              System.out.print((i < n) ? div + "^" + sum  + " x " : div + "^" + sum);
    //              sum = 1;
    //          }
    //      }
    //  }
    
    
    private static int[][] arrayInput(int baris,int kolom) throws IOException{
        int[][] returned = new int[baris][kolom];
        for(int i = 0;i<baris;i++){
            for(int j = 0;j<kolom;j++){
                returned[i][j] = scan.nextInt();
            }
        }
        return returned;
    }


    private static void printArray2D(int[][] array){
        for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array[i].length;j++){
               System.out.print(array[i][j ] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isPrime(int num){
        if(num <2) return false;
        if(num == 2 || num == 3) return true;
        for(int i = 3;i<num;i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;

    }

    
}

    



