package Editor;

/**
 * Συνδέει το μόντελο (selectModeModel) με τη γραφική διεπαφή (selectMode).
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Midi.Atonal;
import Midi.Composition;

public class selectModeController {
	private selectMode theView;
	private selectModeModel theModel;

	public selectModeController(selectMode theView, selectModeModel theModel) {
		this.theView = theView;
		this.theModel = theModel;

		this.theView.freeListener(new listenForFreeListener());
		this.theView.atonalListener(new listenForAtonalListener());
		this.theView.algorithmicListener(new listenForAlgo());
		this.theView.openListener(new openButtonListener());
	}

	class listenForFreeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			theModel.getFree().setCompositionName(theView.getComp());
			theModel.getFree().setArtistName(theView.getSinth());
			theModel.freeMode();
			theView.dispose();

		}
	}

	class listenForAtonalListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			theModel.getAtonal().setCompositionName(theView.getComp());
			theModel.getAtonal().setArtistName(theView.getSinth());
			theModel.atonalMode();
			theView.dispose();
		}
	}

	class listenForAlgo implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String a = JOptionPane.showInputDialog("Number of Notes");
			int k;
			try {
				k = Integer.parseInt(a);
			} catch (NumberFormatException ex) {
				return;
			}
			theModel.getAlgo().setCompositionName(theView.getComp());
			theModel.getAlgo().setArtistName(theView.getSinth());
			theModel.algorithmicMode(k);
			theView.dispose();
		}
	}

	class openButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser(Composition.compositionsPath);

			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Composition files (*.snthz)", "snthz");
			fc.setFileFilter(filter);
			
			if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				try {
					ObjectInputStream ois = new ObjectInputStream(
							new FileInputStream(fc.getSelectedFile()));
					Composition c = (Composition) ois.readObject();
					ois.close();
					
					String type = c.getType();
					if (type.equals("Free")) {
						theModel.getFree().copyValues(c);
						theModel.freeMode();
						theView.dispose();
					} else if (type.equals("Atonal")) {
						Atonal a = (Atonal) c;
						theModel.getAtonal().copyValues(a);
						theModel.atonalMode();
						theView.dispose();
					} else {
						theModel.getAlgo().copyValues(c);
						theModel.algorithmicMode();
						theView.dispose();
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
