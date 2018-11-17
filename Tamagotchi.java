package it.unibs.fp.lab.tamagotchi;
import java.util.*;
public class Tamagotchi {
	protected static final int PALLA_DI_LARDO = 90;
	protected static final double FATTORE_CENTO = 100;
	protected static final double FATTORE_DIECI = 10;
	protected Random r=new Random();
	protected static final int AUMENTA = 1;
	public static enum Sessi{M,F,m,f}; //evita il controllo sul sesso
	protected String nome="";
	protected Sessi sesso;
	protected double sazieta=0;
	protected double soddisfazione=0;
	protected static final int MAX_CAREZZE_BISCOTTI=20;
	protected static final int DIMINUISCI_RAPPORTO=4;
	protected static final int MAX_SATISFACTION_EAT=100;
	protected static final int SOGLIA_FELICITA=75;
	protected static final int SOGLIA_TRISTEZZA=30;
	public Tamagotchi(String nome)
	{
		this.nome=nome;
		this.sesso=Sessi.values()[Math.abs(r.nextInt()%Sessi.values().length)]; //sesso estratto a caso
	}
	public Tamagotchi(String nome, int soddisfazione, int sazieta) {
		this.nome=nome;
		this.soddisfazione=soddisfazione;
		this.sazieta=sazieta;
		this.sesso=Sessi.values()[Math.abs(r.nextInt()%Sessi.values().length)];
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Sessi getSesso() {
		return sesso;
	}
	public void setSesso(Sessi sesso) {
		this.sesso = sesso;
	}
	public double getSazieta() {
		return sazieta;
	}
	public double getSoddisfazione() {
		return soddisfazione;
	}
	//inizia l'interazione con la bestia
	
	public void riceviBiscotti(int quantiBiscotti)
	{
		aumentaSazieta(quantiBiscotti);
		quantiBiscotti=Math.min(quantiBiscotti, MAX_CAREZZE_BISCOTTI);//non rischi di dargliene più di 20
		if(quantiBiscotti/DIMINUISCI_RAPPORTO!=0)
			diminuisciSoddisfazione(quantiBiscotti);
	}
	public void riceviCarezze(int quanteCarezze)
	{
		quanteCarezze=Math.min(quanteCarezze, MAX_CAREZZE_BISCOTTI); //non gliene dai più di 20
		aumentaSoddisfazione(quanteCarezze);
		if(quanteCarezze/DIMINUISCI_RAPPORTO!=0)
			diminuisciSazieta(quanteCarezze);
	}
	
	
	private void aumentaSazieta(int quantiBiscotti)
	{
		sazieta=Math.min(sazieta+(quantiBiscotti*(FATTORE_DIECI/FATTORE_CENTO)),MAX_SATISFACTION_EAT);//non va oltre 100
	}
	private void aumentaSoddisfazione(int quanteCarezze)
	{
		soddisfazione=Math.min(soddisfazione+AUMENTA*quanteCarezze, MAX_SATISFACTION_EAT);//non va oltre 100
	}
	
	
	private void diminuisciSazieta(int quanteCarezze)
	{
			sazieta=Math.max(sazieta-(quanteCarezze/2),0); //non va sotto zero
	}
	private void diminuisciSoddisfazione(int quantiBiscotti)
	{
			soddisfazione=Math.max(soddisfazione-(quantiBiscotti/4),0); //non va sotto zero
	}
	
	
	public boolean controllaSazieta()
	{
		if(sazieta>=MAX_SATISFACTION_EAT)
			return true;
		return false;
	}
	public boolean controllaSoddisfazione()
	{
		if(soddisfazione>=MAX_SATISFACTION_EAT)
			return true;
		return false;
	}
	
	
	public boolean verificaFelicita()
	{
		if(sazieta>SOGLIA_FELICITA && soddisfazione>SOGLIA_FELICITA)
			return true;
		return false;
	}
	public boolean sonoTriste()
	{
		if(sazieta<SOGLIA_TRISTEZZA || soddisfazione<SOGLIA_TRISTEZZA || sazieta>PALLA_DI_LARDO)
			return true;
		return false;
	}
	
	public boolean sonoMorto() {
		if(soddisfazione==0 || sazieta==0)
			return true;
		else if(sazieta==MAX_SATISFACTION_EAT)
			return true;
		return false;
	}

}
