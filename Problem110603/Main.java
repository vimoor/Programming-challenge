import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	private static BigInteger[] lista = new BigInteger[1001];

	
	private static void generador() {
		lista[1] = BigInteger.valueOf(2);
		lista[2] = BigInteger.valueOf(5);
		lista[3] = BigInteger.valueOf(13);
		BigInteger dos = BigInteger.valueOf(2);
		for (int i = 4; i < 1001; i++) {
			lista[i] = ((lista[i - 1].multiply(dos)).add(lista[i - 2])).add(lista[i - 3]);
		}
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		generador();
		while (entrada.hasNext()) {
			System.out.println(lista[entrada.nextInt()]);
		}
		entrada.close();
	}
}