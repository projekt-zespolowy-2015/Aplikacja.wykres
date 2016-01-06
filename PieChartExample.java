package Aplikacja.wykres;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PieChartExample {
	public static Connection conn;
		String a, c;
		int b,d ;
		// Create a simple Bar chart
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//System.out.println("Podaj wartosci dla kandydatw");
		//Scanner odczyt = new Scanner(System.in); //obiekt do odebrania danych od uytkownika
	  //  a = odczyt.nextInt(); 
		
		public void test() throws ClassNotFoundException {
		
			 try
		      {  
		         conn = getConnection();
		         Statement stat = conn.createStatement();

		         String query = "SELECT nazwa FROM opcje";
		    //     String query1 = "SELECT id_opcje FROM opcje";
		        ResultSet rs = stat.executeQuery(query);	
		       //  while (rs.next()){
		         int i;
		         for (i=0; i<3; i++){
		        if (i==0) a=rs.getString(1);
		        	else c=rs.getString(1);
		         rs.next();
		         
		         }
			         String query1 = "SELECT id_opcje FROM opcje";
			       ResultSet rs1 = stat.executeQuery(query1);	
			      			        // while (rs.next()){	
			      for (i=0; i<3; i++){
			    	  if (i==0)  b=rs1.getInt(1);
			    	  else d=rs1.getInt(1);
			         rs1.next();
			         }
				         rs1.close();
				         rs.close();
					conn.close();
		      }
		      catch (SQLException e1)
		      {  System.out.printf("" + e1);
		         while (e1 != null)
		         {
		            e1 = e1.getNextException();
		         }
		      }
			  catch (IOException e)
		      {
		         System.out.printf("" + e);
		      }
			 dataset.setValue(b, a , a);
			 dataset.setValue(d, c , c);
			 String content = WykresOkno.getTekst();
		JFreeChart chart = ChartFactory.createBarChart3D(content,"Odpowiedź", "głosy", dataset, PlotOrientation.VERTICAL, true, true, false);
		chart.setBackgroundPaint(Color.lightGray); // Set the background colour of the chart
		chart.getTitle().setPaint(Color.black); // Adjust the colour of the title
		CategoryPlot p = chart.getCategoryPlot(); // Get the Plot object for a bar graph
		p.setBackgroundPaint(Color.white); // Modify the plot background
		p.setRangeGridlinePaint(Color.black); // Modify the colour of the plot gridlines
		try {
		ChartUtilities.saveChartAsJPEG(new File("C:\\Users\\Natalia\\wykres.jpg"), chart, 500, 300);
		} catch (IOException e1) {
		System.err.println("Problem z utworzeniem wykresu!.");
		}
}
public static Connection getConnection()
	      throws SQLException, IOException, ClassNotFoundException
	   {  
	try {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:test.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": "
					+ e.getMessage());
			System.exit(0);

		}
	return conn;
	   }
}
