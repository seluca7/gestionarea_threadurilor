package tema2;

import java.util.ArrayList;
import java.util.List;

public class Planificator {
	private final Object lock = new Object();
	public ArrayList<Casa> k = new ArrayList<>();
	Casa k1,k2,k3;
	Thread t1,t2,t3;
	public ArrayList<Thread> t = new ArrayList<>();
	int j = 0;
	private int nrCase;
	
	public void setCase(int n) {
		this.nrCase = n;
	}
	
	public int getCase() {
		return this.nrCase;
	}
	public Planificator(int n) {
		this.setCase(n);
		for(int i = 0;i<n;i++) {
			Casa cx = new Casa(i);
			k.add(cx);
			Thread tr = new Thread(cx);
			tr.start();
		}
		
	/*	for(int i = 0;i<n;i++) {
			Thread tr = new Thread(k.get(i));
			tr.start();
		}*/
	}
	public Planificator(){
		this.setCase(3);
		k1 = new Casa(1);
		k2 = new Casa(2);
		k3 = new Casa(3);
		k.add(k1);
		k.add(k2);
		k.add(k3);
	/*	Client c1 = new Client();
		k1.adauga(c1);
		Client c2 = new Client();
		k2.adauga(c2);
		Client c3 = new Client();
		k3.adauga(c3);*/
		
		t1 = new Thread(k1);
		t2 = new Thread(k2);
		t3 = new Thread(k3);
	//	t1.start();
	//	t2.start();
	//	t3.start();
	
		
	}

	public int findMin() {
		int min = this.k.get(0).nrClienti;
		for(int i = 1;i<this.getCase();i++) {
			if(this.k.get(i).nrClienti<min) {
				min = this.k.get(i).nrClienti;
			}
		}
		return min;
	}
	public void distribuie(Client c) {
		for(int i = 0;i<this.getCase();i++) {
			int nr = this.findMin();
			//System.out.println(nr);
			if(this.k.get(i).nrClienti == nr) {
				this.k.get(i).adauga(c);
				if(this.k.get(i).paused == true) {
				this.k.get(i).resume();}
				return;
			}
		}
	}
}
