package tema2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("unused")

public class GUI {
JFrame f = new JFrame("threads");
JPanel p = new JPanel();

JLabel l1 = new JLabel("coada 1");
JLabel l2 = new JLabel("coada 2");
JLabel l3 = new JLabel("coada 3");
JLabel l4 = new JLabel("clienti");

JTextField t1 = new JTextField();
JTextField t2 = new JTextField();
JTextField t3 = new JTextField();
JTextField t4 = new JTextField();
JTextArea t5 = new JTextArea();
JScrollPane p1 = new JScrollPane(t5);

JButton b1 = new JButton("ok");

 public GUI() {
	 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 f.setSize(850,350);
	 p.setLayout(null);
	 
	 l1.setSize(100,30);
	 l1.setLocation(50,10);
	 
//	 t1.setSize(400,30);
//	 t1.setLocation(50,50);
	 
	 l2.setSize(100,30);
	 l2.setLocation(50,90);
	 
//	 t2.setSize(400,30);
//	 t2.setLocation(50,130);
	 
	 l3.setSize(100,30);
	 l3.setLocation(50,170);
	 
//	 t3.setSize(400,30);
//	 t3.setLocation(50,210);
	 
	 l4.setSize(70,30);
	 l4.setLocation(500,10);
	 
	 t4.setSize(70,30);
	 t4.setLocation(500,50);
	 
	 b1.setSize(50,30);
	 b1.setLocation(510,90);
	 
	 p1.setSize(250,250);
	 p1.setLocation(580,50);
	 
	 p.add(l1);
//	 p.add(t1);
	 p.add(l2);
//	 p.add(t2);
	 p.add(l3);
	 p.add(t3);
	 p.add(l4);
	 p.add(t4);
	 p.add(b1);
	 p.add(p1);
	 
	 f.setContentPane(p);
	 f.setVisible(true);
 }
}
