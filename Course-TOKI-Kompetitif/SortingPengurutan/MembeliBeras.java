import java.io.*;
import java.util.*;

public class MembeliBeras {
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
    static int X;
    static{
        N = in.nextInt();
        X = in.nextInt();
    }

    private static double [] wArray = new double[N];
    private static double[] totPrice = new double[N];
    private static double[] pricePerKg = new double[N];

    private static final Comparator<String> tamuSort = new Comparator<String>()
    {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() < o2.length()){
                return -1;
            }else if(o1.length() > o2.length()){
                return 1;
            }else{
                return o1.compareTo(o2);
            }
        }
    };

    public static void main(String[] args) {
        double price = 0.0;
        double karung = 0.0;

        for(int i = 0;i<N;i++){
            wArray[i] = in.nextInt();
        }
        for(int i = 0;i<N;i++){
            totPrice[i] = in.nextInt();
            pricePerKg[i]= totPrice[i]/wArray[i];
        }
        bubbleSort(wArray);

        int i = 0;
        while( i <= N-1 && karung + wArray[i] < X ){
            karung+=wArray[i];
            price += wArray[i] * pricePerKg[i];
            i++ ;
        }
        if(i== N){
            System.out.printf("%.5f",(price));
        }else{
            System.out.printf("%.5f",(price + ((X-karung)* pricePerKg[i])));
        }


//        printArray(wArray);
//        System.out.println();
//        System.out.println("---------------------------------");
//        printArray(quantity);


//        printArray();
        out.close();
    }

    private static int binSer(int[] h,int X) {

            int kiri = 0;
            int kanan = h.length-1;

            int index = -1;

            while(index == -1) {
                int tengah = (kiri + kanan)/2;
                if(h[tengah] > X){
                    if((tengah-1) < 0){
                        return tengah-1;
                    }
                    else if(h[tengah-1] < X){
                        index = tengah-1;
                    }
                    kanan = tengah-1;
                }else if(h[tengah] <= X){
                    if((tengah+1) > h.length-1 ){
                        return tengah;
                    }
                    else if(h[tengah+1]>X){
                        index = tengah;
                    }
                    kiri = tengah +1;
                }
                else{
                    index = tengah;
                }

            }

            return index;

        }

//    private static int bebekInsertion(String insert){
//        int pos = array.length-1;
//        array[pos] = insert;
//
//        while(pos>0){
//            if(array[pos-1] == null || array[pos].compareTo(array[pos-1]) < 0 ){
//                swap(pos,pos-1);
//                pos-=1;
//            }else{
//                return pos+1;
//            }
//        }
//        return pos+1;
//    }

      private static void swap(int i ,int j,double[] array){
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;

      }
      private static void bubbleSort(double[] array){
        for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array.length-i-1;j++){
                if(pricePerKg[j] < pricePerKg[j+1]){
                    swap(j,j+1,array);
                    swap(j,j+1,pricePerKg);
                }
            }

        }
      }
      private static void printArray(double[] array){
         for(double element : array){
             System.out.print(element + " ");
         }
      }

}














