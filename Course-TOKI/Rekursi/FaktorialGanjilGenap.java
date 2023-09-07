

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
import java.io.*;
import java.util.*;
 
public class FaktorialGanjilGenap

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

    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        int num = scan.nextInt();
        System.out.println(fak(num));
    }

    private static int fak(int num){
        if(num ==1){
            return 1;
        }

        if(num%2 == 0){
            return (num/2) * fak(num-1);
        }else{
            return num*fak(num-1);
        }

    }

    



  
}