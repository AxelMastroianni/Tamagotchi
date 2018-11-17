package it.unibs.fp.lab.tamagotchi;
import java.util.*;

import it.unibs.fp.mylib.InputDati;
public class ZooDiTamagotchi {
	public Tamagotchi creaTamagotchi() {
		String nome=InputDati.leggiStringaNonVuota("Inserisci il nome del Tamagotchi:");
		return new Tamagotchi(nome,50,50);
	}
	public TamaTriste creaTamaTriste() {
		String nome=InputDati.leggiStringaNonVuota("Inserisci il nome del Tamagotchi: ");
		return new TamaTriste(nome,30,50);
	}
	public TamaGordo creaTamaGordo() {
		String nome=InputDati.leggiStringaNonVuota("Inserisci il nome del Tamagotchi: ");
		return new TamaGordo(nome,75,50);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
