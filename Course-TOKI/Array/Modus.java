import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Modus {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        boolean hasNext(){
            try{
                if(br.toString() != null){
                    return true;
                }
            }catch(Exception e ){
                e.printStackTrace();
            }
          
            return false;
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }

    }
    public static void main(String[] args) throws Exception {
       
        FastReader in = new FastReader();

        int t =in.nextInt();
        int[] a = new int[t];
        for(int i = 0;i<t;i++){
            a[i] = in.nextInt(); //array input
        }

        int max = Arrays.stream(a).max().getAsInt();

        int[] newA = new int[max+1];
        for(int i = 0;i<a.length;i++){
            newA[a[i]] ++;
        }

        int index = a[0];
        for(int i = 0;i<a.length;i++){
            if(newA[a[i]] > newA[index]){
                index = a[i];
            } if(newA[a[i]] == newA[index]){
                if(a[i] > index){
                    index = a[i];
                }
            }
        }
        System.out.println( index);

        
    }
}
