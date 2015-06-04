package Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import Midi.playMusic;

public class playerController {
	private playerView theView;
	private playerModel theModel = new playerModel();
	private playMusic theMusic = new playMusic();

	public playerController(playerView theView, playerModel theModel) {

		this.theView = theView;
		this.theModel = theModel;

		this.theView.newCollection(new newCollectionListener());
		this.theView.addFileButton(new addFileListener());
		this.theView.addFolderButton(new addFolderListener());
		this.theView.openButton(new openListener());
		this.theView.saveButton(new saveListener());
		this.theView.defaulButton(new defaulListener());
		this.theView.shuffleButton(new shuffleListener());
		this.theView.playButton(new playListener());
		this.theView.stopButton(new stopListener());
		this.theView.pauseButton(new pauseListener());
		this.theView.prevButton(new prevListener());
		this.theView.nextButton(new nextListener());
	}

	class newCollectionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String a = JOptionPane.showInputDialog("Collection Name");
			theModel.addCollection(a);
			theView.addCollection(a);

		}

	}

	class addFileListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String a = JOptionPane.showInputDialog("File Name");
			String[] p = null;
			try {
				BufferedReader br = new BufferedReader(new FileReader(a));
				p = theModel.addFile(a, theView.getTabbedPane());
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			theView.addRo(p[0], p[1], p[2], p[3], theView.getTabbedPane());
		}
	}

	class addFolderListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

		}
	}

	class openListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

		}
	}

	class saveListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

		}
	}

	class defaulListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

		}
	}

	class shuffleListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

		}
	}

	class playListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// for(int i=theView.getSelRow();i<theView.getRowNumb();i++){
			int i = theView.getSelRow();
			theMusic.setRunning(true);
			// System.out.println(theView.getSelRow());
			theMusic.setNotes(theModel.getComposition(
					theView.getSelectedCollection(), i));
			Thread thread = new Thread(theMusic);
			thread.start();
			// }
		}
	}

	class stopListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			theMusic.setRunning(false);
		}
	}

	class pauseListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// /theMusic.pause();
		}
	}

	class prevListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

		}
	}

	class nextListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

		}
	}
}
