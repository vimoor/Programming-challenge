import java.util.*;

class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		while (entrada.hasNext()) {
			double a = entrada.nextDouble();
			double b = entrada.nextDouble();
			double c = entrada.nextDouble();

			if (a == 0 || b == 0 || c == 0) {
				System.out.println("The radius of the round table is: 0.000");
			} else {
				double s = (a + b + c) / 2;
				double radio = Math.sqrt(((s - a) * (s - b) * (s - c) / s));
				System.out.printf("The radius of the round table is: %.3f\n", radio);
			}
		}
	}
}