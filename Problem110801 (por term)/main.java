/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.*;
import java.io.*;

/**
 *
 * @author vimoor1
 */
public class Main {
    
    static private Scanner entrada = new Scanner(System.in);
    static private int n = 0, k = 0;
    static private int alfilescolocados = 0;
    /**
     * @param args the command line arguments
     */
    
    public static int resolver(int[][]matriz, int k, int n){
        int soluciones = 0;
        if (k==0){
            soluciones++;
            
        }
        else{
            k--;
            for (int i = 0, i < n ; i++){
                for (int j = 0; j < n; j++){
                    resolver(matriz,k++,n);
                    meter_alfil(matriz,k,n,i,j);
                    resolver(matriz,k,n);
                    restaurar_matriz(matriz,k,n,i,j);
                    
                }
            }
            
            
            candidatos(matriz,k,n);
        }
        return soluciones;
    }
    
    
    public static void candidatos(int[][]matriz, int k, int n)
    {
        
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int maximo []= {0,1,2,4,6,8,10,12,14};
        while ((n = entrada.nextInt()) != 0 && (k = entrada.nextInt()) != 0) {
            if (k > maximo[n]) System.out.println("0");
            else{
                int [][] matriz = new int[n][n];
                int soluciones = resolver(matriz,k,n);
                System.out.println(soluciones);
            }
        }
    }
}
