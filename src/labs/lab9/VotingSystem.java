package labs.lab9;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class VotingSystem
{
	static final int TEXT_WIDTH = 25;
	
	static final int NUM_CANDIDATES = 2;
	
	static final Object[] options = { "OK", "CANCEL" };
	
	static final int FRAME_WIDTH = 500;
	static final int FRAME_HEIGHT = 800;
	
	private JFrame mainFrame;
	
	
	private String electionName;
	private String candidateNameA;
	private String candidateNameB;
	private int propNumber;
	private double donationTotal;
	
	private JLabel donationLabel;
	
	private JLabel[][] propositionLabels;
	private JLabel[] candidateLabels;
	
	private Candidate[] candidatesArr;
	private Proposition[] propsArr;
	
	private ActionListener buttonListener;
	private JRadioButton candidateAButton;
	private JRadioButton candidateBButton;
	private boolean candidateButtonStates[];
	
	private JRadioButton[][] propButtons;
	private ButtonGroup[] propButtonGroups;
	private boolean propButtonStates[][];
	
	// class to listen to exit button in file menu
	class ExitItemListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}
	
	// class to listen to "Cast Vote" button
	class VoteListener implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
//			System.out.println("Cast Vote");
//			
//			// change donation total
//			donationTotal += 5.55;
//			donationLabel.setText(String.format("Donation total: $%.2f", donationTotal));
//			
//			
//			for(int i = 1; i < 5; ++i)
//				candidatesArr[1].addVote();
//			for(int i = 1; i <= 8; ++i)
//				candidatesArr[0].addVote();
//			
//			updateCandidateLabels();
//			
//			
//			for(int i = 0; i < propNumber; ++i)
//			{
//				propsArr[i].addYes();
//				propsArr[i].addNo();
//			}			
//			
//			updatePropositionLabels();
//			
//			mainFrame.revalidate();
//			mainFrame.repaint();
			
			// reset button states
			candidateButtonStates = new boolean[2];
			propButtonStates = new boolean[propNumber][2];
			for(int i = 0; i < propNumber; ++i)
			{
				propButtonStates[i][0] = false;
				propButtonStates[i][1] = false;
			}
			
			// set up button listener to listen to all buttons in "Cast Vote" window
			buttonListener = new ChoiceListener();
			
			// create main panel for "Cast Vote" screen
			JPanel castVoteInfoPanel = new JPanel();
			castVoteInfoPanel.setLayout(new BorderLayout());
			
			// create candidates voting panel
			JPanel candidateVotingPanel = new JPanel();
			candidateVotingPanel.setBorder(new TitledBorder(new EtchedBorder(), "Candidates"));
			// add candidate label to candidate voting panel
			candidateVotingPanel.add(new JLabel("Candidate:"));
			// create candidate radio buttons
			candidateAButton = new JRadioButton(candidateNameA);
			candidateAButton.addActionListener(buttonListener);
			candidateBButton = new JRadioButton(candidateNameB);
			candidateBButton.addActionListener(buttonListener);
			// add buttons to button group for exclusivity
			ButtonGroup candidateButtonGroup = new ButtonGroup();
			candidateButtonGroup.add(candidateAButton);
			candidateButtonGroup.add(candidateBButton);
			// add buttons to candidate voting panel
			candidateVotingPanel.add(candidateAButton);
			candidateVotingPanel.add(candidateBButton);
			// add candidates voting panel to main "Cast Vote" info panel
			castVoteInfoPanel.add(candidateVotingPanel, BorderLayout.NORTH);
			
			
			
			// create propositions voting panel
			JPanel propositionsVotingPanel = new JPanel();
			propositionsVotingPanel.setBorder(new TitledBorder(new EtchedBorder(), "Propositions:"));
			// set grid layout for all props to have their own row
			propositionsVotingPanel.setLayout(new GridLayout(propNumber, 1));
			// create array of subpanels so each proposition has its own
			JPanel[] propPanels = new JPanel[propNumber];
			// loop through and initialize all subpanels, adding a proposition label to each
			// then add each panel to the main propositions panel
			for (int i = 0; i < propNumber; ++i)
			{
				propPanels[i] = new JPanel();
				propPanels[i].add(new JLabel("Prop " + (i + 1) + ":"));
				propositionsVotingPanel.add(propPanels[i]);
			}
			// add propositions voting panel to main "Cast Vote" info panel
			castVoteInfoPanel.add(propositionsVotingPanel, BorderLayout.CENTER);
			
			// create propositions radio buttons
			propButtons = new JRadioButton[propNumber][2];
			propButtonGroups = new ButtonGroup[propNumber];
			for (int i = 0; i < propNumber; ++i)
			{
				// make ith yes button and listener
				propButtons[i][0] = new JRadioButton("YES");
				propButtons[i][0].addActionListener(buttonListener);
				
				// make ith no button and listener
				propButtons[i][1] = new JRadioButton("NO");
				propButtons[i][1].addActionListener(buttonListener);
				
				// add ith yes and no buttons to ith button group for exclusivity
				propButtonGroups[i] = new ButtonGroup();
				propButtonGroups[i].add(propButtons[i][0]);
				propButtonGroups[i].add(propButtons[i][1]);
				
				// add ith yes and no buttons to ith propPanel
				propPanels[i].add(propButtons[i][0]);
				propPanels[i].add(propButtons[i][1]);
				
			}
			
			
			// button construction list
			// construct buttons
			// add listeners
			// construct button group
			// add buttons to button group
			// add buttons to panel =========
			// each prop has 2 buttons, each button has 2 states
			// so we need a 2d array of props in rows and yes and no buttons in the 2 columns
			// then we need branches to update states depending on which button is selected
			// then we need to apply those state changes to the actual propositions once the okay button is clicked
			
			
			// create donation input panel 
			JPanel donationInputPanel = new JPanel();
			donationInputPanel.setBorder(new TitledBorder(new EtchedBorder(), "Donation:"));
			// add donation input panel to main "Cast Vote" info panel
			castVoteInfoPanel.add(donationInputPanel, BorderLayout.SOUTH);
			
			
			// display vote casting info dialog
			int castVoteResult = JOptionPane.showOptionDialog(mainFrame, castVoteInfoPanel, "Cast Vote",
			             JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
			             null, options, options[0]);
			
			if (castVoteResult == 0)
			{				
				// update candidate votes
				if (candidateButtonStates[0]) // a was selected
					candidatesArr[0].addVote();
				else if (candidateButtonStates[1]) // b was selected
					candidatesArr[1].addVote();
				
				updateCandidateLabels();
				
				
				// update proposition vote totals
				// loop through each proposition and check if it was voted for
				for (int i = 0; i < propNumber; ++i)
				{
					// add votes to the appropriate proposition selections
					if (propButtonStates[i][0]) // yes is selected for the ith prop
						propsArr[i].addYes();
					else if (propButtonStates[i][1]) // no is selected for the ith prop
						propsArr[i].addNo();
				}				
				
				updatePropositionLabels();
				
				
				mainFrame.revalidate();
				mainFrame.repaint();
			}
			
			
			
			
			
			
		}
	}
	
	// class to listen to all radio buttons in "Cast Vote" window
	class ChoiceListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
