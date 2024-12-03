package demos.week9;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A frame with two buttons in the NORTH position of a border layout.
 */
public class TwoButtonsFrameRight extends JFrame {
	private JButton button1;
	private JButton button2;

	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 100;

	public TwoButtonsFrameRight() {
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	private void createComponents() {
		button1 = new JButton("Button 1");
		button2 = new JButton("Button 2");

		JPanel panel = new JPanel();
		panel.add(button1);
		panel.add(button2);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(panel, BorderLayout.NORTH);
		add(mainPanel);
	}

	public static void main(String[] args) {
		JFrame frame = new TwoButtonsFrameRight();
		frame.setTitle("Two north buttons");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
