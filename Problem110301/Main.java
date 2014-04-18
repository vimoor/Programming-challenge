/*
* Problema 110301 WERTYU
* Author: vimoor1.
* v 1.1 (Solved)
*/
import java.io.*;
import java.util.*;
class Main
{
    static char [] teclado = {'`','1','2','3','4','5','6','7','8','9','0','-','=',
                        'Q','W','E','R','T','Y','U','I','O','P','[',']','\\',
                        'A','S','D','F','G','H','J','K','L',';','\'',
                        'Z','X','C','V','B','N','M',',','.','/'};

    static Scanner entrada = new Scanner(System.in);

    static String traducir (String frase){
        String res = "";
        for (int  i = 0; i < frase.length(); i ++){
            if (frase.charAt(i)!= ' '){
                res+=(teclado[buscar(frase.charAt(i))]);
            }
            else 
                res+= ' ';
        }
        return res;
    }

    static int buscar (char tecla){
        for (int i= 0 ; i < teclado.length; i++){
            if (teclado[i] == tecla){
                return i-1;
            }
        }
        return -1;
    }

    public static void main( String args[] )
    {   
        String frase = "";
        while (entrada.hasNextLine()){
            frase = entrada.nextLine();
            System.out.println(traducir(frase));
        }
        //frase = entrada.nextLine();
        
    }
}
