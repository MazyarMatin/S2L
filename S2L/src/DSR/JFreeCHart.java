package DSR;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PiePlot;
//import org.jfree.data.general.DefaultPieDataset;


public class JFreeCHart extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFreeCHart f = new JFreeCHart();
					f.setVisible(true);
					
					
			/*		
					f.getContentPane().setLayout(new BorderLayout());
					f.setSize(600, 400);
					f.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							System.exit(0);
						}
					});
					f.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					f.getContentPane().add(new JFreeCHart());
					f.setVisible(true);
				*/
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	
	public JFreeCHart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(31, 57, 400, 300);
		contentPane.add(panel);
		
		// piechartgroesse
		int cWidth = 300;
		int cHeight = 300;
		int minWidth = 350;
		int minHeight = 350;
		int maxWidth = 450;
		int maxHeight = 450; 
			
		DefaultPieDataset pieDataset = getPieDataset(7,3);		
		JFreeChart pieChart2D = ChartFactory.createPieChart("", pieDataset, false, true, true);
		ChartPanel pieChartPanel2D = new ChartPanel(pieChart2D, cWidth, cHeight, minWidth, 	minHeight, maxWidth, maxHeight,	false, 	false, 	false, 	false, 	false, 	false);
		pieChartPanel2D.setBackground(Color.WHITE);
			
		
		panel.add("PieChart2D", pieChartPanel2D);
		
		//
		PiePlot plot = (PiePlot)pieChart2D.getPlot(); 
		Color[] colors = {(new Color(200, 255, 180)), new Color(255, 150, 150)}; 
        PieRenderer renderer = new PieRenderer(colors); 
        renderer.setColor(plot, pieDataset);
		plot.setBackgroundAlpha(0);					//transparenter hintergrund
		plot.setOutlineVisible(false);				// no border
        
		pieChartPanel2D.setVisible(true);
		
		// soll neu zeichnen , macht aber so noch nix
	//	setChart( panel, pieChart2D, getPieDataset(2,2),pieChartPanel2D );
		
	}
	
	 private DefaultPieDataset getPieDataset(int x, int y)
	    {
	        DefaultPieDataset dataset = new DefaultPieDataset();
	        dataset.setValue("ok", x);
	        dataset.setValue("fehler", y);
	            	 
	        return dataset;
	
	    }

	 
	 //  eigene Farbe
	 public static class PieRenderer 
	    { 
	        private Color[] color; 
	        
	        public PieRenderer(Color[] color) 
	        { 
	            this.color = color; 
	        }        
	        
	        public void setColor(PiePlot plot, DefaultPieDataset dataset) 
	        { 
	            List <Comparable> keys = dataset.getKeys(); 
	            int aInt; 
	            
	            for (int i = 0; i < keys.size(); i++) 
	            { 
	                aInt = i % this.color.length; 
	                plot.setSectionPaint(keys.get(i), this.color[aInt]); 
	              //  plot.setSectionPaint(keys.get(0), (new Color(255, 150, 150))); 
	            //    plot.setSectionPaint(keys.get(1), (new Color(200, 255, 180))); 
	            
	                
	            } 
	 
	 
	        }
	 
	    }

	 // hier wird neu gezeichnet!!!!! verzehrt irgendwie, aber snst okay
	 
	 public void setChart(JPanel panel, JFreeChart pieChart2D, DefaultPieDataset dataset, ChartPanel chartPafnel){
		 int cWidth = 300;
			int cHeight = 300;
			int minWidth = 350;
			int minHeight = 350;
			int maxWidth = 450;
			int maxHeight = 450; 
		 panel.removeAll();
		 panel.revalidate(); // This removes the old chart 
		
		 pieChart2D = ChartFactory.createPieChart("", dataset, false, true, true);
	//	 pieChart2D = createChart(); 
		 pieChart2D.removeLegend(); 
		 
		
		    ChartPanel chartPanel = new ChartPanel(pieChart2D, cWidth, cHeight, minWidth, 	minHeight, maxWidth, maxHeight,	false, 	false, 	false, 	false, 	false, 	false); 
		    chartPanel.setBackground(Color.WHITE);
		    panel.setLayout(new BorderLayout()); 
		    panel.add(chartPanel); 
		  	panel.repaint(); // This method makes the new chart appear
		    System.out.println("ok");
		    PiePlot plot = (PiePlot)pieChart2D.getPlot(); 
			Color[] colors = {(new Color(200, 255, 180)), new Color(255, 150, 150)}; 
	        PieRenderer renderer = new PieRenderer(colors); 
	        renderer.setColor(plot, dataset);
			plot.setBackgroundAlpha(0);					//transparenter hintergrund
			plot.setOutlineVisible(false);
		}

	 

	
	 
}
