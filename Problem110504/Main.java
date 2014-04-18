/*
 *Author : Vicent Morera Orchilles.
 *PC(110504): Solved. Time: 0.235
 *Uva(10129): Accepted. Time:0.195
 *Version : 1.0;
 */
import java.util.*;
import java.io.*;

public class Main{

	private static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		int num;
		while (entrada.hasNextLine()){
			num = Integer.parseInt(entrada.nextLine());
			int cont = 0;
			int aux = num;
			while(num != 0){
				if(num%10 == 1){
					cont++;
					num/=10;
				}
				else num+=aux;
			}
			System.out.println(cont);
		}
	}


}