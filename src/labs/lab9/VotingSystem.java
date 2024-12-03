package labs.lab9;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VotingSystem
{
	
	public static void main (String[] args)
	{
		System.out.println("voting system");
//		Object[] options = { "OK", "CANCEL" };
		
		JFrame mainFrame = new JFrame();
		
		final int TEXT_WIDTH = 25;
		
		
//		JOptionPane pane = new JOptionPane();
//		pane.setMessage("Election Info");
		
		// make "Election Name:" Label
		JLabel electionNameLabel = new JLabel("Election Name:");
		// make "Election Name:" text field
		final JTextField electionNameField = new JTextField(TEXT_WIDTH);
		// make "Election Name:" subpanel
		JPanel electionNameSubPanel = new JPanel();
		electionNameSubPanel.add(electionNameLabel);
		electionNameSubPanel.add(electionNameField);
		
		// make "Candidate A Name:" Label
		JLabel candidateANameLabel = new JLabel("Candidate A Name:");
		// make "Candidate A Name:" text field
		final JTextField candidateANameField = new JTextField(TEXT_WIDTH);
		// make "Candidate A Name:" subpanel
		JPanel candidateANameSubPanel = new JPanel();
		candidateANameSubPanel.add(candidateANameLabel);
		candidateANameSubPanel.add(candidateANameField);
		
		// make "Candidate B Name:" Label
		JLabel candidateBNameLabel = new JLabel("Candidate B Name:");
		// make "Candidate B Name:" text field
		final JTextField candidateBNameField = new JTextField(TEXT_WIDTH);
		// make "Candidate B Name:" subpanel
		JPanel candidateBNameSubPanel = new JPanel();
		candidateBNameSubPanel.add(candidateBNameLabel);
		candidateBNameSubPanel.add(candidateBNameField);
		
		// make "Num propositions:" label
		JLabel numPropsLabel = new JLabel("Num propositions:");
		// make "num propositions combo box / dropdown menu"
		JComboBox propNumsComboBox = new JComboBox();
		for (int i = 1; i <= 15; ++i) propNumsComboBox.addItem("" + i);
		// put label and combo box into subpanel
		JPanel numPropsSubPanel = new JPanel();
		numPropsSubPanel.add(numPropsLabel);
		numPropsSubPanel.add(propNumsComboBox);
		
		// add election name and candidate name subpanels to a grid panel to stack them
		JPanel electionInfoPanel = new JPanel();
		electionInfoPanel.setLayout(new GridLayout(4, 1));
		
		electionInfoPanel.add(electionNameSubPanel);
		electionInfoPanel.add(candidateANameSubPanel);
		electionInfoPanel.add(candidateBNameSubPanel);
		electionInfoPanel.add(numPropsSubPanel);
		
		
//		electionInfoPanel.add(electionNameLabel);
//		electionInfoPanel.add(electionNameField);
		
//		electionInfoPanel.add(candidateANameLabel);
//		electionInfoPanel.add(candidateANameField);
//		
//		electionInfoPanel.add(candidateBNameLabel);
//		electionInfoPanel.add(candidateBNameField);
		
		
		
		// add "Election Name:" to pane
//		pane.add(electionNamePanel);
		
		
		
//		mainFrame.add(electionInfoPanel);
//		mainFrame.setVisible(true);
		
		
//		int a = JOptionPane.showOptionDialog(null, "message", "title", 0, JOptionPane.PLAIN_MESSAGE, null, options, null);
//		
//		System.out.println(a + " " + JOptionPane.OK_OPTION);
//		JDialog dialog = pane.createDialog("Dialog title");
		
//		JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
		
//		JOptionPane.showInternalMessageDialog(electionNamePanel, "information",
//	             "information", JOptionPane.INFORMATION_MESSAGE);
		
//		JOptionPane.showConfirmDialog(null,
//	             "choose one", "choose one", JOptionPane.YES_NO_OPTION);
		
//		JOptionPane.showInternalConfirmDialog(electionNamePanel,
//	             "please choose one", "information",
//	             JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		
//		Object toDisplay = electionInfoPanel;
		
		System.out.println("checkpoint 1");
		
		Object[] options = { "OK", "CANCEL" };
		 int result = JOptionPane.showOptionDialog(null, electionInfoPanel, "Election Info",
		             JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
		             null, options, options[0]);
		 
		 System.out.println("checkpoint 2");
		 
		 System.out.println("dialog: " + result);
		 
		 int electionName = electionNameField.getText().trim().length();
		 String nameA = candidateANameField.getText();
		 String nameB = candidateBNameField.getText();
		 String propNumber = (String) propNumsComboBox.getSelectedItem();
		 
		 String input = electionName + "\n" + nameA + "\n" + nameB + "\n" + propNumber;
		 System.out.println(input);
		 
		 System.out.println("Checkpoint 3");
		 
		 
		mainFrame.setSize(400, 400);
		mainFrame.setTitle("Frame Title");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea data = new JTextArea(10, TEXT_WIDTH);
		data.setText(input);
		data.setEditable(false);
		
		mainFrame.add(data);
		
		mainFrame.setVisible(true);
		 
		 
		
//		String inputValue = JOptionPane.showInputDialog("Please input a value");
//		System.out.println("Input: " + inputValue + "\n");
		
		/*Object[] possibleValues = //{ "First", "Second", "Third" };
			{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

		Object toDisplay = electionInfoPanel;
		
		 Object selectedValue = JOptionPane.showInputDialog(null,
		             toDisplay, "Election Info",
		             JOptionPane.PLAIN_MESSAGE, null,
		             possibleValues, possibleValues[0]);
		 System.out.println("selection: " + selectedValue); */
		
//		Object[] possibleValues = { "First", "Second", "Third" };
//
//		 Object selectedValue = JOptionPane.showInputDialog(null,
//		             "Choose one", "Input",
//		             JOptionPane.WARNING_MESSAGE, null,
//		             possibleValues, possibleValues[0]);
		
		
		
		
		
		
//		mainFrame.add(pane);
		
		
//		dialog.add(pane);
//		dialog.setVisible(true);
		
		
		
//		dialog.setVisible(true);
		
		
//		JOptionPane.showOptionDialog(null, "Click OK to continue", "Warning",
//		             JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
//		             null, options, options[0]);
		
//		dialog.show();
		
//		JFrame frame = new JFrame();
//		frame.setSize(300, 400);
//		frame.setTitle("Frame title");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		frame.add(pane);
//		
//		frame.setVisible(true);
		
		
//		final JOptionPane optionPane = new JOptionPane(
//			    "The only way to close this dialog is by\n"
//			    + "pressing one of the following buttons.\n"
//			    + "Do you understand?",
//			    JOptionPane.QUESTION_MESSAGE,
//			    JOptionPane.YES_NO_OPTION);
//		optionPane.setVisible(true);
//		mainFrame.add(optionPane);
//		mainFrame.setVisible(true);
		
		System.out.println("end program");
	}
	
}