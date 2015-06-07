package Midi;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import org.jfugue.player.Player;

public class playMusic implements Runnable {
	public static ImageIcon playIcon = new ImageIcon("Resources\\play.png");
	public static ImageIcon stopIcon = new ImageIcon("Resources\\stop.png");
	
	private ArrayList<Note> notes = new ArrayList<Note>();
	private volatile boolean isRunning = true;
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
