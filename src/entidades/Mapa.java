package entidades;

public class Mapa {

	String norte;
	String nordeste;
	String sul;
	String sudeste;
	String centroOeste;
	
	//contando quantas posibilidades foram esploradas
	static long interacoes;
	
	//contando quantas çinhas foram necessárias para chegar no resultado
	long incarnacao;
	
	public Mapa() {
		this.norte = null;
		this.nordeste = null;
		this.sudeste = null;
		this.centroOeste = null;
		this.sul = null;
		this.incarnacao = 0;
		interacoes = 0;
	}

	public Mapa(Mapa mapa) {
		this.norte = mapa.norte;
		this.nordeste = mapa.nordeste;
		this.sudeste = mapa.sudeste;
		this.centroOeste = mapa.centroOeste;
		this.sul = mapa.sul;
		this.incarnacao = mapa.incarnacao +1;
		interacoes++;
	}
	
	public boolean verificar() {
		
		if(norte != null) {
			if(norte.equals(nordeste)) return false;
			if(norte.equals(centroOeste)) return false;
		}
		if(nordeste != null) {
			if(nordeste.equals(norte)) return false;
			if(nordeste.equals(centroOeste)) return false;
			if(nordeste.equals(sudeste)) return false;

		}
		if(sul != null) {
			if(sul.equals(centroOeste)) return false;
			if(sul.equals(sudeste)) return false;
		}
		if(sudeste != null) {
			if(sudeste.equals(centroOeste)) return false;
			if(sudeste.equals(sul)) return false;
			if(sudeste.equals(nordeste)) return false;

		}
		if(centroOeste != null) {
			if(centroOeste.equals(norte)) return false;
			if(centroOeste.equals(sul)) return false;
			if(centroOeste.equals(nordeste)) return false;
			if(centroOeste.equals(sudeste)) return false;

		}
		
		return true;
	}
	
	public boolean preenchido() {
		
		if(norte!=null)
			if(nordeste!=null)
				if(sudeste!=null)
					if(centroOeste!= null)
						if(sul!=null) return true;
		
		return false;
	}
	
	public void printar() {
		System.out.println();
		System.out.println("Numero de interações:" + interacoes);
		System.out.println("Incarnação:" + incarnacao);

		System.out.println();
		System.out.println("Norte: " + this.norte);
		System.out.println("Nordeste: " + this.nordeste);
		System.out.println("Centro Oeste: " + this.centroOeste);
		System.out.println("Sudeste: " + this.sudeste);
		System.out.println("Sul: " + this.sul);
		System.out.println();

	}
	}
