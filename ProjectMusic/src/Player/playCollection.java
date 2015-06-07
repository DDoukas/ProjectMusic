package Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JToggleButton;

import org.jfugue.player.Player;

import Midi.Composition;
import Midi.Note;

public class playCollection implements Runnable {
	public static ImageIcon playIcon = new ImageIcon("Resources\\playS.png");
	public static ImageIcon pauseIcon = new ImageIcon("Resources\\pause.png");
	
	private List<Composition> compositions = new ArrayList<Composition>();
	private volatile boolean isRunning = true;
	private volatile boolean isPaused = false;
	private volatile boolean skip = false;
	private volatile int skipSteps = 0;
	private JToggleButton button;
	private JTable table;
	private boolean shuffleIt = false;

	public void run() {
		Player pan = new Player();
		int i = 0;
		int k = compositions.size();
		while (isRunning == true && i < k) {
			table.setRowSelectionInterval(i, i);
			int j = 0;
			ArrayList<Note> notes = compositions.get(i).getNotes();
			int l = notes.size();
			
			while (isRunning == true && j < l && !skip) {
				if (!isPaused) {
					pan.play(notes.get(j).toString());
					j++;
				}
			}

			k = compositions.size();
			if (shuffleIt) {
				Random r = new Random();
				int d = r.nextInt(k);
				while (d == i) {
					d = r.nextInt(k);
				}
				i = d;
			} else if (skip) {
				int m = i + skipSteps;
				if (m < 0)
					i = k + m;
				else if (m >= k)
					i = m - k;
				else
					i = m;
			} else
				i++;
			
			if (skip) {
				skip = false;
				skipSteps = 0;
			}
		}
		table.clearSelection();
		isRunning = false;
		isPaused = false;
		button.setIcon(playIcon);
		button.setSelected(false);
	}

	public void setRunning(boolean b) {
		isRunning = b;
	}

	public void pause(boolean b) {
		if (isRunning)
			isPaused = b;
	}
	
	public void setCompositions(List<Composition> compositions) {
		this.compositions = compositions;
	}

	public void setButton(JToggleButton button) {
		this.button = button;
	}

	public boolean isPaused() {
		return isPaused;
	}

	public void previous() {
		if (isRunning) {
			skip = true;
			skipSteps--;
		}
	}
	
	public void next() {
		if (isRunning) {
			skip = true;
			skipSteps++;
		}
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	public void shuffle(boolean b) {
		shuffleIt = b;
	}
	
}
