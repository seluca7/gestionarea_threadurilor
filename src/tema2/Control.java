package tema2;

public class Control {

	GUI g = new GUI();
	int clienti;
	
	public Control() {
	g.b1.addActionListener(e ->{
		clienti = Integer.parseInt(g.t4.getText());
		SimulationManager s = new SimulationManager();
		s.nrClienti = clienti;
		
		s.p.k1.p.setSize(400,30);
		s.p.k1.p.setLocation(50,50);
		
		s.p.k2.p.setSize(400,30);
		s.p.k2.p.setLocation(50,130);
		
		s.p.k3.p.setSize(400,30);
		s.p.k3.p.setLocation(50,210);
		
		g.p.add(s.p.k1.p);
		g.p.add(s.p.k2.p);
		g.p.add(s.p.k3.p);
		
		Thread t = new Thread(s);
		t.start();
		g.t1.setText(s.p.k1.coada);
	});

	}
}
