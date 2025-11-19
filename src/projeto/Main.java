package projeto;

import java.time.LocalTime;
import java.util.Scanner;

import projeto.entidades.Mapa;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		String regicio = terrivelInterfaceDeUsuario();
		Mapa apa = new Mapa();

		LocalTime inicio = LocalTime.now();
		apa = escavar(apa, regicio);
		LocalTime fim = LocalTime.now();

		System.out.println();
		System.out.println("Resultado final");
		System.out.println();

		apa.printar();
		System.out.println(
				"Horario de Inicio: " + inicio.getHour() + ":" + inicio.getMinute() + ":" + inicio.getSecond());
		System.out.println("Horario de termino: " + fim.getHour() + ":" + fim.getMinute() + ":" + fim.getSecond());

	}

	public static Mapa escavar(Mapa velho, String alvo) throws InterruptedException {

		if (velho.preenchido() == true)
			return velho;

		velho.printar();
		Thread.sleep(10);

		Mapa novo = new Mapa(velho);
		// colorindo norte;
		if (alvo.equals("norte")) {

			if (novo.norte != null)
				return null;

			for (int i = 0; i < 6; i++) {
				if (i == 0 || i == 3)
					novo.norte = "preto";
				if (i == 1 || i == 4)
					novo.norte = "azul";
				if (i == 2 || i == 5)
					novo.norte = "vermelho";

				String regiao = "";

				if (i < 3)
					regiao = "nordeste";
				else
					regiao = "centro";

				if (novo.verificar() == true) {
					Mapa temporario = escavar(novo, regiao);
					if (temporario != null)
						return temporario;
				}
			}
			return null;
		} else if (alvo.equals("nordeste")) {

			if (novo.nordeste != null)
				return null;

			for (int i = 0; i < 9; i++) {
				if (i == 0 || i == 3 || i == 6)
					novo.nordeste = "preto";
				if (i == 1 || i == 4 || i == 7)
					novo.nordeste = "azul";
				if (i == 2 || i == 5 || i == 8)
					novo.nordeste = "vermelho";

				String regiao = "";

				if (i < 3)
					regiao = "centro";
				else if (i >= 3 && i < 6)
					regiao = "sudeste";
				else if (i >= 6 && i < 9)
					regiao = "norte";

				if (novo.verificar() == true) {
					Mapa temporario = escavar(novo, regiao);
					if (temporario != null)
						return temporario;
				}

			}
			return null;
		} else if (alvo.equals("centro")) {

			if (novo.centroOeste != null)
				return null;

			for (int i = 0; i < 12; i++) {
				if (i == 0 || i == 3 || i == 6 || i == 9)
					novo.centroOeste = "preto";
				if (i == 1 || i == 4 || i == 7 || i == 10)
					novo.centroOeste = "azul";
				if (i == 2 || i == 5 || i == 8 || i == 11)
					novo.centroOeste = "vermelho";

				String regiao = "";

				if (i < 3)
					regiao = "nordeste";
				else if (i >= 3 && i < 6)
					regiao = "sudeste";
				else if (i >= 6 && i < 9)
					regiao = "norte";
				else if (i >= 9 && i < 12)
					regiao = "sul";

				if (novo.verificar() == true) {
					Mapa temporario = escavar(novo, regiao);
					if (temporario != null)
						return temporario;
				}
			}
			return null;
		} else if (alvo.equals("sudeste")) {

			if (novo.sudeste != null)
				return null;

			for (int i = 0; i < 9; i++) {
				if (i == 0 || i == 3 || i == 6)
					novo.sudeste = "preto";
				if (i == 1 || i == 4 || i == 7)
					novo.sudeste = "azul";
				if (i == 2 || i == 5 || i == 8)
					novo.sudeste = "vermelho";

				String regiao = "";

				if (i < 3)
					regiao = "centro";
				else if (i >= 3 && i < 6)
					regiao = "sul";
				else if (i >= 6 && i < 9)
					regiao = "nordeste";

				if (novo.verificar() == true) {
					Mapa temporario = escavar(novo, regiao);
					if (temporario != null)
						return temporario;
				}
			}
			return null;
		} else if (alvo.equals("sul")) {

			if (novo.sul != null)
				return null;

			for (int i = 0; i < 6; i++) {
				if (i == 0 || i == 3)
					novo.sul = "preto";
				if (i == 1 || i == 4)
					novo.sul = "azul";
				if (i == 2 || i == 5)
					novo.sul = "vermelho";

				String regiao = "";

				if (i < 3)
					regiao = "sudeste";
				else
					regiao = "centro";

				if (novo.verificar() == true) {
					Mapa temporario = escavar(novo, regiao);
					if (temporario != null)
						return temporario;
				}
			}
			return null;
		} else
			throw new RuntimeException("Região não encontrada");

	}

	public static String terrivelInterfaceDeUsuario() {

		System.out.println("Essa é a Terrivel Interface de Usuário, uhuuuuuuuuuuuuu! tenha medo;");
		System.out.println(
				"A partir de assustadoras interações você vai escolher o seu ponto de partida para o colorimento do mapa.");
		System.out.println("uhuuuuuuuuuuuu, assustador!");
		System.out.println("Digite o número tenebrono indicado para escolher a terrivel região.");
		System.out.println();
		System.out.println(" 1 - Norte. ");
		System.out.println(" 2 - Nordeste. ");
		System.out.println(" 3 - Sudeste. ");
		System.out.println(" 4 - Centro-Oeste. ");
		System.out.println(" 5 - Sul. ");
		System.out.println();
		System.out.print("Escolha: ");

		Scanner entrada = new Scanner(System.in);

		int valor = 0;

		String resultado = "sudeste";

		try {
			valor = entrada.nextInt();
			entrada.close();

		} catch (Exception e) {
			System.out.println();
			System.out.println(
					"Você entrou com um tenebroso valor invalido, como uma punição assustadora, começaremos com o Sudeste por padrão.");

			return resultado;
		}

		if (valor == 1)
			resultado = "norte";
		else if (valor == 2)
			resultado = "nordeste";
		else if (valor == 3)
			resultado = "sudeste";
		else if (valor == 4)
			resultado = "centro";
		else if (valor == 5)
			resultado = "sul";
		else
			System.out.println(
					"Como a responta foi assustadoramente invalida, o tenebroso ponto de inicio será o sudeste, uhuuuuuuuuu!!");

		return resultado;
	}

}
