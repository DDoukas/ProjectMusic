package Player;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Midi.Composition;

public class playerView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8877957127632014827L;
	private List<DefaultTableModel> tabs = new ArrayList<DefaultTableModel>();
	private List<JTable> tables = new ArrayList<JTable>();
	/*
	 * Για τα κουμπιά της αναποαραγογής παύσης διακοποί κτλ
	 */
	private JButton newCollection = new JButton("New");
	private JButton addFile = new JButton("Add File");
	private JButton delete = new JButton("Delete");
	private JButton moveUp = new JButton("Move Up");
	private JButton moveDown = new JButton("Move Down");
	private JButton open = new JButton("Open");
	private JButton save = new JButton("Save");
	private JButton saveAs = new JButton("Save As");
	private JButton defaul = new JButton("Default");
	private JButton shuffle = new JButton("Shuffle");

	private JToggleButton play = new JToggleButton();
	private JButton stop = new JButton();
	private JButton next = new JButton();
	private JButton prev = new JButton();
	/*
	 * Για διαχωρισμό της αριστερά στήλης και κάτω στην περιοχή που θα δίνονται
	 * Επίσης θα διαχωρίζουν μέσα στον χώρο όπου θα υπάρχουν τα tabs
	 */
	private JSeparator aristera = new JSeparator();
	private JSeparator arPanw = new JSeparator();
	private JSeparator arKatw = new JSeparator();

	/*
	 * To table που περιέχεται μέσα στο TabbedPane
	 */
	private DefaultTableModel model = new DefaultTableModel();
	private JTable table;

	/*
	 * Ο χώρος στον οποίο θα δημιουργούνται τα tabs
	 */
	private JTabbedPane tabbedPane = new JTabbedPane();

	private JLabel coll = new JLabel("Collection");
	private JLabel playb = new JLabel("Playback");

	public playerView() {
		JPanel player = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(600, 400);
		setTitle("Composition Player");
		getContentPane().add(player);
		player.setLayout(null);
		setLocationRelativeTo(null);

		coll.setBounds(29, 6, 56, 16);
		newCollection.setBounds(8, 31, 100, 25);
		addFile.setBounds(8, 61, 100, 25);
		open.setBounds(8, 91, 100, 25);
		save.setBounds(8, 121, 100, 25);
		saveAs.setBounds(8, 151, 100, 25);
		delete.setBounds(8, 181, 100, 25);
		moveUp.setBounds(8, 211, 100, 25);
		moveDown.setBounds(8, 241, 100, 25);
		playb.setBounds(31, 271, 56, 16);
		defaul.setBounds(8, 296, 100, 25);
		shuffle.setBounds(8, 326, 100, 25);



		play.setBounds(265, 25, 40, 40);
		play.setIcon(playCollection.playIcon);
		stop.setBounds(307, 25, 40, 40);
		stop.setIcon(new ImageIcon("Resources\\stopS.png"));
		prev.setBounds(349, 25, 40, 40);
		prev.setIcon(new ImageIcon("Resources\\previous.png"));
		next.setBounds(391, 25, 40, 40);
		next.setIcon(new ImageIcon("Resources\\next.png"));

		aristera.setBounds(117, 0, 11, 355);
		aristera.setOrientation(SwingConstants.VERTICAL);
		arPanw.setBounds(0, 26, 118, 2);
		arKatw.setBounds(0, 291, 118, 2);

		tabs.add(model);
		table = new JTable(tabs.get(0));
		tables.add(table);
		JScrollPane scroll = new JScrollPane(table);
		tabbedPane.addTab("Collection 1", scroll);

		tabbedPane.setBounds(117, 69, 465, 286);

		model.addColumn("Artist");
		model.addColumn("Title");

		player.add(tabbedPane);
		player.add(aristera);
		player.add(arKatw);
		player.add(arPanw);
		player.add(newCollection);
		player.add(addFile);
		player.add(open);
		player.add(save);
		player.add(saveAs);
		player.add(defaul);
		player.add(shuffle);
		player.add(coll);
		player.add(playb);
		player.add(play);
		player.add(stop);
		player.add(prev);
		player.add(next);
		player.add(delete);
		player.add(moveUp);
		player.add(moveDown);
	}

	public int getSelectedCollection() {
		return tabbedPane.getSelectedIndex();
	}
	
	public void addRow(Composition c, int x) {
		tabs.get(x).addRow(new Object[] { c.getOnomSinth(), c.getCompName() });
	}

	public void removeRow(int x, int y) {
		tabs.get(x).removeRow(y);
	}

	public void moveRowUp(int x, int y) {
		if (y > 0) {
			tabs.get(x).moveRow(y, y, y - 1);
			getSelectedTable().setRowSelectionInterval(y - 1, y - 1);
		}
	}

	public void moveRowDown(int x, int y) {
		if (y + 1 < tabs.get(x).getRowCount()) {
			tabs.get(x).moveRow(y, y, y + 1);
			getSelectedTable().setRowSelectionInterval(y + 1, y + 1);
		}
	}

	public void addCollection(Collection c) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Artist");
		model.addColumn("Title");
		tabs.add(model);
		JTable table = new JTable(tabs.get(tabs.size() - 1));
		tables.add(table);
		JScrollPane scroll = new JScrollPane(table);
		tabbedPane.addTab(c.getName(), scroll);
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		for (Composition comp : c.getCompositions()) {
			addRow(comp, getTabbedPane());
		}
	}
	
	public int getTabbedPane() {
		return tabbedPane.getSelectedIndex();
	}

	public void setTabbedPane(int x) {
		tabbedPane.setSelectedIndex(x);
	}

	public int getRowNumb() {
		return table.getRowCount();
	}

	public int getSelectedRow() {
		return tables.get(tabbedPane.getSelectedIndex()).getSelectedRow();
	}

	public void newCollection(ActionListener listen) {
		newCollection.addActionListener(listen);
	}

	public void addFileButton(ActionListener listen) {
		addFile.addActionListener(listen);
	}

	public void openButton(ActionListener listen) {
		open.addActionListener(listen);
	}

	public void saveButton(ActionListener listen) {
		save.addActionListener(listen);
	}

	public void saveAsButton(ActionListener listen) {
		saveAs.addActionListener(listen);
	}

	public void defaulButton(ActionListener listen) {
		defaul.addActionListener(listen);
	}

	public void shuffleButton(ActionListener listen) {
		shuffle.addActionListener(listen);
	}

	public void playButton(ItemListener playListener) {
		play.addItemListener(playListener);
	}

	public void stopButton(ActionListener listen) {
		stop.addActionListener(listen);
	}

	public void prevButton(ActionListener listen) {
		prev.addActionListener(listen);
	}

	public void nextButton(ActionListener listen) {
		next.addActionListener(listen);
	}

	public void deleteButton(ActionListener listen) {
		delete.addActionListener(listen);
	}

	public void moveUpButton(ActionListener listen) {
		moveUp.addActionListener(listen);
	}

	public void moveDownButton(ActionListener listen) {
		moveDown.addActionListener(listen);
	}

	public JToggleButton getPlay() {
		return play;
	}

	public JTable getSelectedTable() {
		return tables.get(tabbedPane.getSelectedIndex());
	}
	
}
