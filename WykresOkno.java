
package Aplikacja.wykres;

import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class WykresOkno extends JFrame implements ItemListener {
	private static final Component TestMenu = null;
	private final JFrame panel;
	 private static Connection conn;
	JComboBox poczta1 = new JComboBox();
	Vector dane_poczta= new Vector();
	JComboBox poczta = new JComboBox(dane_poczta);
	
	public static String getTekst(){
		return textField.getText();
	}
	public WykresOkno(JFrame panel) {
		this.panel = panel;
	}
	private static JPasswordField passField;
	private static JTextField textField;
	public WykresOkno() throws ClassNotFoundException {
		super("Zrób wykres");
		JLabel content = new JLabel ("Podaj nazwę wykresu!");
		JButton wyslij = new JButton("Utwórz");
		textField = new JTextField("Wykres");
		JLabel etykieta_poczta = new JLabel ("Wybierz Ankietę:");
	    panel = new JFrame();
		//setLayout(new FlowLayout());
		panel.setLayout(new GridLayout(10,5));
		//panel.setBounds(220, 10, 600, 400);
		panel.setSize(new Dimension(600, 400));
		
		panel.add(etykieta_poczta);
		panel.add(poczta);
		//for (int i=0; i<20; i++)
			//dane_poczta.add("Poczta"+i);
		
		 try
	      {  
	         conn = getConnection();
	         Statement stat = conn.createStatement();

	         String query = "SELECT opis FROM ankieta";
	         ResultSet rs = stat.executeQuery(query);
	         while (rs.next())
	            poczta.addItem(rs.getString(1));
	         rs.close();
				
				conn.close();
	      }
	      catch (SQLException e)
	      {  System.out.printf("" + e);
	         while (e != null)
	         {
	            e = e.getNextException();
	         }
	      }
	      catch (IOException e)
	      {
	         System.out.printf("" + e);
	      }
		 
		poczta.addItemListener(this);
		//panel.add(poczta1);
		panel.add(content);
		panel.add(textField);
		panel.add(wyslij, BorderLayout.SOUTH);
		panel.setVisible(true);
		wyslij.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent le) {
			try {
				new PieChartExample().test();
					System.out.printf("Utworzono wykres");
					//panel.add(akcja);
					//panel.setVisible(false);
				} 
		catch (ClassNotFoundException e) {
				System.out.printf("Błąd przy tworzeniu wykresu");
				e.printStackTrace();
			}
		}});
		
		this.add(panel, BorderLayout.CENTER);
		panel.getContentPane().removeAll();
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setVisible(false);
		panel.add(TestMenu);
		// dodajemy panel html i odświeżamy widok

	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static Connection getConnection()
		      throws SQLException, IOException, ClassNotFoundException
		   {  
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("Tabela zostala otworzona pomyslnie.");
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": "
						+ e.getMessage());
				System.exit(0);

			}
		return conn;
		   }
}

