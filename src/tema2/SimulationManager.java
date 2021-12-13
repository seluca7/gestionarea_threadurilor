package tema2;

import java.util.ArrayList;
import java.util.List;

public class SimulationManager implements Runnable {

	int nrClienti = 50;
	int gasiti = 0;
	public Planificator p;
	public ArrayList<Client> c = new ArrayList<>();
	
	public SimulationManager() {
			p = new Planificator();
			
	}
	public void generareClienti() {
		for(int i = 0;i<nrClienti;i++) {
			Client ct = new Client();
			this.c.add(ct);
		}
	}
	public void run() {
		int time = 0;
		this.generareClienti();
		p.t1.start();
		p.t2.start();
		p.t3.start();
		
		while(time <= 300) {
			for(int i = 0;i<nrClienti;i++) {
				//System.out.print(this.c.get(i).getProcesare()+" ");//
				if(this.c.get(i).getSosire() == time) {
					p.distribuie(this.c.get(i));
					System.out.println("client nou");
				//	p.k.get(0).afiseaza();
				//	p.k.get(1).afiseaza();
				//	p.k.get(2).afiseaza();
					gasiti++;
				}	
			}
			if(p.k1.procesati + p.k2.procesati + p.k3.procesati == nrClienti) {
				p.k1.ok = false;
				p.k2.ok = false;
				p.k3.ok = false;
			}
			time++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		p.t1.start();
//		p.t2.start();
//		p.t3.start();
	}
	
}
