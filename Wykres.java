package Aplikacja.wykres;

import java.awt.EventQueue;

public class Wykres {
	public Wykres() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new WykresOkno();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}
}
