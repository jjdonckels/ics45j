package demos.week9;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A frame with three buttons, one above the other
 */
public class ThreeButtonsFrame extends JFrame {
	private JButton button1;
	private JButton button2;
	private JButton button3;

	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 100;

	public ThreeButtonsFrame() {
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	private void createComponents() {
		button1 = new JButton("Button 1");
		button2 = new JButton("Button 2");
		button3 = new JButton("Button 3");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		add(panel);
	}

	public static void main(String[] args) {
		JFrame frame = new ThreeButtonsFrame();
		frame.setTitle("Three buttons");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
