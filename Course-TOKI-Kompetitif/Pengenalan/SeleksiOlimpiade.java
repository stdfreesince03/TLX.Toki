

/*
    Input :
    Reader viliya = new Reader();
    int x = viliya.nextInt();
    string y = viliya.nextLine();
*/

import java.io.IOException;
import java.util.*;

public class SeleksiOlimpiade

{
    private static Scanner scan = new Scanner(System.in);
    private static int[][] array = new int[80][3];
    private static String[] answer = new String[80];

    public static void main(String[] args) throws IOException{

        int T  = scan.nextInt();
        scan.nextLine();

        for(int j = 0;j<T;j++) {

            int N = scan.nextInt();
            int M = scan.nextInt();
            scan.nextLine();

            String l = scan.nextLine();
            int toLulus = Integer.parseInt(l.substring(1));


            int[][] Narray = new int[N][3];

            for (int i= 0; i < N; i++) {
                String participant = scan.next();
                int parttId = Integer.parseInt(participant.substring(1));
                Narray[parttId - 1][0] = scan.nextInt();
                Narray[parttId - 1][1] = scan.nextInt();
                Narray[parttId - 1][2] = scan.nextInt();
            }
            answer[j] = Lulus(toLulus, M, N, Narray);

        }
        for(int i = 0;i<T;i++){
            System.out.println(answer[i]);
        }

    }
    private static String Lulus(int toLulus,int M,int N,int[][] Narray){
        int count = 0;
        int[] mainCompare = Narray[toLulus-1];
        for(int i = 0;i<N;i++){
            if(mainCompare[2] > Narray[i][2]){
                count++;
            }else if(mainCompare[2] == Narray[i][2]){
                if(mainCompare[1] > Narray[i][1]){
                    count++;
                }
                else if(mainCompare[1] == Narray[i][1]){
                    if(mainCompare[0] > Narray[i][0]){
                        count++;
                    }
                }
            }
        }
        int position = N-count;
        if(position <= M){
            return "YA";
        }else{
            return "TIDAK";
        }

    }

    private static void swap(int swap1,int swap2){
        int[] temp = array[swap2];
        array[swap2] = array[swap1];
        array[swap1] = temp;
    }

    private static void gradyJancok(int start,int initial){
        if (start % initial == 0){
            System.out.println(start);
        }

        if(initial <= 9){
            System.out.println(initial);
        }
        if(start <9 ){
            gradyJancok(start+1,initial);
        }
        gradyJancok((start *10) + start, initial);

    }
}

    
    



  

