package tema2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.BlockingQueue;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Casa implements Runnable {
	ArrayList<Client> c;
	private final Object pauseLock = new Object();
	String coada = new String();
	String coada2 = new String();
	JTextArea t = new JTextArea();
	JScrollPane p = new JScrollPane(t);
	String log = new String();
	int asteptare = 0;
	int nrClienti;
	int id;
	int procesati = 0;
	int nr_max = 20;
	boolean ok = true;
	boolean paused = false;
	
	
	public Casa(int id) {
		asteptare = 0;
		this.c = new ArrayList<Client>();
	//	this.c = new BlockingQueue();
		this.id = id;
	}
	// metoda care adauga un client la coada
	public void adauga(Client cl) {
		if(this.nrClienti<=this.nr_max) {
		c.add(cl);	
		asteptare = asteptare + cl.getProcesare();
		this.nrClienti++;
		afiseaza();
		log = "";
		log = log + "clientul cu timpul de procesare " + cl.getProcesare() + " s-a asezat la coada " + this.id + "\n";
		try {
			Scrie(log);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else { System.out.println("coada este plina");}
	}
	
	// metoda pentru scoaterea unui client din coada
	public void sterge(Client i) {
		this.c.remove(i);
		asteptare = asteptare - i.getProcesare();
		this.nrClienti--;
		procesati++;
		afiseaza();
		log = "";
		log = log + "clientul cu timpul de procesare " + i.getProcesare() + " a iesit din coada " + this.id + "\n";
		try {
			Scrie(log);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void afiseaza() {
		coada = "";
		System.out.print(this.id + "."+ " ");
		for (int i = 0;i<this.c.size();i++) {
			System.out.print(" | " + this.c.get(i).getProcesare()+" | ");
			coada = coada + " | " + this.c.get(i).getProcesare() + " | ";
			//System.out.print(this.c.get(i).getSosire()+" ");
		}
		System.out.println();
		coada2 = coada;
		t.setText(coada2);
	}
	public void Scrie(String str) throws IOException {
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter("log.txt", true));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writer.append(' ');
		    writer.append(str); 
		    writer.close();
	}
	
	public void pause() {
        paused = true;
    }
	public void resume() {
        synchronized (pauseLock) {
            paused = false;
            pauseLock.notifyAll(); // Unblocks thread
        }
    }
	
	public void run() {
		while(ok){
			try {
				if(this.nrClienti>0) {
				Thread.sleep(c.get(0).getProcesare());
			//	System.out.println("timpul de sosire al clientului; "+ c.get(0).getSosire());
			//	System.out.println("la coada "+ this.id+ " se afla "+this.nrClienti+" clienti si timpul de asteptare este "+this.asteptare);
			//	afiseaza();
				this.sterge(c.get(0));}
				else {
					synchronized(pauseLock) {
						 if (paused) {
			                    try {
			                        pauseLock.wait(); 
			                    } catch (InterruptedException ex) {
			                        break;
					}
				}
			}
			}		
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(this.nrClienti == 0) {
			System.out.println("-----"+ this.id+ "-----");
		//	System.out.println("---------");
			paused = true;}
		}
		
		
	
	}
	
}

