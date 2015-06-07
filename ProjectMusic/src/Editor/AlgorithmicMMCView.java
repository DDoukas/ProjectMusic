package Editor;

import javax.swing.JButton;

public class AlgorithmicMMCView extends MMCView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4432463298068785956L;

	/**
	 * Κατασκευαστής που καλεί την super και απενεργοποιεί ή κρύβει γραφικά
	 * τμηματα που δεν χρησιμοποιούνται
	 */
	public AlgorithmicMMCView() {
		super();
		for (JButton b : getNoteButtons()) {
			b.setEnabled(false);
		}
		getInstrLabel().setVisible(false);
		getGuitar().setVisible(false);
		getOther().setVisible(false);
		getPiano().setVisible(false);
		getValueList().setVisible(false);
		getValueLbl().setVisible(false);
		getOctaveList().setVisible(false);
		getOctaveLbl().setVisible(false);
		getRest().setVisible(false);
	}

}