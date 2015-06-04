package Editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Midi.Atonal;
import Midi.Note;
import Midi.SymmetryActionOnNonValidAtonalRow;
import Midi.playMusic;

public class AtonalMMCController {
	private AtonalMMCView theView;
	private Atonal theModel;
	private playMusic p = new playMusic();

	public AtonalMMCController(AtonalMMCView a, Atonal b) {
		theView = a;
		theModel = b;

		theView.writeToTextArea1("Composition: " + theModel.getCompName()
				+ "\n" + "Composer: " + theModel.getOnomSinth()
				+ "\nMode: Atonal\n");
		theView.writeToTextArea2(theModel.getNotesString());

		p.setButton(theView.getPlay());
		theView.newButton(new ControllerUtils.newButtonListener(theView));
		theView.saveAsButton(new ControllerUtils.saveAsButtonListener(theModel));
		theView.saveButton(new ControllerUtils.saveButtonListener(theModel));
		theView.pianoButton(new ControllerUtils.instrButtonListener(theView,
				theModel, "Piano"));
		theView.guitarButton(new ControllerUtils.instrButtonListener(theView,
				theModel, "Guitar"));
		theView.otherButton(new ControllerUtils.instrButtonListener(theView,
				theModel, "Accordian"));
		theView.playButton(new ControllerUtils.playButtonListener(theView,
				theModel, p));
		theView.aboutButton(new ControllerUtils.aboutButtonListener());

		theView.playNote(new playNoteListener());
		theView.reflectButton(new reflectButtonListener());
		theView.retrogradeButton(new retrogradeButtonListener());
		theView.transposeButton(new transposeButtonListener());
		theView.doNothingButton(new doNothingButtonListener());

		String[] noteNames = { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#",
				"A", "A#", "B" };
		ArrayList<Note> notes = theModel.getNotes();
		for (int i = 0; i < notes.size(); i++) {
			for (int j = 0; j < noteNames.length; j++) {
				if (noteNames[j].equals(notes.get(i).getNote()))
					theView.getNoteButtons()[j].setEnabled(false);
			}
		}
	}

	private class playNoteListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Note n = new Note(e.getActionCommand(), theView.getNoteValue(),
					theView.getOctave(), theModel.getInstr());
			theModel.playNote(n);
			theModel.addNote(n);
			theView.writeToTextArea2(n.toStringNoInstr() + " ");
			if (theModel.getNoteNumber() == 12) {
				try {
					theModel.setPrax();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private class doNothingButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (theModel.getNoteNumber() == 12) {
				try {
					theModel.doNothing();
					theView.writeToTextArea2("\n" + "doNothing ");

				} catch (SymmetryActionOnNonValidAtonalRow e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Πρεπει να χρησιμοποιησετε και τις 12 νοτες");
			}
		}
	}

	private class reflectButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (theModel.getNoteNumber() == 12) {
				try {
					int a;
					try {
						a = Integer.parseInt(JOptionPane
								.showInputDialog("Range of Reflect"));
					} catch (NumberFormatException ex) {
						return;
					}
					theModel.reflect(a);
					theView.writeToTextArea2("\n" + "reflect " + "(" + a + ")");

				} catch (SymmetryActionOnNonValidAtonalRow e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Πρεπει να χρησιμοποιησετε και τις 12 νοτες");
			}
		}
	}

	private class transposeButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (theModel.getNoteNumber() == 12) {
				try {
					int a;
					try {
						a = Integer.parseInt(JOptionPane
								.showInputDialog("Range of Transpose"));
					} catch (NumberFormatException ex) {
						return;
					}
					theModel.transpose(a);
					theView.writeToTextArea2("\n" + "transpose " + "(" + a
							+ ")");

				} catch (SymmetryActionOnNonValidAtonalRow e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Πρεπει να χρησιμοποιησετε και τις 12 νοτες");
			}
		}
	}

	private class retrogradeButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (theModel.getNoteNumber() == 12) {
				try {
					theModel.retrograde();
					theView.writeToTextArea2("\n" + "retrograde");

				} catch (SymmetryActionOnNonValidAtonalRow e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Πρεπει να χρησιμοποιησετε και τις 12 νοτες");
			}
		}
	}
}