package Editor;

import Midi.Algorithmic;
import Midi.playMusic;

public class AlgorithmicMMCController {
	private AlgorithmicMMCView theView;
	private Algorithmic theModel;
	private playMusic p = new playMusic();

	public AlgorithmicMMCController(AlgorithmicMMCView a, Algorithmic b) {
		theView = a;
		theModel = b;

		theView.writeToTextArea1("Composition: " + theModel.getCompName() + "\n"
				+ "Composer: " + theModel.getOnomSinth() + "\nMode: Algorithmic\n");
		theView.writeToTextArea2(theModel.getNotesString());

		p.setButton(theView.getPlay());
		theView.newButton(new ControllerUtils.newButtonListener(theView));
		theView.saveAsButton(new ControllerUtils.saveAsButtonListener(theModel));
		theView.saveButton(new ControllerUtils.saveButtonListener(theModel));
		theView.playButton(new ControllerUtils.playButtonListener(theView, theModel, p));
		theView.aboutButton(new ControllerUtils.aboutButtonListener());
	}
	
}