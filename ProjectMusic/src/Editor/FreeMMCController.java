package Editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Midi.Free;
import Midi.Note;

/**
 * Η κλάση αυτή επιφορτίζεται με τη διαχείριση της αλληλεπίδρασης της γραφικής
 * διεπαφής (FreeMMCView) με το μοντέλο (Free).
 * 
 */
public class FreeMMCController {
	private FreeMMCView theView;
	private Free theModel;
	private playMusic p = new playMusic();

	public FreeMMCController(FreeMMCView a, Free b) {
		theView = a;
		theModel = b;

		theView.writeToTextArea1("Composition: "
				+ theModel.getCompositionName() + "\n" + "Composer: "
				+ theModel.getArtistName() + "\nMode: Free\n");
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
				theModel, "Flute"));
		theView.playButton(new ControllerUtils.playButtonListener(theView,
				theModel, p));
		theView.aboutButton(new ControllerUtils.aboutButtonListener());
		theView.playNote(new playNoteListener());
		theView.restButton(new ControllerUtils.restButtonListener(theView,
				theModel));
	}

	private class playNoteListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Note n = new Note(e.getActionCommand(), theView.getNoteValue(),
					theView.getOctave(), theModel.getInstrument());
			theModel.playNote(n);
			theModel.addNote(n);
			theView.writeToTextArea2(n.toStringNoInstr() + " ");
		}
	}

}