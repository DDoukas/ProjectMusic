package Player;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class playerView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8877957127632014827L;
	List<DefaultTableModel> tabs = new ArrayList<DefaultTableModel>();
	List<JTable> tables = new ArrayList<JTable>();
	/*
	 * Για τα κουμπιά της αναποαραγογής παύσης διακοποί κτλ
	 */
	JButton newCollection = new JButton("New Coll");
	JButton addFile = new JButton("Add File");
	JButton addFolder = new JButton("Add Folder");
	JButton open = new JButton("Open");
	JButton save = new JButton("Save");
	JButton defaul = new JButton("Default");
	JButton shuffle = new JButton("Shuffle");

	JButton play = new JButton("Play");
	JButton stop = new JButton("Stop");
	JButton pause = new JButton("Pause");
	JButton next = new JButton("Next");
	JButton prev = new JButton("Prev");
	/*
	 * Για διαχωρισμό της αριστερά στήλης και κάτω στην περιοχή που θα δίνονται
	 * Επίσης θα διαχωρίζουν μέσα στον χώρο όπου θα υπάρχουν τα tabs
	 */
	JSeparator aristera = new JSeparator();
	JSeparator arPanw = new JSeparator();
	JSeparator arKatw = new JSeparator();

	/*
	 * To table που περιέχεται μέσα στο TabbedPane
	 */
	DefaultTableModel model = new DefaultTableModel();
	JTable table;

	/*
	 * Ο χώρος στον οποίο θα δημιουργούνται τα tabs
	 */
	JTabbedPane tabbedPane = new JTabbedPane();
	/*
	 * θα ελέγχει την ένταση της μουσικής
	 */
	JSlider volume = new JSlider();
	/*
	 * Θα δείχνει το που βρίσκεται το κομμάτι
	 */
	JProgressBar minut = new JProgressBar();

	JLabel coll = new JLabel("Collection");
	JLabel playb = new JLabel("Playback");

	playerView() {
		JPanel player = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(600, 400);
		getContentPane().add(player);
		player.setLayout(null);
		setLocationRelativeTo(null);

		newCollection.setBounds(8, 31, 97, 25);
		addFile.setBounds(8, 69, 97, 25);
		addFolder.setBounds(8, 107, 97, 25);
		open.setBounds(8, 145, 97, 25);
		save.setBounds(8, 183, 97, 25);
		defaul.setBounds(8, 249, 97, 25);
		shuffle.setBounds(8, 287, 97, 25);

		coll.setBounds(29, 6, 56, 16);
		playb.setBounds(31, 215, 56, 16);

		minut.setBounds(316, 31, 254, 25);
		volume.setBounds(316, 5, 97, 23);

		play.setBounds(130, 28, 26, 25);
		stop.setBounds(165, 28, 26, 25);
		pause.setBounds(200, 28, 26, 25);
		prev.setBounds(235, 28, 26, 25);
		next.setBounds(270, 28, 26, 25);

		aristera.setBounds(117, 0, 11, 355);
		aristera.setOrientation(SwingConstants.VERTICAL);
		arPanw.setBounds(0, 26, 118, 2);
		arKatw.setBounds(0, 234, 118, 2);

		tabs.add(model);
		table = new JTable(tabs.get(0));
		tables.add(table);
		JScrollPane scroll = new JScrollPane(table);
		tabbedPane.addTab("Collection 1", scroll);

		tabbedPane.setBounds(117, 69, 465, 286);

		model.addColumn("Playing");
		model.addColumn("Artist");
		model.addColumn("Title");
		model.addColumn("Duration");

		player.add(tabbedPane);
		player.add(aristera);
		player.add(arKatw);
		player.add(arPanw);
		player.add(newCollection);
		player.add(addFile);
		player.add(addFolder);
		player.add(open);
		player.add(save);
		player.add(defaul);
		player.add(shuffle);
		player.add(coll);
		player.add(playb);
		player.add(play);
		player.add(stop);
		player.add(pause);
		player.add(prev);
		player.add(next);
		player.add(minut);
		player.add(volume);
	}

	public int getSelectedCollection() {
		return tabbedPane.getSelectedIndex();

	}

	public void addRo(String a, String b, String c, String d, int x) {
		tabs.get(x).addRow(new Object[] { a, b, c, d });
	}

	public void addCollection(String a) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Playing");
		model.addColumn("Artist");
		model.addColumn("Title");
		model.addColumn("Duration");
		tabs.add(model);
		JTable table = new JTable(tabs.get(tabs.size() - 1));
		tables.add(table);
		JScrollPane scroll = new JScrollPane(table);
		tabbedPane.addTab(a, scroll);
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

	public int getSelRow() {
		System.out.println(tables.get(tabbedPane.getSelectedIndex())
				.getSelectedRow());
		return tables.get(tabbedPane.getSelectedIndex()).getSelectedRow();

	}

	public void newCollection(ActionListener listen) {
		newCollection.addActionListener(listen);
	}

	public void addFileButton(ActionListener listen) {
		addFile.addActionListener(listen);
	}

	public void addFolderButton(ActionListener listen) {
		addFolder.addActionListener(listen);
	}

	public void openButton(ActionListener listen) {
		open.addActionListener(listen);
	}

	public void saveButton(ActionListener listen) {
		save.addActionListener(listen);
	}

	public void defaulButton(ActionListener listen) {
		defaul.addActionListener(listen);
	}

	public void shuffleButton(ActionListener listen) {
		shuffle.addActionListener(listen);
	}

	public void playButton(ActionListener listen) {
		play.addActionListener(listen);
	}

	public void stopButton(ActionListener listen) {
		stop.addActionListener(listen);
	}

	public void pauseButton(ActionListener listen) {
		pause.addActionListener(listen);
	}

	public void prevButton(ActionListener listen) {
		prev.addActionListener(listen);
	}

	public void nextButton(ActionListener listen) {
		next.addActionListener(listen);
	}

}
