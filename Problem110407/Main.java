/*
 * Author : Vicent Morera Orchilles.
 * Uva : Accepted	Time: 2.972s
 * Version : 1.0.
 */
import java.util.*;
import java.io.*;

public class Main{
	static class pareja {
		private String  nombre;
		private int 	posicionDeseada;
		pareja(){
			this.nombre = "";
			this.posicionDeseada = 0;
		}
		pareja(String nombre, int posicionDeseada){
			this.nombre = nombre;
			this.posicionDeseada = posicionDeseada;
		}
		public int getIndex(){
			return this.posicionDeseada;
		}
		public String getNombre(){
			return this.nombre;
		}
		public int compare(pareja pair){
			if(pair.getIndex() > this.posicionDeseada)return -1;
			else if (this.posicionDeseada > pair.getIndex()) return 1;
			else return 0;
		}
		public void copy (pareja pair){
			this.nombre = pair.getNombre();
			this.posicionDeseada = pair.getIndex();
		}
		public String toString(){
			return "Nombre = "+this.nombre+" \t Posicion ="+this.posicionDeseada; 
		}

	}

	private static Scanner entrada = new Scanner(System.in);
	private static ArrayList<pareja> orden ;
	private static ArrayList<pareja> resultado ;

	
	public static void heapSort()
    {
        buildMaxHeap();
        for( int i=resultado.size()-1; i >= 1; --i ) {
            swap(0, i );
            maxHeapify(0, i );
        }
    }
    private static void buildMaxHeap()
    {
        for( int i=resultado.size()/2; i >= 0; --i ) maxHeapify(i, resultado.size());
    }
    private static void maxHeapify(int pos, int heapSize )
    {
        pos++; 

        int left  = 2*pos;
        int right = left+1;

        int largest = pos;

        if ( left  <= heapSize  &&  resultado.get(left-1).compare(resultado.get(largest-1)) > 0 ) largest = left;
        if ( right <= heapSize  &&  resultado.get(right-1).compare(resultado.get(largest-1) ) > 0 ) largest = right;

        if (largest != pos ) {
            swap(pos-1, largest-1);
            maxHeapify(largest-1, heapSize );
        }
    }
    private static void swap(int i, int j )
    {
       	pareja aux = resultado.get(i); resultado.set(i,resultado.get(j)); resultado.set(j, aux);
    }

	public static void main(String[] args) {
		int casos = 0;
		casos = Integer.parseInt(entrada.nextLine());
		for (int j = 0; j < casos ; j++){
			int poblacion = Integer.parseInt(entrada.nextLine());
			orden = new ArrayList<pareja>();
			resultado = new ArrayList<pareja>();
			String [] inicial = new String [poblacion];
			String [] deseado = new String [poblacion];
			for (int i = 0; i < poblacion; i++){
				inicial[i] = entrada.nextLine();
			}
			for (int i = 0; i < poblacion; i++){
				deseado[i] = entrada.nextLine(); 
			}

			for (int i = 0; i < poblacion; i++){
				pareja aux = new pareja(inicial[i], Arrays.asList(deseado).indexOf(inicial[i]));
				orden.add(aux);
			}
			int siguiente = poblacion-1;
			for (int i = poblacion-1; i >= 0; i--){
				if(orden.get(i).getIndex() != siguiente) resultado.add(orden.get(i));
				
				else siguiente--;
			}

			if(resultado.size()>1){
				heapSort();
			}
			for (int i = resultado.size()-1; i >= 0; i--){
				System.out.println(resultado.get(i).getNombre());
			}
				System.out.println();
			

		}

	}
}