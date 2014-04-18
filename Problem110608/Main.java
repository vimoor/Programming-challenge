import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static final int MAX_VALOR = 2147483647; // 2^31
	private static ArrayList<Long> array = new ArrayList<Long>();
	

	private static void precargaArray() {
		array.add((long) 0);
		int incremento = 1;
		for (int i = 1; array.get(i - 1) < MAX_VALOR; i += 2) {
			array.add(array.get(i - 1) + incremento);
			array.add(array.get(i) + incremento);
			incremento++;
		}
	}

	private static int numeroDePasos(long n, int inicio, int fin) {
		int pivote = (fin + inicio) / 2;
		if (fin - inicio == 1) {
			return fin;
		}

		if (array.get(pivote) > n) {
			return numeroDePasos(n, inicio, pivote);
		} else if (array.get(pivote) < n) {
			return numeroDePasos(n, pivote, fin);
		} else {
			return pivote;
		}
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		precargaArray();

		int x, y, diferencia, numPasos;
		int numCasos = entrada.nextInt();
		while (numCasos > 0) {
			x = entrada.nextInt();
			y = entrada.nextInt();
			diferencia = y - x;
			if (diferencia <= 0) {
				System.out.println(0);
			} else {
				numPasos = numeroDePasos(diferencia, 0, array.size());
				System.out.println(numPasos);
			}
			numCasos--;
		}
		entrada.close();
	}

}