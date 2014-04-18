import java.util.*;
import java.io.*;
class Main{

    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args){
        long n = entrada.nextInt();
        double lg, lo;
        while(entrada.hasNextLine()){
            lg = Math.log(n)/Math.log(18.0);
            lo = Math.floor(lg);
            if(lg-lo < 0.00000000001){System.out.println("Ollie wins.");}
            else if(n/Math.pow(18.0,lo) > 9.0){System.out.println("Ollie wins.");}
                else System.out.println("Stan wins.");
            n = entrada.nextInt();
        }
    }
}