//						setLabelFont();
			if (candidateAButton.isSelected())
			{
				candidateButtonStates[0] = true;
				candidateButtonStates[1] = false;
			}
			else if (candidateBButton.isSelected())
			{
				candidateButtonStates[0] = false;
				candidateButtonStates[1] = true;
			}
			
			// every time "Cast Vote" is clicked, we need to update the state arrays for the buttons
			// we can loop through all the propositions, and check the yes and no buttons for each one individually
			for (int i = 0; i < propNumber; ++i)
			{
				if (propButtons[i][0].isSelected()) // yes is selected for the ith prop
				{
					propButtonStates[i][0] = true;
					propButtonStates[i][1] = false;
				}
				else if (propButtons[i][1].isSelected()) // no is selected for the ith prop
				{
					propButtonStates[i][0] = false;
					propButtonStates[i][1] = true;
				}
			}
			
			
		}
	}
	
	
	
	class Candidate
	{
		private String name;
		private int numVotes;
		
		public Candidate(String name)
		{
			this.name = name;
			numVotes = 0;
		}
		
		public String getName() {return name;}
		public int numVotes() {return numVotes;}
		public void addVote() {numVotes++;}
		
		public String toString() 
		{
			return name + ": " + numVotes;
		}
	}
	
	class Proposition
	{
		private int propNum;
		private int yesCount;
		private int noCount;
		
		public Proposition(int n)
		{
			propNum = n;
			yesCount = 0;
			noCount = 0;
		}
		
		public void addYes() {yesCount++;}
		public void addNo() {noCount++;}
		public int getNum() {return propNum;}
		public int getYes() {return yesCount;}
		public int getNo() {return noCount;}
		
		public String toString()
		{
			return "" + propNum + ": YES: " + 
					yesCount + " votes, NO: " + 
					noCount + " votes";
		}
	}
	
	public void updateCandidateLabels()
	{
		// update candidate labels with new vote counts
		for (int i = 0; i < candidateLabels.length; ++i)
		{
			candidateLabels[i].setText(candidatesArr[i].toString());
		}
		
		// bold candidate with more votes, or both if tied
		int votesA = candidatesArr[0].numVotes();
		int votesB = candidatesArr[1].numVotes();
		Font candidateFont = candidateLabels[0].getFont();
		
		if (votesA >= votesB)
			candidateLabels[0].setFont(new Font(candidateFont.getName(), Font.BOLD, candidateFont.getSize()));
		else
			candidateLabels[0].setFont(new Font(candidateFont.getName(), Font.PLAIN, candidateFont.getSize()));
		
		if (votesB >= votesA)
			candidateLabels[1].setFont(new Font(candidateFont.getName(), Font.BOLD, candidateFont.getSize()));
		else 
			candidateLabels[1].setFont(new Font(candidateFont.getName(), Font.PLAIN, candidateFont.getSize()));
	}
	
	public void updatePropositionLabels()
	{
		// loop through propositions, set text to update vote counts, and bold appropriate options
		for (int i = 0; i < propNumber; ++i)
		{
			// update yes count
			propositionLabels[i][1].setText("YES: " + propsArr[i].getYes() + " votes");
			// update no count
			propositionLabels[i][2].setText("NO: " + propsArr[i].getNo() + " votes");
			
			// bold appropriate label which has more votes, or both if tied
			Font propFont = propositionLabels[i][0].getFont();
			if (propsArr[i].getYes() >= propsArr[i].getNo())
				propositionLabels[i][1].setFont(new Font(propFont.getName(), Font.BOLD, propFont.getSize()));
			else 
				propositionLabels[i][1].setFont(new Font(propFont.getName(), Font.PLAIN, propFont.getSize()));
			
			if (propsArr[i].getNo() >= propsArr[i].getYes())
				propositionLabels[i][2].setFont(new Font(propFont.getName(), Font.BOLD, propFont.getSize()));
			else 
				propositionLabels[i][2].setFont(new Font(propFont.getName(), Font.PLAIN, propFont.getSize()));
			
		}
		
	}
	
	public VotingSystem() 
	{
		donationTotal = 0;
		
		candidateButtonStates = new boolean[2];
		
		// MAKE FIRST ELECTION INFO DIALOG
		
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
		
		
	
		
		
		
		
		boolean validElectionInput = false;
		
		
		do {
		
		// display election info dialog, and reprompt if fields left blank
		int electionInfoResult = JOptionPane.showOptionDialog(null, electionInfoPanel, "Election Info",
		             JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
		             null, options, options[0]);
		 
		 if (electionInfoResult == 1 || electionInfoResult == -1) System.exit(0);
		 
		 System.out.println("checkpoint 2");
		 
		 
		 System.out.println("dialog: " + electionInfoResult);
		 
		 electionName = electionNameField.getText().trim();
		 candidateNameA = candidateANameField.getText().trim();
		 candidateNameB = candidateBNameField.getText().trim();
		 // take proposition number from JComboBox and convert to int
		 propNumber = Integer.parseInt(((String) propNumsComboBox.getSelectedItem()));
		 
		 validElectionInput = !electionName.isEmpty() && 
				!candidateNameA.isEmpty() && 
				!candidateNameB.isEmpty();
		 
		} while (!validElectionInput);
		
		
		
		
		
		 
		 String input = electionName + "\n" + candidateNameA + "\n" + candidateNameB + "\n" + propNumber;
		 System.out.println(input);
		 
		 System.out.println("Checkpoint 3");
		 
		 
		 
		 
		// create frame for main voting window
		 
		
		 
		mainFrame = new JFrame(); 
		mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		mainFrame.setTitle("Voting System - James Donckels - 88857323");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add the file menu with exit button to the frame
		// create menu bar
		JMenuBar menuBar = new JMenuBar();
		mainFrame.setJMenuBar(menuBar);
		// add menu to the menu bar
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		// add exit menu item to file menu
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(exitItem);
		// add listener to exit menu item
		ActionListener exitListener = new ExitItemListener();
		exitItem.addActionListener(exitListener);
		
		
		// add label for election name at top of frame
		JLabel electionNameLabelHeader = new JLabel(electionName);
		// set up layout for voting window with main panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		// add election name header label to top of main panel
		mainPanel.add(electionNameLabelHeader, BorderLayout.NORTH);
		
		
		// add subpanel to hold a 3 x 1 grid of candidates, propositions, and notes
		JPanel votingInfoPanel = new JPanel();
		votingInfoPanel.setLayout(new GridLayout(3, 1));
		// add this panel to the main panel in the center
		mainPanel.add(votingInfoPanel, BorderLayout.CENTER);
		
		// set up candidate info panel
		JPanel candidateInfoPanel = new JPanel();
		candidateInfoPanel.setBorder(new TitledBorder(new EtchedBorder(), "Candidates:"));
		candidateInfoPanel.setLayout(new GridLayout(2, 1));
		// add candidate panel to voting info panel 
		votingInfoPanel.add(candidateInfoPanel);
		
		// populate candidateInfoPanel with labels of candidates names and vote counts
		// initialize candidate array info
		candidateLabels = new JLabel[NUM_CANDIDATES];
		candidatesArr = new Candidate[NUM_CANDIDATES];
		candidatesArr[0] = new Candidate(candidateNameA);
		candidatesArr[1] = new Candidate(candidateNameB);
		candidateLabels[0] = new JLabel(candidatesArr[0].toString());
		candidateLabels[1] = new JLabel(candidatesArr[1].toString());
		
		
		updateCandidateLabels();
		
		
		// add candidate labels to candidate info panel
		candidateInfoPanel.add(candidateLabels[0]);
		candidateInfoPanel.add(candidateLabels[1]);
		
		
		
		// set up proposition info panel
		JPanel propositionInfoPanel = new JPanel();
		propositionInfoPanel.setBorder(new TitledBorder(new EtchedBorder(), "Propositions:"));
		propositionInfoPanel.setLayout(new GridLayout(propNumber, 3));
		// add proposition panel to voting info panel 
		votingInfoPanel.add(propositionInfoPanel);
		
		// initialize proposition array info
		propositionLabels = new JLabel[propNumber][3];
		propsArr = new Proposition[propNumber];
		for (int i = 0; i < propNumber; ++i)
		{
			propsArr[i] = new Proposition(i + 1);
			propositionLabels[i][0] = new JLabel("" + (i + 1) + ":");
			propositionLabels[i][0].setHorizontalAlignment(SwingConstants.CENTER);
			
			propositionLabels[i][1] = new JLabel("YES: " + propsArr[i].getYes() + " votes");
			propositionLabels[i][2] = new JLabel("NO: " + propsArr[i].getNo() + " votes");
			
			propositionInfoPanel.add(propositionLabels[i][0]);
			propositionInfoPanel.add(propositionLabels[i][1]);
			propositionInfoPanel.add(propositionLabels[i][2]);
		}		
		
		updatePropositionLabels();
		
		
		
		// set up notes info panel
		JPanel notesInfoPanel = new JPanel();
		// add notes info panel to voting info panel
		votingInfoPanel.add(notesInfoPanel);
		
		// create donation label
		donationLabel = new JLabel(String.format("Donation total: $%.2f", donationTotal));
		// center donation label
		donationLabel.setHorizontalAlignment(JLabel.CENTER);
		// add donation label to north of notes info panel
		notesInfoPanel.add(donationLabel);
		
		// create subpanel for notes and text area
		JPanel notesPlusTextPanel = new JPanel();
		
		// create notes label
		JLabel notesLabel = new JLabel("Notes:");
		// move notes label to the center
		notesLabel.setHorizontalAlignment(JLabel.CENTER);
		// add notes label to notes and text subpanel
		notesPlusTextPanel.add(notesLabel);
		
		// create notes text area
		final int TEXT_ROWS = 5;
		final int TEXT_COLUMNS = 30;
		JTextArea notesTextArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
		notesTextArea.setEditable(true);
		notesTextArea.setLineWrap(true);
		// make text area scrollable by putting in a scroll pane
		JScrollPane notesScrollPane = new JScrollPane(notesTextArea);
		// add scroll pane to notes and text subpanel
		notesPlusTextPanel.add(notesScrollPane);
		
		// add notes and text subpanel to main notes info panel
		notesInfoPanel.add(notesPlusTextPanel);
		
		// create "Cast Vote" button
		JButton castVoteButton = new JButton("Cast Vote");
		// create a listener and connect it to the button
		ActionListener voteButtonListener = new VoteListener();
		castVoteButton.addActionListener(voteButtonListener);
		// center button
		castVoteButton.setHorizontalAlignment(SwingConstants.CENTER);
		// add button to south of notes info panel
		notesInfoPanel.add(castVoteButton);
		
		
		
		
		
		
		
		
		
		mainFrame.add(mainPanel);
		mainFrame.setVisible(true);
		 
		 
		 
	}
	
	
	
	
	public static void main (String[] args)
	{
		
		
		System.out.println("voting system");
		
		VotingSystem lab9 = new VotingSystem();
		
		
		
		
		
		
		 
		
		 
		 
		

		
		System.out.println("end program");
	}
	
}