package Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.filechooser.FileNameExtensionFilter;

import Midi.Composition;

/**
 * Η κλάση αυτή επιφορτίζεται με τη διαχείριση της αλληλεπίδρασης της γραφικής
 * διεπαφής (playerView) με το μοντέλο (playerModel).
 */
public class playerController {
	private playerView theView;
	private playerModel theModel = new playerModel();
	private playCollection player = new playCollection();

	public playerController(playerView theView, playerModel theModel) {

		this.theView = theView;
		this.theModel = theModel;

		this.theView.newCollection(new newCollectionListener());
		this.theView.addFileButton(new addFileListener());
		this.theView.openButton(new openListener());
		this.theView.saveButton(new saveListener());
		this.theView.saveAsButton(new saveAsListener());
		this.theView.defaulButton(new defaultListener());
		this.theView.shuffleButton(new shuffleListener());
		this.theView.playButton(new playListener());
		this.theView.stopButton(new stopListener());
		this.theView.prevButton(new prevListener());
		this.theView.nextButton(new nextListener());
		this.player.setButton(theView.getPlay());
		this.theView.deleteButton(new deleteListener());
		this.theView.moveUpButton(new moveUpListener());
		this.theView.moveDownButton(new moveDownListener());
	}

	private class newCollectionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String a = JOptionPane.showInputDialog("Collection Name");
			if (a != null && !a.isEmpty()) {
				Collection c = new Collection(a);
				theModel.addCollection(c);
				theView.addCollection(c);
			}
		}

	}

	private class addFileListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser(Composition.compositionsPath);

			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Composition files (*.snthz)", "snthz");
			fc.setFileFilter(filter);

			if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				Composition c = theModel.addFile(fc.getSelectedFile(),
						theView.getTabbedPane());
				theView.addRow(c, theView.getTabbedPane());
			}
		}
	}

	private class openListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser(Collection.collectionsPath);

			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Collection files (*.clxn)", "clxn");
			fc.setFileFilter(filter);

			if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				try {
					ObjectInputStream ois = new ObjectInputStream(
							new FileInputStream(fc.getSelectedFile()));
					Collection c = (Collection) ois.readObject();
					ois.close();
					theModel.addCollection(c);
					theView.addCollection(c);
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private class saveListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			theModel.saveCollection(theView.getSelectedCollection());
		}
	}

	private class saveAsListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser(Collection.collectionsPath);

			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Collection files (*.clxn)", "clxn");
			fc.setFileFilter(filter);
			if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				theModel.saveCollectionAs(theView.getSelectedCollection(), fc
						.getSelectedFile().getPath());
			}
		}
	}

	private class defaultListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			player.shuffle(false);
		}
	}

	private class shuffleListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			player.shuffle(true);
		}
	}

	private class playListener implements ItemListener {

		public void itemStateChanged(ItemEvent e) {
			JToggleButton play = theView.getPlay();
			if (e.getStateChange() == ItemEvent.SELECTED
					&& play.getIcon() == playCollection.playIcon) {
				if (player.isPaused())
					player.pause(false);
				else {
					player.setRunning(true);
					player.setTable(theView.getSelectedTable());
					player.setCompositions(theModel.getCompositions(theView
							.getSelectedCollection()));
					Thread thread = new Thread(player);
					thread.start();
				}
				theView.getPlay().setIcon(playCollection.pauseIcon);
			} else {
				theView.getPlay().setIcon(playCollection.playIcon);
				player.pause(true);
			}
		}
	}

	private class stopListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			player.setRunning(false);
		}
	}

	private class prevListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			player.previous();
		}
	}

	private class nextListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			player.next();
		}
	}

	private class deleteListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int x = theView.getTabbedPane();
			int y = theView.getSelectedRow();
			theModel.remove(x, y);
			theView.removeRow(x, y);
		}
	}

	private class moveUpListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int x = theView.getTabbedPane();
			int y = theView.getSelectedRow();
			theModel.moveUp(x, y);
			theView.moveRowUp(x, y);
		}
	}

	private class moveDownListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int x = theView.getTabbedPane();
			int y = theView.getSelectedRow();
			theModel.moveDown(x, y);
			theView.moveRowDown(x, y);
		}
	}
}
