package clock;

import java.awt.EventQueue;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Canvas;

public class Clock {

	private JFrame frame;
    private JLabel lblClock;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clock window = new Clock();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void datetime()
	{
		Thread datetime = new Thread()
				{
			      public void run()
			      {
			    	  try
			  		{
			    		  for(;;)
			    		  {
			    			  Calendar cal= new GregorianCalendar();
			    			  int day=cal.get(Calendar.DAY_OF_MONTH);
			    			  int month=cal.get(Calendar.MONTH);
			    			  int year=cal.get(Calendar.YEAR);
			    			  
			    			  int second=cal.get(Calendar.SECOND);
			    			  int minute=cal.get(Calendar.MINUTE);
			    			  int hour= cal.get(Calendar.HOUR);
			    			  
			    			  lblClock.setText("Time- " + hour + ":" + minute + ":" + second + "     " + "Date- " +  day +"/" + month + "/" + year);
			    			  sleep(1000);//this is in ms
			    		  }
			  			
			  			
			  		}
			  		catch(Exception a)
			  		{
			  			
			  		}
			      }
			      
				};
		datetime.start();
		
		
		
		
	}

	/**
	 * Create the application.
	 */
	public Clock() {
		initialize();
		datetime();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setForeground(Color.YELLOW);
		frame.getContentPane().setForeground(Color.PINK);
		frame.setBounds(100, 100, 514, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblClock = new JLabel("clock");
		lblClock.setFont(new Font("Arial", Font.PLAIN, 25));
		lblClock.setBounds(53, 102, 356, 65);
		frame.getContentPane().add(lblClock);
		
		JLabel lblClock_1 = new JLabel("Clock");
		lblClock_1.setFont(new Font("Agency FB", Font.BOLD, 43));
		lblClock_1.setBounds(183, 29, 262, 49);
		frame.getContentPane().add(lblClock_1);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(331, 84, 100, 100);
		frame.getContentPane().add(canvas);
	}
}
