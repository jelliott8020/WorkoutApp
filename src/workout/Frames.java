package workout;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frames {

	private JFrame frame;
	private JLabel askRetest;
	private JLabel date;
	private JLabel day;
	private JLabel workout;
	private JLabel personalRecord;
	private final int frameSize = 400;
	
	public Frames(Workout workout) {
		frame = new JFrame();
		frame.setLocation(100, 100);
		frame.setSize(frameSize, frameSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("My Workout App");
		
		makeFrame();
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void makeFrame() {
		// if workout = certain day of year, create certain # of frames/panels
		
		JButton retestMax = new JButton("Retested");
		retestMax.setName("retestButton");
		
		retestMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent retest) {
				retestClicked();
			}
		});
		
		JPanel retestPanel = new JPanel();
		retestPanel.add(retestMax);
		
		frame.add(retestPanel, BorderLayout.AFTER_LINE_ENDS);
		
		askRetest = new JLabel("Click here if you retested your maxes: ");
		askRetest.setName("askRetest");
		JPanel askPanel = new JPanel();
		askPanel.add(askRetest);
		
		
		
		
	}
	
	public void retestClicked() {
		
	}

	
}
