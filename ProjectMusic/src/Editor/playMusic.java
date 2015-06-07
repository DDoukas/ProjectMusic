package Editor;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import org.jfugue.player.Player;

import Midi.Note;

/**
 * 
 * H κλάση αυτή είναι υπεύθυνη για την αναπαραγωγή και διακοπή της μουσικής στον
 * editor. Λειτουργεί ως thread.
 * 
 */
public class playMusic implements Runnable {
	public static ImageIcon playIcon = new ImageIcon("Resources\\play.png");
	public static ImageIcon stopIcon = new ImageIcon("Resources\\stop.png");

	// Οι νότες προς αναπαράγωγή
	private ArrayList<Note> notes = new ArrayList<Note>();
	
	private volatile boolean isRunning = true;
	
	// Το κουμπί αναπαραγώγης/διακοπής
	private JToggleButton button;

	public void run() {
		Player pan = new Player();
		int i = 0;
		int k = notes.size();
		while (isRunning == true && i < k) {
			pan.play(notes.get(i).toString());
			i++;
		}
		button.setIcon(playIcon);
		button.setSelected(false);
		isRunning = false;
	}

	public void setRunning(boolean b) {
		isRunning = b;
	}

	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
	}

	public void setButton(JToggleButton button) {
		this.button = button;
	}

}
