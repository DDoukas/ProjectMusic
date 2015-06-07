package Editor;

/*This class contains Listener based classes designed 
 * to be utilized by Controller type classes
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import Midi.Composition;
import Midi.Note;
import Midi.playMusic;

public class ControllerUtils {

	public static class newButtonListener implements ActionListener {
		private MMCView view;

		public newButtonListener(MMCView view) {
			this.view = view;
		}

		public void actionPerformed(ActionEvent e) {
			view.dispose();
			selectModeModel theModel = new selectModeModel();
			selectMode theView = new selectMode();
			new selectModeController(theView, theModel);
			theView.setVisible(true);
		}
	}

	public static class saveAsButtonListener implements ActionListener {
		private Composition model;

		public saveAsButtonListener(Composition model) {
			this.model = model;
		}

		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser(Composition.compositionsPath);

			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Composition files (*.snthz)", "snthz");
			fc.setFileFilter(filter);
			if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				model.saveAs(fc.getSelectedFile().getPath());
			}
		}
	}

	public static class saveButtonListener implements ActionListener {
		private Composition model;

		public saveButtonListener(Composition model) {
			this.model = model;
		}

		public void actionPerformed(ActionEvent e) {
			model.save();
		}
	}

	public static class aboutButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JFrame frame = new JFrame();
			JPanel k = new JPanel();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			k.setLayout(null);
			frame.setSize(465, 265);
			k.setSize(300, 150);
			JLabel g = new JLabel();
			g.setBounds(0, -8, 465, 250);
			g.setIcon(new ImageIcon("Resources\\about.png"));
			k.add(g);
			frame.add(k);
			frame.setTitle("About Synthesizer");
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
		}
	}

	public static class playButtonListener implements ItemListener {
		private MMCView view;
		private Composition model;
		private playMusic p;

		public playButtonListener(MMCView view, Composition model, playMusic p) {
			this.view = view;
			this.model = model;
			this.p = p;
		}

		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED
					&& view.getPlay().getIcon() == playMusic.playIcon) {
				p.setRunning(true);
				p.setNotes(model.getNotes());
				Thread thread = new Thread(p);
				thread.start();
				view.getPlay().setIcon(playMusic.stopIcon);
			} else
				p.setRunning(false);
		}

	}

	public static class instrButtonListener implements ActionListener {

		private String instrument;
		private Composition model;
		private MMCView view;

		public instrButtonListener(MMCView view, Composition model,
				String instrument) {
			this.view = view;
			this.model = model;
			this.instrument = instrument;
		}

		public void actionPerformed(ActionEvent e) {
			String s = "I[" + instrument + "]";
			model.setInstr(s);
			view.writeToTextArea2(s + " ");
		}
	}
	
	public static class restButtonListener implements ActionListener {
		private MMCView view;
		private Composition model;

		public restButtonListener(MMCView view, Composition model) {
			this.view = view;
			this.model = model;
		}
		public void actionPerformed(ActionEvent e) {
			Note n = new Note("R", view.getNoteValue(), view.getOctave(), model.getInstr());
			model.playNote(n);
			model.addNote(n);
			view.writeToTextArea2(n.toStringNoInstr() + " ");
		}
	}
}
