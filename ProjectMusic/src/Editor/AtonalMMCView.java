package Editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AtonalMMCView extends MMCView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6808558756074374076L;

	public AtonalMMCView() {
		super();
		this.getDoNothing().setVisible(true);
		this.getReflect().setVisible(true);
		this.getRetrograde().setVisible(true);
		this.getTranspose().setVisible(true);

		for (final JButton b : getNoteButtons()) {
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					b.setEnabled(false);
				}
			});
		}
	}
	
	public void doNothingButton(ActionListener listen) {
		getDoNothing().addActionListener(listen);
	}

	public void reflectButton(ActionListener listen) {
		getReflect().addActionListener(listen);
	}

	public void retrogradeButton(ActionListener listen) {
		getRetrograde().addActionListener(listen);
	}

	public void transposeButton(ActionListener listen) {
		getTranspose().addActionListener(listen);
	}

}