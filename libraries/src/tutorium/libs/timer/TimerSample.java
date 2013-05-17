package tutorium.libs.timer;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
		
		final TimerTask task = new TimerTask() {
			int counter = 5;
			@Override
			public void run() {
				label.setText(""+counter--);
				if (counter < 0) {
					this.cancel();
				}
				// label.setText( (new Time(System.currentTimeMillis())).toString() );				
			}
		};
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				task.cancel();
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		timer.schedule(task, 0, 1000);
		
		frame.add(label);
		
		frame.setVisible(true);

	}

}
