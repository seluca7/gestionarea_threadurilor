package tema2;
import java.util.Random;


public class Client {

private int sosire;
private int procesare;


	public void setSosire(int a) {
		this.sosire=a;
	}
	public void setProcesare(int a) {
		this.procesare=a;
	}
	public int getSosire() {
		return this.sosire;
	}
	public int getProcesare() {
		return this.procesare;
	}
	public Client() {
		Random r = new Random();
		this.setProcesare(r.nextInt(200 + 1 - 30)+30);
		this.setSosire(r.nextInt(20));
	}
	
}
