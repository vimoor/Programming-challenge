/*
 * Author : Vicent Morera Orchilles.
 * Uva : 	Time:
 * Version : 1.0.
 */
import java.util.*;
import java.io.*;
class Main{

	private static Scanner entrada = new Scanner(System.in);
	private static int maximo = 673370;
	private static long [] array = new long [maximo];


	private static void precalculo(){
		int k = 2;
		array[1] = 1;
		for (int i = 2; i < array.length; i++){
			array[i] = array[i-1]+k;
			if (i == array[k]) k++;
		}
	}

	private static void echo(String s){
		System.out.print(s);
	}
	
	private static void imprimirBucle(){
		for (int i = 1; i < array.length; i++){
			echo(array[i]+" ");
		}
		echo("\n");
	}

	private static int buscar(long n,  int inicio, int fin){
		int pivote = (fin + inicio)/2;
		if (fin - inicio == 1){
			return fin;
		}
		if (array[pivote] > n){
			return buscar(n,inicio, pivote);
		}else if (array[pivote] < n){
			return buscar(n,pivote, fin);
		}
		else return pivote;
	}

	public static void main ( String [] args){
		long n = entrada.nextLong();
		precalculo();
		while(n != 0){
			//imprimirBucle();
			echo(buscar(n,0, array.length)+"\n");
			n = entrada.nextLong();
		}
	}
}