/*
* Problema 110106 Interprete.
* Author: vimoor1.
* v1.1 (Solved)
*/
import java.io.*;
import java.util.*;
class Main
{
	static Scanner entrada = new Scanner(System.in);

	public static void main( String args[] )
	{	
		int caso = 0;
		int casos = Integer.parseInt(entrada.nextLine());
		entrada.nextLine();
		while (++caso <= casos){
			int [] ram = new int [1000];
			int instrucciones = 0;
			for(int i = 0 ; i < ram.length; i++){
				ram[i] = 000;
			}
			int first=0; 
			int second=0; 
			int third =0;
			int instruccion = 0;
			boolean acabar = true;
			String lectura = "";
			int i = 0;
			int pc = 0;
			while(acabar){
				lectura = entrada.nextLine();
				if (lectura.equals("")||!entrada.hasNext()) {
					acabar = false;
					break;
				}
				ram[i] = Integer.parseInt(lectura);
				i++;
			}


			int [] registro= new int [10];
			acabar = true;
			while(acabar){
				instrucciones++;
				instruccion = ram[pc];
				first = instruccion/100;
				second = (instruccion/10)%10;
				third = instruccion%10;
				switch (first){
					case 1:
						acabar = false;
						break;
					case 2:
						registro[second] = third; 
						pc++;
						break;
					case 3:
						registro[second] = (registro[second]+third)%1000;
						pc++;
						break;
					case 4:
						registro[second] = (registro[second]*third)%1000;
						pc++;
						break;
					case 5:
						registro[second] = registro[third];
						pc++;
						break;
					case 6:
						registro[second] = (registro[second]+registro[third])%1000;
						pc++;
						break;
					case 7:
						registro[second] = (registro[second]*registro[third])%1000;
						pc++;	
						break;
					case 8:
						registro[second] = ram[registro[third]];
						pc++;
						break;
					case 9:
						ram[registro[third]] = registro[second]; 
						pc++;
						break;
					case 0:
						if(registro[third]!= 0){
							pc = registro[second];
						}else
							pc++;
						break;

				}
				
			}
			System.out.println(instrucciones);
			if(caso < casos) System.out.println();
		}
	}
}

