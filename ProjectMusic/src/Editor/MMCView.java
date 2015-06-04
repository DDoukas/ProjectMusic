package Editor;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public abstract class MMCView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4046784975718095678L;
	public static ImageIcon playIcon = new ImageIcon("Resources\\play.png");
	public static ImageIcon stopIcon = new ImageIcon("Resources\\stop.png");

	private JButton[] noteButtons = new JButton[12];

	private JLabel valueLbl = new JLabel("Note value");
	private JList<String> noteValues;
	
	private JLabel octaveLbl = new JLabel("Octave");
	private JList<String> octave;
	
	// File Buttons
	private JButton New = new JButton("New");
	private JButton Save = new JButton("Save");
	private JButton SaveAs = new JButton("Save As");
	private JButton Piano = new JButton("Piano");
	private JButton Guitar = new JButton("Guitar");
	private JButton Other = new JButton("Accordian");
	private JButton About = new JButton("About");

	// Other Buttons
	private JToggleButton Play = new JToggleButton();
	private JButton doNothing = new JButton("Do Nothing");
	private JButton retrograde = new JButton("Retrograde");
	private JButton transpose = new JButton("Transopose");
	private JButton reflect = new JButton("Reflect");

	/*
	 * Θα χρειαστούμε μερικά ακόμα JLabel για να εμφανίζονται τα δίαφορα
	 * χαρακτηριστικά του προγράμματος, οι νότες που έχουν πληκτρολογηθεί κτλ
	 */
	private JLabel Comp = new JLabel("Composition");
	private JLabel Instr = new JLabel("Instrument");

	/*
	 * 2-3 Separator τα οποία θα διαχωρίζουν δίαφορα κομμάτια του GUI όπως το
	 * κομμάτι που θα εμφανίζονται οι νότες, ένα κομμάτι που θα εμφανίζονται οι
	 * επιλογές κτλ
	 */
	private JSeparator sepKoumpia = new JSeparator();
	private JSeparator sepPanAr = new JSeparator();
	private JSeparator sepKatAr = new JSeparator();
	private JSeparator sepKatw = new JSeparator();
	private JSeparator sepKatwMesi = new JSeparator();
	private JSeparator sepPanw = new JSeparator();

	/*
	 * Θα χρειαστούμε 2-3 scrollPane για τα scrollable στοιχεία του πίνακα
	 */
	// η μάλλον όχι; private JScrollPane scrollPane;

	// Other stuff
	private JTextArea textArea = new JTextArea();
	private JTextArea textArea2 = new JTextArea();

	/*
	 * Θα δημιουργει το παράθυρο του Editor
	 */

	/**
	 * Αρχικοποιει το παράθυρο του Editor δινοντας μεγάλο μέρος των
	 * χαρακτηριστηκών του
	 */
	public MMCView() {
		JPanel mus = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setTitle("Synthesizer");

		// Configure note buttons
		noteButtons[0] = new JButton("C");
		noteButtons[1] = new JButton("C#");
		noteButtons[2] = new JButton("D");
		noteButtons[3] = new JButton("D#");
		noteButtons[4] = new JButton("E");
		noteButtons[5] = new JButton("F");
		noteButtons[6] = new JButton("F#");
		noteButtons[7] = new JButton("G");
		noteButtons[8] = new JButton("G#");
		noteButtons[9] = new JButton("A");
		noteButtons[10] = new JButton("A#");
		noteButtons[11] = new JButton("B");

		// Configure note value jlist
		String s[] = {"Eighth", "Quarter", "Half", "Whole"};
		noteValues = new JList<String>(s);
		noteValues.setSelectedIndex(1);
		noteValues.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Configure octave jlist
		String[] s2 = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		octave = new JList<String>(s2);
		octave.setSelectedIndex(5);
		octave.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		getContentPane().add(mus);
		mus.setLayout(null);

		// setBounds Labes
		Comp.setBounds(20, 4, 78, 16);
		Instr.setBounds(19, 178, 88, 16);

		// Set bounds file buttons

		New.setBounds(10, 68, 97, 25);
		Save.setBounds(10, 140, 97, 25);
		SaveAs.setBounds(10, 106, 97, 25);
		Piano.setBounds(10, 198, 97, 25);
		Guitar.setBounds(10, 228, 97, 25);
		Other.setBounds(10, 256, 97, 25);
		About.setBounds(10, 309, 97, 25);
		Play.setBounds(373, 309, 64, 64);

		// Edit file buttons
		Play.setIcon(playIcon);

		// Set bounds other buttons

		doNothing.setBounds(157, 37, 97, 25);
		retrograde.setBounds(280, 37, 97, 25);
		transpose.setBounds(398, 37, 97, 25);
		reflect.setBounds(517, 37, 97, 25);

		// edit other buttons
		doNothing.setBackground(Color.cyan);
		retrograde.setBackground(Color.cyan);
		transpose.setBackground(Color.cyan);
		reflect.setBackground(Color.cyan);
		doNothing.setVisible(false);
		retrograde.setVisible(false);
		transpose.setVisible(false);
		reflect.setVisible(false);

		// set bounds notes
		noteButtons[0].setBounds(157, 111, 42, 170);
		noteButtons[1].setBounds(195, 111, 49, 83);
		noteButtons[2].setBounds(242, 111, 42, 170);
		noteButtons[3].setBounds(279, 111, 49, 83);
		noteButtons[4].setBounds(325, 111, 42, 170);
		noteButtons[5].setBounds(362, 111, 42, 170);
		noteButtons[6].setBounds(398, 111, 49, 83);
		noteButtons[7].setBounds(445, 111, 42, 170);
		noteButtons[8].setBounds(482, 111, 49, 83);
		noteButtons[9].setBounds(529, 111, 42, 170);
		noteButtons[10].setBounds(565, 111, 49, 83);
		noteButtons[11].setBounds(612, 111, 42, 170);

		// set note value jlist and jlabel bounds
		noteValues.setBounds(157, 312, 80, 74);
		valueLbl.setBounds(167, 274, 80, 55);
		
		// set octave jlist and jlabel bounds
		octave.setBounds(695, 112, 50, 182);
		octaveLbl.setBounds(700, 74, 80, 55);
		
		//center jlist text
		DefaultListCellRenderer renderer = (DefaultListCellRenderer)noteValues.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER); 
		renderer = (DefaultListCellRenderer)octave.getCellRenderer();  
		renderer.setHorizontalAlignment(JLabel.CENTER); 

		// edit notes buttons
		for (JButton b : noteButtons) {
			if (b.getText().contains("#")) {
				b.setBackground(Color.black);
				b.setForeground(Color.white);
			} else
				b.setBackground(Color.white);
		}
		
		// set bounds Seperators
		sepKoumpia.setBounds(125, -2, 2, 400);
		sepPanAr.setBounds(0, 172, 127, 2);
		sepKatAr.setBounds(0, 294, 127, 2);
		sepKatw.setBounds(0, 399, 794, 14);
		sepKatwMesi.setBounds(426, 399, 2, 156);
		sepPanw.setBounds(335, 0, 447, 24);

		// edit seperators
		sepKoumpia.setOrientation(SwingConstants.VERTICAL);
		sepKoumpia.setBackground(Color.black);
		sepPanAr.setBackground(Color.black);
		sepKatAr.setBackground(Color.black);
		sepKatw.setBackground(Color.black);
		sepKatwMesi.setOrientation(SwingConstants.VERTICAL);
		sepKatwMesi.setBackground(Color.black);
		sepPanw.setOpaque(true);
		sepPanw.setBackground(Color.black);

		// add file buttons

		mus.add(New);
		mus.add(Save);
		mus.add(SaveAs);
		mus.add(Piano);
		mus.add(Guitar);
		mus.add(Other);
		mus.add(About);
		mus.add(Play);

		// add other buttons
		mus.add(doNothing);
		mus.add(retrograde);
		mus.add(reflect);
		mus.add(transpose);
		// Add notes
		for (JButton b : noteButtons) {
			mus.add(b);
		}

		// add note value selection list
		mus.add(noteValues);
		mus.add(valueLbl);
		
		// add octave selection list
		mus.add(octave);
		mus.add(octaveLbl);
		
		// add seperators
		mus.add(sepKoumpia);
		mus.add(sepPanAr);
		mus.add(sepKatAr);
		mus.add(sepKatw);
		mus.add(sepKatwMesi);
		mus.add(sepPanw);

		// add Labels
		mus.add(Comp);
		mus.add(Instr);

		// add Borders
		Border blackline = BorderFactory.createLineBorder(Color.black);
		noteValues.setBorder(blackline);
		octave.setBorder(blackline);
		textArea.setBorder(blackline);
		textArea2.setBorder(blackline);
		
		// other staff edit+add
		textArea.setBounds(0, 401, 428, 156);
		textArea.setEditable(false);
		mus.add(textArea);
		textArea2.setBounds(428, 401, 356, 156);
		textArea2.setEditable(false);
		mus.add(textArea2);
		setResizable(false);
		setLocationRelativeTo(null);
		mus.setVisible(true);

	}

	public void writeToTextArea1(String a) {
		textArea.append(a);
	}
	
	public void writeToTextArea2(String a) {
		textArea2.append(a);
		String[] b = textArea2.getText().split("\n");// new line after
		if (b[b.length - 1].length() >= 50)// every 50 characters
			textArea2.append("\n");
	}

	public void newButton(ActionListener listen) {
		New.addActionListener(listen);
	}

	public void saveAsButton(ActionListener listen) {
		SaveAs.addActionListener(listen);
	}

	public void saveButton(ActionListener listen) {
		Save.addActionListener(listen);
	}

	public void playButton(ItemListener listen) {
		Play.addItemListener(listen);
	}

	public void aboutButton(ActionListener listen) {
		About.addActionListener(listen);
	}

	/*
	 * Βάζουμε όλα τα Listener για όλα τα κουμπιά που πρέπει να ακούγονται νότες
	 */
	public void playNote(ActionListener lisForBtnC) {
		for (JButton b : noteButtons) {
			b.addActionListener(lisForBtnC);
		}
	}

	public void pianoButton(ActionListener listen) {
		Piano.addActionListener(listen);
	}

	public void guitarButton(ActionListener listen) {
		Guitar.addActionListener(listen);
	}

	public void otherButton(ActionListener listen) {
		Other.addActionListener(listen);
	}

	// Getters start
	public JButton[] getNoteButtons() {
		return noteButtons;
	}

	public JButton getGuitar() {
		return Guitar;
	}

	public JButton getPiano() {
		return Piano;
	}

	public JButton getOther() {
		return Other;
	}

	public JToggleButton getPlay() {
		return Play;
	}

	public JButton getDoNothing() {
		return doNothing;
	}

	public JButton getRetrograde() {
		return retrograde;
	}

	public JButton getTranspose() {
		return transpose;
	}

	public JButton getReflect() {
		return reflect;
	}

	public JLabel getInstrLabel() {
		return Instr;
	}
	
	public String getNoteValue() {
		switch (noteValues.getSelectedIndex()) {
		case 0:
			return "i";
		case 2:
			return "h";
		case 3:
			return "w";
		default:
			return "q";
		}
	}

	public JList<String> getValueList() {
		return noteValues;
	}

	public JLabel getValueLbl() {
		return valueLbl;
	}

	public int getOctave() {
		return octave.getSelectedIndex();
	}
	public JList<String> getOctaveList() {
		return octave;
	}
	
	public JLabel getOctaveLbl() {
		return octaveLbl;
	}
	// Getters end

}