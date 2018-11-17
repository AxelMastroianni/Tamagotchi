package it.unibs.fp.lab.tamagotchi;
import  java.util.*;

public class TamaZoo {
	private ArrayList<Tamagotchi> palleDiLardo = new ArrayList<Tamagotchi>();

	public void aggiungiTamagotchi(Tamagotchi pallaDiLardo) {
		palleDiLardo.add(pallaDiLardo);
	}
	
	public boolean deathZone() {
		int mortiSulCampo=0;
		for (int i=0; i<palleDiLardo.size();i++) {
			if (palleDiLardo.get(i).sonoMorto())
				mortiSulCampo++;
		}
		if(mortiSulCampo==palleDiLardo.size())
			return true;
		return false;
	}
	
	public void daiBiscotti(int quantiBiscotti) {
		for(int i=0; i<palleDiLardo.size();i++) {
			palleDiLardo.get(i).riceviBiscotti(quantiBiscotti);
		}
	}
	
	public void daiCarezze(int quanteCarezze) {
		for(int i=0; i<palleDiLardo.size();i++) {
			palleDiLardo.get(i).riceviCarezze(quanteCarezze);
		}
	}
}
