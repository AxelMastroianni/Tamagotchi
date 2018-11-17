package it.unibs.fp.lab.tamagotchi;

public class TamaGordo extends Tamagotchi {

	public TamaGordo(String nome, int soddisfazione, int sazieta) {
		super(nome,SOGLIA_FELICITA, sazieta);
	}

	public TamaGordo(String nome) {
		super(nome);
	}

	public void diminuisciSazieta(int quanteCarezze) {
		sazieta=Math.max(sazieta-(quanteCarezze),0); //non va sotto zero e diminuisce del doppio
	}
	
	public boolean sonoMorto() {
		if(sazieta==0)
			return true;
		return false;
	}
	
	public boolean sonoTriste() {
		if(sazieta<SOGLIA_TRISTEZZA)
			return true;
		return false;
	}
	/**
	 * @override
	 * @param quantiBiscotti
	 */
	public void diminuisciSoddisfazione(int quantiBiscotti) {
		soddisfazione=Math.max(soddisfazione-(quantiBiscotti/4),SOGLIA_FELICITA); //non va sotto la soglia
	}
}
