package entidades;

import java.time.LocalTime;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Mapa apa = new Mapa();
		
		LocalTime inicio = LocalTime.now();
		apa =escavar(apa, "sudeste");
		LocalTime fim = LocalTime.now();

		System.out.println();
		System.out.println("Resultado final");
		System.out.println();
		
		System.out.println("Horario de Inicio: "+inicio.getHour()+":"+inicio.getMinute()+":"+ inicio.getSecond());
		System.out.println("Horario de termino: "+fim.getHour()+":"+fim.getMinute()+":"+ fim.getSecond());
		apa.printar();
		

	}

	public static  Mapa escavar(Mapa velho, String alvo) throws InterruptedException {

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

				if(novo.verificar() == true) {
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

				if(novo.verificar() == true) {
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

				if(novo.verificar() == true) {
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

				if(novo.verificar() == true) {
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

				if(novo.verificar() == true) {
					Mapa temporario = escavar(novo, regiao);
					if (temporario != null)
						return temporario;					
				}
			}
			return null;
		} else throw new RuntimeException("Região não encontrada");

	}

}
