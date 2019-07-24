package pk1.p8.a1.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FeldFehler extends JFrame implements ActionListener,WindowListener{

	private JLabel jl;
	private JButton jb;
	public FeldFehler(String nachricht,String titel){
		this.jl=new JLabel();
		this.jb=new JButton("OK");
		
		this.setTitle(titel);
		this.jl.setText(nachricht);
		jl.setForeground(Color.orange);
		this.setLayout(new BorderLayout());
		this.add(jl,BorderLayout.CENTER);
		this.add(jb, BorderLayout.SOUTH);
		jb.addActionListener(this);
		this.setBounds(100, 100, 400, 200);
		this.setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent event) {
		this.dispose();
	}

	
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		this.dispose();
		this.setVisible(false);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
