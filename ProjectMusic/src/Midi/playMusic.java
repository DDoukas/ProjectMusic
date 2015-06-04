package Midi;

import java.util.ArrayList;

import javax.swing.JToggleButton;

import org.jfugue.player.Player;

import Editor.MMCView;

public class playMusic implements Runnable {
	private ArrayList<Note> notes;
	private volatile boolean isRunning = true;
	private JToggleButton button;

	public void run() {
		Player pan = new Player();
		int i = 0;
		int k = notes.size();
		while (isRunning == true) {
			if (i >= k) {
				isRunning = false;
				break;
			}
			pan.play(notes.get(i).toString());
			i++;
		}
		button.setIcon(MMCView.playIcon);
		button.setSelected(false);
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
