package it.unibs.fp.lab.tamagotchi;
import java.util.*;
import it.unibs.fp.mylib.*;
public class Gioca {
	public static Tamagotchi creaTamagotchi()
	{
		String nome=InputDati.leggiStringaNonVuota("Inserisci il nome del tuo animaletto: ");
		return new Tamagotchi(nome,50,50);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		Scanner tastiera=new Scanner(System.in);
		String[] voci=new String[] {"Accarezza", "Dai Biscotti", "Verifica Felicita","Controlla Sazietà", "Controlla Soddisfazione"};
		MyMenu menu =new MyMenu("Tamagotchi V4", voci);
		String nomeUtente="";
		String risposta="";
		int scelta=0;
		int carezze=0, biscotti=0;
		
		System.out.println("Inserisci il tuo nickname: ");
		nomeUtente=tastiera.nextLine();
		System.out.println("Benvenuto "+nomeUtente+", questo è il Tamagotchi V4");
		Tamagotchi t=creaTamagotchi();
		System.out.println("Il tuo Tamagotchi si chiama: "+t.getNome()+" ed è di sesso "+t.getSesso()+"\n Divertiti con lui!");
		System.out.println("Premi un tasto per continuare: "); risposta=tastiera.next();
		while(!t.sonoMorto())
		{
			scelta=menu.scegli();
			switch(scelta)
			{
				case 1: 
				{
					carezze=Math.abs(r.nextInt()%20)+1;
					System.out.println("Gli fai "+carezze+" carezze");
					t.riceviCarezze(carezze); break;
				}
				case 2:
				{
					biscotti= Math.abs(r.nextInt(20))+1;
					System.out.println("Gli dai "+biscotti+" biscotti");
					t.riceviBiscotti(biscotti); break;
				}
				case 3:
				{
					if(t.verificaFelicita())
						System.out.println("Sono contentissimo! :D");
					else if(t.sonoTriste())
						System.out.println("Sono triste :(");
					else
						System.out.println("Sto bene, grazie :)");
					break;
				}
				case 4:
				{
					if(t.controllaSazieta())
						System.out.println("Sono pieno, se continui a darmi da mangiare scoppio D:");
					else
						System.out.println("Questo è il mio livello di sazietà: "+t.getSazieta());
				}
				case 5: 
				{
					if(t.controllaSoddisfazione())
						System.out.println("Sono così affettuoso che abbraccerei tutti :)");
					else
						System.out.println("Questo è il mio livello di soddisfazione: "+t.getSoddisfazione());
					break;
				}
				default:
				{
					System.out.println("Non vuoi giocare con me? ");
					risposta=tastiera.next();
				}
			}
		}
		System.out.println(t.getNome()+" è stato assassinato da "+nomeUtente);

	}

}
