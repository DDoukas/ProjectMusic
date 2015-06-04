package Editor;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class selectMode extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3269857921056759212L;
	private JButton free = new JButton("Free");
	private JButton atonal = new JButton("Atonal");
	private JButton algorithmic = new JButton("Algorithmic");
	private JButton open = new JButton("Open");
	private JLabel comp = new JLabel("Composition");
	private JLabel sinth = new JLabel("Composer");
	private JTextField comptext = new JTextField();
	private JTextField sinthtext = new JTextField();

	public selectMode() {
		JPanel win = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(win);
		win.setLayout(null);
		setSize(250, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		free.setBounds(12, 13, 97, 25);
		atonal.setBounds(121, 13, 97, 25);
		algorithmic.setBounds(12, 51, 120, 25);
		open.setBounds(145, 51, 73, 25);
		comp.setBounds(12, 89, 80, 16);
		sinth.setBounds(12, 118, 80, 16);
		comptext.setBounds(90, 86, 116, 22);
		sinthtext.setBounds(90, 115, 116, 22);
		win.add(free);
		win.add(atonal);
		win.add(algorithmic);
		win.add(comp);
		win.add(sinth);
		win.add(comptext);
		win.add(sinthtext);
		win.add(open);
	}

	void freeListener(ActionListener listenForFree) {
		free.addActionListener(listenForFree);
	}

	void atonalListener(ActionListener listenForAtonal) {
		atonal.addActionListener(listenForAtonal);
	}

	void algorithmicListener(ActionListener listenForAlgorithmic) {
		algorithmic.addActionListener(listenForAlgorithmic);
	}

	void openListener(ActionListener listen) {
		open.addActionListener(listen);
	}

	public String getComp() {
		return comptext.getText();
	}

	public String getSinth() {
		return sinthtext.getText();
	}

	void errorMessage(String error) {
		JOptionPane.showMessageDialog(this, error);
	}
}
