import java.util.*;
import java.io.*;

	public class Main {

	 	private static void echo (String s){
			System.out.print(s);
		}

		public static boolean isSorted(int [] Pancakes){
	    for (int i=0; i< ((Pancakes.length)-1); i++)
	        if (Pancakes[i] > Pancakes[i+1]) return false;
	 
	    return true;
		}

		public static boolean moverMayorAlPrincipio(int end, String volteos){
			int maximo = -1;
			for(int i = 0; i < end; i++){
				if(i == 0 || torre[i] > torre[maximo]) maximo = i;
			}
			if(maximo == 0) return true;
			if(maximo == end-1) return false;
			reverse(0, maximo+1);
			return true;
		}

		public static void reverse (int begin, int end){
			int [] aux = new int [torre.length];
			int indexaux = end-1;
	 		for ( int i = begin; i < end; i++){
	 			aux[indexaux--]=torre[i]; 
	 		}
	 		for ( int i = begin; i < end; i++){
	 			torre[i] = aux[i];
	 		}
	 		volteos+=torre.length-end+1+" ";
		}

		private static Scanner entrada = new Scanner(System.in);
		private static int [] torre;
		private static String volteos;

		public static void main(String[] args) {
			while (entrada.hasNextLine()){
				String cadena = entrada.nextLine();
				String [] aux = cadena.split(" ");
				volteos="";
				torre = new int[aux.length];
				
				for(int i = 0; i < torre.length; i++){
					torre[i] = Integer.parseInt(aux[i]);
				}

				for (int i = torre.length; !isSorted(torre); i--){
					if(moverMayorAlPrincipio(i, volteos)){
						reverse(0,i);
						
					}
				}

				echo(cadena+"\n");
				echo(volteos);
				echo("0\n");


			}
		}
	}