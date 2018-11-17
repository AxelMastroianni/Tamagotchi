package it.unibs.fp.lab.tamagotchi;

public class TamaTriste extends Tamagotchi {
	
	public TamaTriste(String nome, int soddisfazione, int sazieta) {
		super(nome, soddisfazione, sazieta);
		soddisfazione=Math.abs(r.nextInt()*SOGLIA_TRISTEZZA); //valore mai oltre 30
	}

	public TamaTriste(String nome) {
		super(nome);
		soddisfazione=Math.abs(r.nextInt()*SOGLIA_TRISTEZZA);
	}
	/**
	 * @override
	 * @param quanteCarezze
	 */
	public void aumentaSoddisfazione(int quanteCarezze) {
		soddisfazione=Math.min(soddisfazione+AUMENTA*quanteCarezze, SOGLIA_TRISTEZZA);//non va oltre 100	
	}
	
	/**
	 * @override 
	 */
	public boolean sonoTriste() {
			return true;
	}
	/**
	 * @override
	 */
	public boolean sonoMorto() {
		if(sazieta==0)
			return true;
		else if(sazieta==MAX_SATISFACTION_EAT)
			return true;
		return false;
	}
	
}
