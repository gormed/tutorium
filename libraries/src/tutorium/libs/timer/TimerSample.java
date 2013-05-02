package tutorium.libs.timer;
import java.awt.Graphics;
import java.sql.Date;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import sun.awt.HorizBagLayout;


public class TimerSample extends JFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new TimerSample();
		
		frame.setSize(200, 200);
		
		final JLabel label = new JLabel((new Time(System.currentTimeMillis())).toString() );

		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				label.setText( (new Time(System.currentTimeMillis())).toString() );				
			}
		};
		
		timer.schedule(task, 0, 1000);
		
		frame.add(label);
		
		frame.setVisible(true);

	}

}
